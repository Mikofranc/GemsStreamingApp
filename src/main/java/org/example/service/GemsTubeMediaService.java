package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.example.data.model.Media;
import org.example.data.model.User;
import org.example.data.repo.MediaRepo;
import org.example.dto.request.UploadMediaRequest;
import org.example.dto.response.UploadMediaResponse;
import org.example.exception.GemsTubeException;
import org.example.exception.MediaUploadException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class GemsTubeMediaService implements  MediaService{
    private final CloudService cloudService;
    private final MediaRepo mediaRepo;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Override
    public UploadMediaResponse upload(UploadMediaRequest request) throws GemsTubeException {
        User user = userService.getUserById(request.getCreatorId());
        String fileUrl = cloudService.upload(request.getFile());
        var media = modelMapper.map(request , Media.class);
        media.setUrl(fileUrl);
        media.setUploader(user);

        var savedMedia =mediaRepo.save(media);
        UploadMediaResponse response = new UploadMediaResponse();
        response.setMediaId(savedMedia.getId());
        response.setMessage("saved");
        return response;
    }
}
