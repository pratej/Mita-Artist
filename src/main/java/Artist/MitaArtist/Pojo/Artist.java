package Artist.MitaArtist.Pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Artist {

    private String id;
    private HumanName humanName;
    private String description;
    private List<String> image;
    private List<String> songs;
    private Genre genre;
    private int followersCount;
    private Map<String, String> socialMediaLinks;
    private List<String> albums;
    private List<String> events;
    private Stats stats;
    private Audit audit;
    private Tags tags;
}
