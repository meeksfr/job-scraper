package ca.mikaonline.jobScraper.service;

import ca.mikaonline.jobScraper.entity.User;
import ca.mikaonline.jobScraper.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    private final UserRepository userRepository;

    //As of Spring Framework 4.3, an @Autowired annotation on such a constructor
    //is no longer necessary if the target bean defines only one constructor to begin with
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User createUser(String email){
        //TODO: add actual auth / token / password stuff
        return userRepository.save(new User(email));
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with email: " + email));
    }
}
