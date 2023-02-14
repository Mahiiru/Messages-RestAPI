package com.mahiiru.messagerestapi.models;


import com.fasterxml.jackson.annotation.JsonView;
import com.mahiiru.messagerestapi.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Message {

    @Id
    @GeneratedValue
    private Long id;
    private String text;
    private LocalDateTime date;

    @JsonView(JsonViews.MessageSummary.class)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
