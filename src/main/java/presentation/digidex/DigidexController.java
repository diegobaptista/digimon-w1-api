package presentation.digidex;

import domain.digidex.DigidexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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
    public ResponseEntity<List<DigidexDTO>> list() {
        return new ResponseEntity<>(digidexService.list(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<DigidexDTO> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(digidexService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<DigidexDTO> getById(@PathVariable String name) {
        return new ResponseEntity<>(digidexService.getByName(name), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<DigidexDTO> save(@RequestBody DigidexDTO digidexDTO) {
        return new ResponseEntity<>(digidexService.save(digidexDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<DigidexDTO> update(@RequestBody DigidexDTO digidexDTO) {
        return new ResponseEntity<>(digidexService.update(digidexDTO), HttpStatus.OK);
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        digidexService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
