package ca.mikaonline.jobScraper.entity;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "boards")
@Getter
@Setter
@NoArgsConstructor
public class JobBoard {

    private static final List<String> VALID_PROVIDERS = List.of(
            "https://job-boards.greenhouse.io",
            "https://jobs.lever.co",
            "https://jobs.ashbyhq.com"
    );

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private String displayName;

    @OneToMany(mappedBy = "jobBoard", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore //TODO: build out DTOs instead
    private List<BoardSubscription> subscriptions = new ArrayList<>();

    @OneToMany(mappedBy = "parentBoard", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobPosting> postings = new ArrayList<>();

    public JobBoard(String url) {
        String provider = validateUrl(url);
        this.url = url;
        this.displayName = extractDisplayName(url, provider);
    }

    private String validateUrl(String url) {
        for (String provider : VALID_PROVIDERS) {
            if (url.startsWith(provider)) {
                return provider;
            }
        }
        throw new IllegalArgumentException("Please use a url from an approved provider: " + VALID_PROVIDERS);
    }

    private String extractDisplayName(String url, String provider){
        String remainingPath = url.substring(provider.length() + 1); //+1 to get rid of leading slash
        String[] segments = remainingPath.split("[/?]", 2);
        if (segments.length > 0 && !segments[0].isEmpty()) {
            return URLDecoder.decode(segments[0], StandardCharsets.UTF_8);
        }
        else {
            return "Unknown";
        }
    }
}

