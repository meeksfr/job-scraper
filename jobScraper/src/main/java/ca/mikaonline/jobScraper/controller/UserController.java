package ca.mikaonline.jobScraper.controller;

import ca.mikaonline.jobScraper.entity.User;
import ca.mikaonline.jobScraper.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody Map<String, String> body){
        //TODO: add actual auth / token / password stuff
        return new ResponseEntity<User>(userService.createUser(body.get("email")), HttpStatus.CREATED);
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUser(@PathVariable String email) {
        return new ResponseEntity<User>(userService.findByEmail(email), HttpStatus.OK);
    }
}
