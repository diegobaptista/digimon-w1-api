package domain.digidex;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "digidex")
public class Digidex {
    @Id
    //Add strategy SERIAL TYPE
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Enumerated(EnumType.STRING)
    private DigimonLevel level;
    @Enumerated(EnumType.STRING)
    private DigimonActive activePeriod;
    @Enumerated(EnumType.STRING)
    private DigimonCategory attribute;

    @ManyToMany
    @JoinTable(
            name = "digidex_digidextype",
            joinColumns = @JoinColumn(name = "id_digidex"),
            inverseJoinColumns = @JoinColumn(name = "name_type"))
    private List<DigidexType> types;

    private String image;

    @ManyToMany
    @JoinTable(
            name = "digidex_digivolution",
            joinColumns = @JoinColumn(name = "id_digidex"),
            inverseJoinColumns = @JoinColumn(name = "id_digidex_digivolution"))
    private List<Digidex> digivolutions;
}
