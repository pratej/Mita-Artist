package Artist.MitaArtist.Service;

import Artist.MitaArtist.Pojo.Artist;
import Artist.MitaArtist.Repository.ArtistRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ArtistService {


    Artist getArtistById(String artistId);

    Artist updateArtist(Artist artist);

    Artist saveArtist(Artist artist);

    List<Artist> getAllArtists();

    Artist createArtist(Artist artist);

    Artist updateArtist(String artistId, Artist updatedArtist);

    boolean deleteArtist(String artistId);
}

