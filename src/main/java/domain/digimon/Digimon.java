package domain.digimon;

import domain.digidex.Digidex;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
public class Digimon {
    private String name;
    private ZonedDateTime created_at;
    private Double weight;
    private Digidex digidex;
}
