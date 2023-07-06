package Artist.MitaArtist.Pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Audit {
    private String updatedBy;
    private Date updateDt;
}

