package ca.mikaonline.jobScraper.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "subscriptions")
@Getter
@Setter
@NoArgsConstructor
public class BoardSubscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore //TODO: build out DTOs instead
    private User user;

    @ManyToOne
    @JoinColumn(name = "job_board_id", nullable = false)
    private JobBoard jobBoard;
}
