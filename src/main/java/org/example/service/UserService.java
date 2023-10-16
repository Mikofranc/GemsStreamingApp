package org.example.service;

import org.example.data.model.User;
import org.example.dto.request.RegisterRequest;
import org.example.dto.response.RegisterResponse;
import org.example.exception.GemsTubeException;

public interface UserService {
    RegisterResponse register(RegisterRequest request);

    User getUserById(Long creatorId) throws GemsTubeException;
}
