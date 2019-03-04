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
        validateEntityExists(id);
        return modelMapper.map(digidexRepository.findById(id), DigidexDTO.class);
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
        validateEntityExists(digidexDTO.getId());
        validateDuplicatedDigimon(digidexDTO);
        return modelMapper.map(
                digidexRepository.save(modelMapper.map(digidexDTO, Digidex.class)),
                DigidexDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
    }


    private void validateEntityExists(Integer id) {
        if(digidexRepository.findById(id).isEmpty()) {
            throw new NotFoundException();
        }
    }

    private void validateDuplicatedDigimon(DigidexDTO digidexDTO) {
        Optional<Digidex> digidexTryToSave = digidexRepository.findByNameAndType(digidexDTO.getName(), digidexDTO.getType()).stream().findFirst();
        if(digidexTryToSave.isPresent() && !modelMapper.map(digidexTryToSave.get(), DigidexDTO.class).equals(digidexDTO)
        ) {
            throw new UnprocessableEntityException();
        }
    }

}
