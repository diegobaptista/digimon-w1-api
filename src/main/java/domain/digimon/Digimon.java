package domain.digimon;

import domain.digidex.Digidex;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@Entity
@NoArgsConstructor
public class Digimon {
    @Id
    private String name;
    private ZonedDateTime created_at;
    private Double weight;
    @OneToOne
    @JoinColumn(name = "digidex_id")
    private Digidex digidex;
}
