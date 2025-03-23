package ca.mikaonline.jobScraper.service;

import ca.mikaonline.jobScraper.entity.JobBoard;
import ca.mikaonline.jobScraper.entity.JobPosting;
import ca.mikaonline.jobScraper.repository.JobBoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobBoardService {
    private final JobBoardRepository jobBoardRepository;

    public JobBoardService(JobBoardRepository jobBoardRepository){
        this.jobBoardRepository = jobBoardRepository;
    }

    public JobBoard saveJobBoard(JobBoard jobBoard){
        return jobBoardRepository.save(jobBoard);
    }
}
