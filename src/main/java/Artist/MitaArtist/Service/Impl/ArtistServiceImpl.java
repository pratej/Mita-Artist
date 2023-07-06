package Artist.MitaArtist.Service.Impl;

import Artist.MitaArtist.Pojo.Artist;
import Artist.MitaArtist.Repository.ArtistRepo;
import Artist.MitaArtist.Service.ArtistService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepo artistRepository;

    @Override
    public List<Artist> getAllArtists() {
        return artistRepository.getAllArtists();
    }

    @Override
    public Artist getArtistById(String artistId) {
        return artistRepository.getArtistById(artistId);
    }

    @Override
    public Artist updateArtist(Artist artist) {
        return null;
    }

    @Override
    public Artist saveArtist(Artist artist) {
        return null;
    }

    @Override
    public Artist createArtist(Artist artist) {
        String artistId = UUID.randomUUID().toString();
        artist.setId(artistId);
        return artistRepository.saveArtist(artist);
    }
    @Override
    public Artist updateArtist(String artistId, Artist updatedArtist) {
        Artist artist = artistRepository.getArtistById(artistId);

        if (artist != null) {
            artist.setDescription(updatedArtist.getDescription());
            return artistRepository.updateArtist(artist);
        }

        return null;
    }

    @Override
    public boolean deleteArtist(String artistId) {
        Artist artist = artistRepository.getArtistById(artistId);

        if (artist != null) {
            return artistRepository.deleteArtist(artistId);
        }

        return false;
    }
}
