package xyz.niflheim.cft_api.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.niflheim.cft_api.App;
import xyz.niflheim.cft_api.db.objects.Submission;
import xyz.niflheim.cft_api.db.objects.User;

@RestController
public class Api {
    @CrossOrigin(origins = "*")
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable long id) {
        return App.getMongo().getUserById(id);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/user/name/{username}")
    public User getUser(@PathVariable String username) {
        return App.getMongo().getUserByField("username", username);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/submission/{id}")
    public Submission getSubmission(@PathVariable long id) {
        return App.getMongo().getSubmissionById(id);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/submission/post", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity postSubmission(@RequestBody Submission submission) {
        App.getMongo().updateSubmission(submission);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
