package org.example.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.exception.MediaUploadException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
@AllArgsConstructor
@Slf4j
@Service
public class CloudinaryCloudService implements CloudService{
    private final Cloudinary cloudinary;
    @Override
    public String upload(MultipartFile file) throws MediaUploadException {
        try {
            Map<?, ? > response = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("resource_type", "auto"));
            log.info("upload response --> {}", response);
            return (String) response.get("secure_url");
        }catch (Exception exception){
                throw new MediaUploadException(exception.getMessage());
        }
    }
}
