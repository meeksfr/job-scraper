package ca.mikaonline.jobScraper.repository;

import ca.mikaonline.jobScraper.entity.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
    List<JobPosting> findByParentBoardId(Long parentBoardId);
}
