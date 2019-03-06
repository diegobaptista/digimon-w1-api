package presentation.digimon;

import domain.digidex.Digidex;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class DigimonDTO {
    private String name;
    private ZonedDateTime created_at;
    private Double weight;
    private Digidex digidex;
}
