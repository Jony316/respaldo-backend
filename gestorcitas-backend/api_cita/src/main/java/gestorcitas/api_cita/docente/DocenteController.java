package gestorcitas.api_cita.docente;

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
@RequestMapping("api/docente")
@CrossOrigin({"*"})
public class DocenteController {
    @Autowired DocenteService docenteService;

    @GetMapping("/")
    public List<Docente> findAll(){
        return docenteService.findAll();
    }

    @GetMapping("/{id}/")
    public Docente findById(@PathVariable Long id){
        return docenteService.findById(id);
    }

    @PostMapping("/")
    public Docente save(@RequestBody Docente entity){
        return docenteService.save(entity);
    }

    @PutMapping("/{id}/")
    public Docente update(@RequestBody Docente entity){
        return docenteService.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id){
        docenteService.deleteById(id);
    }
}