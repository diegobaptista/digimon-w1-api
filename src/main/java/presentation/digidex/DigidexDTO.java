package presentation.digidex;

import domain.digidex.DigimonActive;
import domain.digidex.DigimonCategory;
import domain.digidex.DigimonLevel;
import lombok.Data;

import java.util.List;

@Data
public class DigidexDTO {
    private Integer id;
    private String name;
    private String type;
    private DigimonCategory attribute;
    private DigimonLevel level;
    private String image;
    private List<DigidexTypeDTO> types;
    private DigimonActive activePeriod;
}
