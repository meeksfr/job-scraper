package ca.mikaonline.jobScraper;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Entity
@Table(name = "postings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private String url;
    private Date postedAt;
    private Date expiresAt;
    private boolean saved;

    @ManyToOne
    @JoinColumn(name = "job_board_id", nullable = false)
    private JobBoard parentBoard;
}
