package org.example.service;

import lombok.AllArgsConstructor;
import org.example.data.model.User;
import org.example.data.repo.UserRepo;
import org.example.dto.request.RegisterRequest;
import org.example.dto.response.RegisterResponse;
import org.example.exception.GemsTubeException;
import org.example.exception.UserNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class GemsTubeUserService implements UserService{

    private final UserRepo userRepo;
    @Override
    public RegisterResponse register(RegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setName(user.getName());
        var savedUser = userRepo.save(user);

        RegisterResponse response = new RegisterResponse();
        response.setId(savedUser.getId());
        response.setName(savedUser.getName());
        response.setEmail(savedUser.getEmail());
        response.setPassword(savedUser.getPassword());
        return response;
    }

    @Override
    public User getUserById(Long creatorId) {
        return userRepo.findById(creatorId)
                .orElseThrow(()->new UserNotFound("User not found"));
    }
}
