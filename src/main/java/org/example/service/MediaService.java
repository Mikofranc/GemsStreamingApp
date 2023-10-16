package org.example.service;

import org.example.dto.request.UploadMediaRequest;
import org.example.dto.response.UploadMediaResponse;
import org.example.exception.GemsTubeException;
import org.example.exception.MediaUploadException;

public interface MediaService {
    UploadMediaResponse upload(UploadMediaRequest request) throws GemsTubeException;
}
