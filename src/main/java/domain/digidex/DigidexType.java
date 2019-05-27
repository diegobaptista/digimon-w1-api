package domain.digidex;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@Data
public class DigidexType {
    @Id
    @Enumerated(EnumType.STRING)
    private DigimonTypeEnum name;
}
