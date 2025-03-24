package ca.mikaonline.jobScraper.repository;

import ca.mikaonline.jobScraper.entity.BoardSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardSubscriptionRepository extends JpaRepository<BoardSubscription, Long> {
    List<BoardSubscription> findByUserId(Long userId);
    List<BoardSubscription> findByBoardId(Long boardId);
    Optional<BoardSubscription> findByUserIdAndBoardId(Long userId, Long boardId);
}
