package ca.mikaonline.jobScraper.controller;

import ca.mikaonline.jobScraper.entity.JobBoard;
import ca.mikaonline.jobScraper.service.JobBoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/boards")
@CrossOrigin(origins = "*")
public class JobBoardController {
    private final JobBoardService jobBoardService;

    public JobBoardController(JobBoardService jobBoardService){
        this.jobBoardService = jobBoardService;
    }

    @PostMapping()
    public ResponseEntity<JobBoard> createJobBoard(@RequestBody Map<String, String> body){
        return new ResponseEntity<JobBoard>(jobBoardService.createJobBoard(body.get("url")), HttpStatus.CREATED);
    }
}
