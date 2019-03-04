package presentation.digidex;

import domain.digidex.DigimonTypes;
import lombok.Data;

@Data
public class DigidexDTO {
    private Integer id;
    private String name;
    private DigimonTypes type;
    private String image;
}
