package ca.mikaonline.jobScraper.repository;

import ca.mikaonline.jobScraper.entity.JobBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobBoardRepository extends JpaRepository<JobBoard, Long> {
}
