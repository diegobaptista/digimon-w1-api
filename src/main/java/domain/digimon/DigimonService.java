package domain.digimon;

import presentation.digimon.DigimonDTO;

import java.util.List;

public interface DigimonService {
    List<DigimonDTO> list();
    DigimonDTO getByName(String name);
    DigimonDTO save(DigimonDTO digimonDTO);
    DigimonDTO update(DigimonDTO digimonDTO);
    void deleteById(String name);
}
