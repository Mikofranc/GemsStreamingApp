package org.example.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UploadMediaRequest {
    private Long creatorId;
    private String title;
    private MultipartFile file;
    private String description;
    private String fileType;
}
