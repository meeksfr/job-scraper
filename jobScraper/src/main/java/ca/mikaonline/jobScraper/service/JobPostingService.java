package ca.mikaonline.jobScraper.service;

import ca.mikaonline.jobScraper.entity.JobBoard;
import ca.mikaonline.jobScraper.entity.JobPosting;
import ca.mikaonline.jobScraper.repository.JobPostingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostingService {
    private final JobPostingRepository jobPostingRepository;

    public JobPostingService(JobPostingRepository jobPostingRepository){
        this.jobPostingRepository = jobPostingRepository;
    }

    public List<JobPosting> getBoardPostings(Long boardId){
        return jobPostingRepository.findByBoardId(boardId);
    }

    public JobPosting saveJobPosting(JobPosting jobPosting){
        return jobPostingRepository.save(jobPosting);
    }
}
