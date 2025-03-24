package ca.mikaonline.jobScraper.controller;

import ca.mikaonline.jobScraper.entity.BoardSubscription;
import ca.mikaonline.jobScraper.service.BoardSubscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/subscriptions")
@CrossOrigin(origins = "*")
public class BoardSubscriptionController {
    private final BoardSubscriptionService boardSubscriptionService;

    public BoardSubscriptionController(BoardSubscriptionService boardSubscriptionService){
        this.boardSubscriptionService = boardSubscriptionService;
    }

    @PostMapping()
    public ResponseEntity<BoardSubscription> subscribe(@RequestBody Map<String, String> body){
        return new ResponseEntity<BoardSubscription>(boardSubscriptionService.addSubscription(Long.parseLong(body.get("userId")), body.get("boardUrl")), HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<BoardSubscription>> getUserSubscriptions(@PathVariable String userId){
        return new ResponseEntity<List<BoardSubscription>>(boardSubscriptionService.getUserSubscriptions(Long.parseLong(userId)), HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<HttpStatus> unsubscribe(@RequestBody Map<String, String> body){
        boardSubscriptionService.removeSubscriptionByFields(Long.parseLong(body.get("userId")),body.get("boardUrl"));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
