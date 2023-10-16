package org.example.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {
//    @Value("${cloud.api.key}")
//    private String APIKEY;
//    @Value("${cloud.api.secret}")
//    private String API_SECRET;
//    @Value("${cloud.api.name}")
//    private String CLOUD_NAME;
    @Bean
    public Cloudinary cloudinary(){
        return  new Cloudinary( ObjectUtils.asMap(
                "cloud_name", "duc8kpcl9" ,
                "api_key",  "488219225971641",
                "api_secret", "-PV-Q1uVzOryUYB9a93bfEF41Gc",
                "secure",  "true"
        ));
    }

}
