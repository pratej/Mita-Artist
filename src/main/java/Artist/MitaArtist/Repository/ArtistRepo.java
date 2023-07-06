package Artist.MitaArtist.Repository;

import Artist.MitaArtist.Pojo.Artist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepo extends MongoRepository<Artist,String> {

    Artist getArtistById(String artistId);

    Artist updateArtist(Artist artist);

    Artist saveArtist(Artist artist);

    List<Artist> getAllArtists();

    boolean deleteArtist(String artistId);
}
