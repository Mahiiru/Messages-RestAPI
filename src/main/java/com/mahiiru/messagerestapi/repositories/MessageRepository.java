package com.mahiiru.messagerestapi.repositories;

import com.mahiiru.messagerestapi.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Long> {
}
