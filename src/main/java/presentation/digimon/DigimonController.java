package presentation.digimon;

import domain.digimon.DigimonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/digimon")
public class DigimonController {

    private DigimonService digimonService;

    @Autowired
    public DigimonController(DigimonService digimonService) {
        this.digimonService = digimonService;
    }

    @GetMapping
    public ResponseEntity<List<DigimonDTO>> list() {
        return new ResponseEntity<>(digimonService.list(), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<DigimonDTO> getByName(@RequestParam String name) {
        return new ResponseEntity<>(digimonService.getByName(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DigimonDTO> save(@RequestBody DigimonDTO digimonDTO) {
        return new ResponseEntity<>(digimonService.save(digimonDTO), HttpStatus.CREATED);
    }
}
