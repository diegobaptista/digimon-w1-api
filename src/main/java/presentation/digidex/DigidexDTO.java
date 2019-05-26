package presentation.digidex;

import domain.digidex.DigimonCategory;
import domain.digidex.DigimonLevel;
import lombok.Data;

@Data
public class DigidexDTO {
    private Integer id;
    private String name;
    private String type;
    private DigimonCategory attribute;
    private DigimonLevel level;
    private String image;
}
