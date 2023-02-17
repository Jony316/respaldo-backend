package gestorcitas.api_cita.agendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("api/agendar")
@CrossOrigin({"*"})
public class AgendarController {
    @Autowired AgendarService agendarService;

    @GetMapping("/")
    public List<Agendar> findAll(){
        return agendarService.findAll();
    }

    @GetMapping("/{id}/")
    public Agendar findById(@PathVariable Long id){
        return agendarService.findById(id);
    }

    @PostMapping("/")
    public Agendar save(@RequestBody Agendar entity){
        return agendarService.save(entity);
    }

    @PutMapping("/{id}/")
    public Agendar update(@RequestBody Agendar entity){
        return agendarService.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id){
        agendarService.deleteById(id);
    }
}