package ca.mikaonline.jobScraper.service;

import ca.mikaonline.jobScraper.entity.JobBoard;
import ca.mikaonline.jobScraper.repository.JobBoardRepository;
import org.springframework.stereotype.Service;

@Service
public class JobBoardService {
    private final JobBoardRepository jobBoardRepository;

    public JobBoardService(JobBoardRepository jobBoardRepository){
        this.jobBoardRepository = jobBoardRepository;
    }

    public JobBoard createJobBoard(String url){
        JobBoard board = new JobBoard(url);
        return jobBoardRepository.save(board);
    }
}
