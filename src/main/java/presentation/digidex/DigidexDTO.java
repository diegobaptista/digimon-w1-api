package presentation.digidex;

import domain.digidex.DigimonAttributes;
import domain.digidex.DigimonLevels;
import lombok.Data;

@Data
public class DigidexDTO {
    private Integer id;
    private String name;
    private String type;
    private DigimonAttributes attribute;
    private DigimonLevels level;
    private String image;
}
