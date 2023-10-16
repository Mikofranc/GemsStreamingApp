package org.example.service;

import org.example.data.model.User;
import org.example.data.repo.UserRepo;
import org.example.dto.request.RegisterRequest;
import org.example.dto.response.RegisterResponse;
import org.example.exception.GemsTubeException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {
    @Autowired
    private  UserService userService;
    @Autowired
    private UserRepo userRepo;
    @Test
    public void testToRegisterUser(){
        RegisterRequest request = new RegisterRequest();
        request.setPassword("password");
        request.setName("chinedu");
        request.setEmail("chisom@gmail.com");
        assertNotNull(userService.register(request));
        assertThat(userRepo.count(), is(3L));
    }
    @Test
    public void testGetUserById() throws GemsTubeException {
        User user = userService.getUserById(1L);
        System.out.println(user.toString());
        assertNotNull(user);
    }

}