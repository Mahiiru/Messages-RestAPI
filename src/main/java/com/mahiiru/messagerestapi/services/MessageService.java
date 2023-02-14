package com.mahiiru.messagerestapi.services;


import com.mahiiru.messagerestapi.models.Message;
import com.mahiiru.messagerestapi.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository repository;


    public List<Message> getAllMessages() {
        return repository.findAll();
    }

    public Optional<Message> getMessageByID(Long id) {
        return repository.findById(id);
    }

    public Message createMessage(Message message) {
        return repository.save(message);
    }

    public Message updateMessage(Long id, Message message) {
        Message existingMessage = repository.findById(id).orElseThrow();
        existingMessage.setText(message.getText());
        existingMessage.setDate(message.getDate());
        return repository.save(existingMessage);
    }

    public void deleteMessage(Long id) {
        repository.deleteById(id);
    }
}
