package domain.digimon.impl;

import domain.digimon.Digimon;
import domain.digimon.DigimonRepository;
import domain.digimon.DigimonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import presentation.digimon.DigimonDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DigimonServiceImpl implements DigimonService {

    private DigimonRepository digimonRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public DigimonServiceImpl(DigimonRepository digimonRepository) {
        this.digimonRepository = digimonRepository;
    }

    @Override
    public List<DigimonDTO> list() {
        return digimonRepository.findAll().stream().map(digimon -> {
            return modelMapper.map(digimon, DigimonDTO.class);
        }).collect(Collectors.toList());
    }

    @Override
    public DigimonDTO getByName(String name) {
        return modelMapper.map(digimonRepository.findById(name).get(), DigimonDTO.class);
    }

    @Override
    public DigimonDTO save(DigimonDTO digimonDTO) {
        return modelMapper.map(digimonRepository.save(modelMapper.map(digimonDTO, Digimon.class)),DigimonDTO.class);
    }

    @Override
    public DigimonDTO update(DigimonDTO digimonDTO) {
        return modelMapper.map(digimonRepository.save(modelMapper.map(digimonDTO, Digimon.class)),DigimonDTO.class);
    }

    @Override
    public void deleteById(String name) {
        digimonRepository.deleteById(name);
    }
}
