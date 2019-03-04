package domain.digidex;

import presentation.digidex.DigidexDTO;

import java.util.List;

public interface DigidexService {
    List<DigidexDTO> list();
    DigidexDTO getById(Integer id);
    DigidexDTO getByName(String name);
    DigidexDTO save(DigidexDTO digidexDTO);
    DigidexDTO update(DigidexDTO digidexDTO);
    void deleteById(Integer id);
}
