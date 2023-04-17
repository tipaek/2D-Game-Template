package pointing.dis.movieSheesh;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movies") //basically means for this url
public class MovieController {
    @GetMapping
    public ResponseEntity<String> getAllMovies()
    {
        return new ResponseEntity<>("All movies", HttpStatus.OK);
    }
}
