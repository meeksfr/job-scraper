package ca.mikaonline.jobScraper.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "postings")
@Getter
@Setter
@NoArgsConstructor
public class JobPosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String url;
    private LocalDate postedAt;
    private LocalDate expiresAt;

    @ManyToOne
    @JoinColumn(name = "job_board_id", nullable = false)
    @JsonIgnore //TODO: build out DTOs instead
    private JobBoard parentBoard;


}
