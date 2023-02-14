package com.mahiiru.messagerestapi.controllers;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserController {


    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String email;
    private String password;
    private String url_image_profile;
}
