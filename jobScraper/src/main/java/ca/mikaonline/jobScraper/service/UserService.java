package ca.mikaonline.jobScraper.service;

import ca.mikaonline.jobScraper.entity.User;
import ca.mikaonline.jobScraper.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    //As of Spring Framework 4.3, an @Autowired annotation on such a constructor
    //is no longer necessary if the target bean defines only one constructor to begin with
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
