package presentation.digimon;

import domain.digimon.DigimonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
