package ca.mikaonline.jobScraper.repository;

import ca.mikaonline.jobScraper.entity.JobBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobBoardRepository extends JpaRepository<JobBoard, Long> {
    Optional<JobBoard> findByUrl(String url);
}
