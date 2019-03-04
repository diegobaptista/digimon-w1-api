package domain.digidex;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DigidexRepository extends JpaRepository<Digidex, Integer> {

    List<Digidex> findByNameAndType(String name, DigimonTypes type);

}
