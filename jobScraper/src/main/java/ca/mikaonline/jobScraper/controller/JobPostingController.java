package ca.mikaonline.jobScraper.controller;

import ca.mikaonline.jobScraper.entity.JobPosting;
import ca.mikaonline.jobScraper.service.JobPostingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/postings")
@CrossOrigin(origins = "*")
public class JobPostingController {

    private final JobPostingService jobPostingService;

    public JobPostingController(JobPostingService jobPostingService){
        this.jobPostingService = jobPostingService;
    }

    @GetMapping("/boardId/{boardId}")
    public ResponseEntity<List<JobPosting>> getPostings(@PathVariable Long boardId){
        return new ResponseEntity<List<JobPosting>>(jobPostingService.getBoardPostings(boardId),HttpStatus.OK);
    }

    @GetMapping("/boardUrl/{boardUrl}")
    public ResponseEntity<List<JobPosting>> getPostings(@PathVariable String boardUrl){
        return new ResponseEntity<List<JobPosting>>(jobPostingService.getBoardPostings(boardUrl),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<JobPosting> createPosting(@RequestBody Map<String, String> body){
        return new ResponseEntity<JobPosting>(
                jobPostingService.createJobPosting(
                        body.get("title"),
                        body.get("description"),
                        body.get("job-url"),
                        LocalDate.parse(body.get("posted-at")),
                        LocalDate.parse(body.get("expires-at")),
                        body.get("board-url")
                ), HttpStatus.CREATED);
    }
}
