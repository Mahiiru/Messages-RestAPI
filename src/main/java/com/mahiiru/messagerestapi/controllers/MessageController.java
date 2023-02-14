package com.mahiiru.messagerestapi.controllers;


import com.mahiiru.messagerestapi.models.Message;
import com.mahiiru.messagerestapi.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {


    @Autowired
    private MessageService service;

    @GetMapping
    public ResponseEntity<List<Message>> getAllMessages(){
        return ResponseEntity.ok(service.getAllMessages);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Message> getMessageByID(@PathVariable Long id){
        return ResponseEntity.ok(service.getMessageByID(id));
    }

    @PostMapping
    public ResponseEntity<Message> createMessage(@RequestBody Message message){
        Message createdMessage = service.createMessage(message);
        return ResponseEntity.created(URI.create("/" + createdMessage.getId())).body(createdMessage);
    }

    @PutMapping
    @RequestMapping("/update/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable Long id, @RequestBody Message message){
        Message updatedMessage = service.updateMessage(id,message);
        return ResponseEntity.ok(updatedMessage);
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public  ResponseEntity<Void> deleteMessage(@PathVariable Long id){
        service.deleteMessage(id);
        return ResponseEntity.noContent().build();
    }
}
