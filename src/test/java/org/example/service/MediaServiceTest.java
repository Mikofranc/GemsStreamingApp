package org.example.service;

import com.cloudinary.api.ApiResponse;
import lombok.AllArgsConstructor;
import org.example.dto.request.RegisterRequest;
import org.example.dto.request.UploadMediaRequest;
import org.example.dto.response.UploadMediaResponse;
import org.example.exception.GemsTubeException;
import org.example.exception.MediaUploadException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@AllArgsConstructor
@SpringBootTest
public class MediaServiceTest {
    private MediaService mediaService;
    private UserService userService;
    @Test
    public void testToUploadMediaFile() throws GemsTubeException {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setEmail("test@gmail.com");
        registerRequest.setName("mike");
        registerRequest.setPassword("1234");
        var user = userService.register(registerRequest);
        UploadMediaRequest request = new UploadMediaRequest();
        request.setCreatorId(user.getId());
        request.setTitle("okay");
        request.setDescription("test in to upload image");
        request.setFile(CloudServiceTest.getMultiMediaTest());
        UploadMediaResponse response = mediaService.upload(request);
        assertNotNull(response);
    }
}
