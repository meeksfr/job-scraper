package ca.mikaonline.jobScraper.service;

import ca.mikaonline.jobScraper.entity.JobBoard;
import ca.mikaonline.jobScraper.entity.JobPosting;
import ca.mikaonline.jobScraper.repository.JobBoardRepository;
import ca.mikaonline.jobScraper.repository.JobPostingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobPostingService {
    private final JobPostingRepository jobPostingRepository;
    private final JobBoardRepository jobBoardRepository;

    public JobPostingService(JobPostingRepository jobPostingRepository, JobBoardRepository jobBoardRepository){
        this.jobPostingRepository = jobPostingRepository;
        this.jobBoardRepository = jobBoardRepository;
    }

    public List<JobPosting> getBoardPostings(Long boardId){
        return jobPostingRepository.findByParentBoardId(boardId);
    }

    public List<JobPosting> getBoardPostings(String boardUrl){
        JobBoard board = jobBoardRepository.findByUrl(boardUrl).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Board not found with url: " + boardUrl));
        return jobPostingRepository.findByParentBoardId(board.getId());
    }

    public JobPosting createJobPosting(String title, String description, String jobPostUrl, LocalDate postedAt, LocalDate expiresAt, String boardUrl){
        JobPosting jobPosting = new JobPosting();

        JobBoard parentBoard = jobBoardRepository.findByUrl(boardUrl)
                .orElseGet(() -> jobBoardRepository.save(new JobBoard(boardUrl)));

        jobPosting.setTitle(title);
        jobPosting.setDescription(description);
        jobPosting.setUrl(jobPostUrl);
        jobPosting.setPostedAt(postedAt);
        jobPosting.setExpiresAt(expiresAt);
        jobPosting.setParentBoard(parentBoard);

        return jobPostingRepository.save(jobPosting);
    }
}
