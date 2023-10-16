package org.example.service;

import org.example.exception.MediaUploadException;
import org.springframework.web.multipart.MultipartFile;

public interface CloudService {
    String upload(MultipartFile file)throws MediaUploadException;
}
