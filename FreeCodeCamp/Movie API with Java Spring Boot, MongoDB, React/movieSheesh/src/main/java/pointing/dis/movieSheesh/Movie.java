package pointing.dis.movieSheesh;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Movie {
    @Id
    private ObjectId id;
    private String ImdbId, title, releaseDate, trailerLink, poster;
    private List<String> genres, backdrops;

    @DocumentReference //store only Ids of the reviews, the reviews will be in a separate collection
    private List<Review> reviewIds;


}
