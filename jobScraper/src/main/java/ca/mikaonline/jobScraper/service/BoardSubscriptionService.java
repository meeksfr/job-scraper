package ca.mikaonline.jobScraper.service;

import ca.mikaonline.jobScraper.entity.BoardSubscription;
import ca.mikaonline.jobScraper.entity.JobBoard;
import ca.mikaonline.jobScraper.entity.User;
import ca.mikaonline.jobScraper.repository.BoardSubscriptionRepository;
import ca.mikaonline.jobScraper.repository.JobBoardRepository;
import ca.mikaonline.jobScraper.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardSubscriptionService {
    private final BoardSubscriptionRepository boardSubscriptionRepository;
    private final UserRepository userRepository;
    private final JobBoardRepository jobBoardRepository;

    public BoardSubscriptionService(BoardSubscriptionRepository boardSubscriptionRepository, UserRepository userRepository, JobBoardRepository jobBoardRepository){
        this.boardSubscriptionRepository = boardSubscriptionRepository;
        this.userRepository = userRepository;
        this.jobBoardRepository = jobBoardRepository;
    }

    public BoardSubscription addSubscription(Long userId, String boardUrl){
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));
        JobBoard jobBoard = jobBoardRepository.findByUrl(boardUrl).orElseGet(() -> jobBoardRepository.save(new JobBoard(boardUrl)));

        BoardSubscription subscription = new BoardSubscription();
        subscription.setUser(user);
        subscription.setJobBoard(jobBoard);

        return boardSubscriptionRepository.save(subscription);
    }

    public List<BoardSubscription> getUserSubscriptions(Long userId){
        return boardSubscriptionRepository.findByUserId(userId);
    }

    public void removeSubscription(Long boardSubscriptionId){
        boardSubscriptionRepository.deleteById(boardSubscriptionId);
    }
}
