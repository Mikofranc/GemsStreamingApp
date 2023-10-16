package org.example.data.repo;

import org.example.data.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepo extends JpaRepository<Media, Long> {
}
