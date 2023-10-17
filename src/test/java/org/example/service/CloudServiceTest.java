package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.exception.MediaUploadException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
public class CloudServiceTest {
    @Autowired
    private CloudService cloudService;

    public  static final String IMAGE_LOCATION="/home/micheal/IdeaProjects/GemsTube/src/main/java/org/example/assets/pic.png";
    public  static final String VIDEO_LOCATION="/home/micheal/IdeaProjects/GemsTube/src/main/java/org/example/assets/video.mp4";
    public static  final  String MUSIC_LOCATION = "/home/micheal/IdeaProjects/GemsTube/src/main/java/org/example/assets/Asa-Show-Me-Off-(TrendyBeatz.com).mp3";

    @Test
    public void testToUploadFile() {
        Path path = Paths.get(VIDEO_LOCATION);
                try(var inputStream = Files.newInputStream(path)){
                    MultipartFile file = new MockMultipartFile("test-image", inputStream);
                    String response=  cloudService.upload(file);
                    assertNotNull(response);
                    System.out.println(response);
                }catch (IOException| MediaUploadException e) {
                    e.printStackTrace();
                    log.error(e.getMessage());
                }
    }

    @Test
    public void testToUploadMusic() {
        Path path = Paths.get(MUSIC_LOCATION);
        try(var inputStream = Files.newInputStream(path)){
            MultipartFile file = new MockMultipartFile("test-image", inputStream);
            String response=  cloudService.upload(file);
            assertNotNull(response);
        }catch (IOException| MediaUploadException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }
    @Test
    public void testToUploadVideo() throws MediaUploadException {
        var file = getMultiMediaTest(IMAGE_LOCATION);
        String url = cloudService.upload(file);
        System.out.println(url);
        assertNotNull(url);
    }


    public static MultipartFile getMultiMediaTest(String location){
        Path path = Paths.get(location);
        try(var inputStream = Files.newInputStream(path)) {
            return new MockMultipartFile("test-image", inputStream);
        }catch (IOException exception){
            exception.printStackTrace();
            throw new RuntimeException(exception);
        }
    }
}
