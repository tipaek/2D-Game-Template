package pointing.dis.movieSheesh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired //automatically initializes stuff, like initializing a MovieRepository class for us
    private MovieRepository movieRepository;
    public List<Movie> allMovies()
    {
        return movieRepository.findAll(); //method defined in mongo repository class
    }
}
