package domain.digidex.impl;

import domain.digidex.Digidex;
import domain.digidex.DigidexRepository;
import domain.digidex.DigidexService;
import infra.error.NotFoundException;
import infra.error.UnprocessableEntityException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import presentation.digidex.DigidexDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DigidexServiceImpl implements DigidexService {

    private DigidexRepository digidexRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public DigidexServiceImpl(DigidexRepository digidexRepository) {
        this.digidexRepository = digidexRepository;
    }

    @Override
    public List<DigidexDTO> list() {
        return digidexRepository.findAll().stream().map(digidex -> {
            return modelMapper.map(digidex, DigidexDTO.class);
        }).collect(Collectors.toList());
    }

    @Override
    public DigidexDTO getById(Integer id) {
        validateEntityExistsById(id);
        return modelMapper.map(digidexRepository.findById(id).get(), DigidexDTO.class);
    }

    @Override
    public DigidexDTO getByName(String name) {
        validateEntityExistsByName(name);
        return modelMapper.map(digidexRepository.findByName(name).stream().findFirst().get(), DigidexDTO.class);
    }

    @Override
    public DigidexDTO save(DigidexDTO digidexDTO) {
        validateDuplicatedDigimon(digidexDTO);
        return modelMapper.map(
                digidexRepository.save(modelMapper.map(digidexDTO, Digidex.class)),
                DigidexDTO.class);
    }

    @Override
    public DigidexDTO update(DigidexDTO digidexDTO) {
        validateEntityExistsById(digidexDTO.getId());
        validateDuplicatedDigimon(digidexDTO);
        return modelMapper.map(
                digidexRepository.save(modelMapper.map(digidexDTO, Digidex.class)),
                DigidexDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
    }

    private void validateEntityExistsByName(String name) {
        if(digidexRepository.findByName(name).isEmpty()) {
            throw new NotFoundException();
        }
    }

    private void validateEntityExistsById(Integer id) {
        if(digidexRepository.findById(id).isEmpty()) {
            throw new NotFoundException();
        }
    }

    private void validateDuplicatedDigimon(DigidexDTO digidexDTO) {
        Optional<Digidex> digidexTryToSave = digidexRepository.findByNameAndAttribute(digidexDTO.getName(), digidexDTO.getAttribute()).stream().findFirst();
        if(digidexTryToSave.isPresent() && !modelMapper.map(digidexTryToSave.get(), DigidexDTO.class).equals(digidexDTO)
        ) {
            throw new UnprocessableEntityException();
        }
    }

}
