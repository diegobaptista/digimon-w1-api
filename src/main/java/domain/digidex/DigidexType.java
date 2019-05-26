package domain.digidex;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class DigidexType {
    @Id
    @Enumerated(EnumType.STRING)
    private DigimonTypeEnum name;
}
