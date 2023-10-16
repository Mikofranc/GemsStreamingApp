package org.example.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import java.time.LocalDateTime;
@Setter
@Getter
@Entity
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String url;
    @CreatedDate
    private LocalDateTime createdAt;
    @OneToOne(fetch = FetchType.EAGER)
    private User uploader;
//    @Enumerated(EnumType.STRING)

    @PrePersist
    public void setCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }
}
