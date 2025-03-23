package ca.mikaonline.jobScraper.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "boards")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobBoard {
    @Id
    private Long id;
    private String url;
    private String displayName;

    @OneToMany(mappedBy = "jobBoard", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BoardSubscription> subscriptions = new ArrayList<>();

    @OneToMany(mappedBy = "parentBoard", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobPosting> postings = new ArrayList<>();
}

