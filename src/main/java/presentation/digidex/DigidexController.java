package presentation.digidex;

import domain.digidex.Digidex;
import domain.digidex.DigidexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/digidex")
public class DigidexController {

    private DigidexService digidexService;

    @Autowired
    public DigidexController(DigidexService digidexService) {
        this.digidexService = digidexService;
    }

    @GetMapping
    public List<DigidexDTO> list() {
        return digidexService.list();
    }

    @GetMapping("/id/{id}")
    public DigidexDTO getById(@PathVariable Integer id) {
        return digidexService.getById(id);
    }

    @GetMapping("/name/{name}")
    public DigidexDTO getById(@PathVariable String name) {
        return digidexService.getByName(name);
    }


    @PostMapping
    public DigidexDTO save(@RequestBody DigidexDTO digidexDTO) {
        return digidexService.save(digidexDTO);
    }

    @PutMapping
    public DigidexDTO update(@RequestBody DigidexDTO digidexDTO) {
        return digidexService.update(digidexDTO);
    }

}
