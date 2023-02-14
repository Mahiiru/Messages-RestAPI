package com.mahiiru.messagerestapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mahiiru.messagerestapi.models.User;

import java.time.LocalDateTime;

public class JsonViews {
    public interface MessageSummary{
        Long getId();
        String getText();
        LocalDateTime getDate();

        @JsonIgnoreProperties(value = {"password"})
        User getUser();
    }
}
