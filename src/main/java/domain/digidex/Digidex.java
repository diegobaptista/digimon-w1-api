package domain.digidex;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private DigimonActive active;
    @Enumerated(EnumType.STRING)
    private DigimonCategory attribute;



    private String image;
}
