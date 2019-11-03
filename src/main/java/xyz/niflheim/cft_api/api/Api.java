package xyz.niflheim.cft_api.api;

import com.rabbitmq.client.MessageProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.niflheim.cft_api.App;
import xyz.niflheim.cft_api.db.objects.Submission;
import xyz.niflheim.cft_api.db.objects.User;

import java.rmi.server.ExportException;

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
    @PostMapping(value = "/submission/post")
    public ResponseEntity postSubmission(@RequestBody String submission) {
        Submission s = new Submission();
        s.setCode(submission).setStatus("PENDING");
        App.getMongo().updateSubmission(s);

        try {
            String id = Long.toString(s.getId());
            App.getChannel().basicPublish("", "submission_queue", MessageProperties.PERSISTENT_TEXT_PLAIN, id.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
