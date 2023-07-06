package Artist.MitaArtist.ArtistController;


import Artist.MitaArtist.Pojo.Artist;
import Artist.MitaArtist.Service.ArtistService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveSessionScoped;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/artists")
@CrossOrigin(origins = "")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @ApiIgnore
    @RequestMapping()
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List> getartist(){
        List<Artist> artists = artistService.getAllArtists();
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @GetMapping(value="/{artistId}",produces = "application/json")
    public ResponseEntity<Artist> getartistById(
            @PathVariable String artistId
    ){
        Artist artist = artistService.getArtistById(artistId);
        if (artist != null) {
            return new ResponseEntity<>(artist, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(produces ="application/json")
    public ResponseEntity<Artist> addArtist(
            @RequestBody final Artist request
    ) {
        Artist createdArtist = artistService.createArtist(request);
        return new ResponseEntity<>(createdArtist, HttpStatus.CREATED);
    }

    @PutMapping(value="/{artistId}",produces = "application/json")
    public ResponseEntity<Artist> updateArtist(
            @PathVariable String artistId,
            @RequestBody final Artist request
    ){
        Artist artist = artistService.updateArtist(artistId, request);
        if (artist != null) {
            return new ResponseEntity<>(artist, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{artistId}",produces ="application/json")
    public ResponseEntity<Artist> deleteArtistById(
            @PathVariable String artistId
    ) {
        boolean deleted = artistService.deleteArtist(artistId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
