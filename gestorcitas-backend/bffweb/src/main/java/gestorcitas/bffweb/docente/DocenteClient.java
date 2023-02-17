package gestorcitas.bffweb.docente;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bff.docente", url = "http://localhost:8091/api/docente")
public interface DocenteClient {

    @GetMapping("/{id}/")
    DocenteDTO findById(@PathVariable("id") Long id);

    @GetMapping("/")
    List<DocenteDTO> findAll();

    @PostMapping("/") 
    DocenteDTO save(DocenteDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@PathVariable("id")  Long id);

    @PutMapping("/{id}/")
    DocenteDTO update(@PathVariable("id")  Long id, DocenteDTO entity);

    @PutMapping("/{id}/completardatos/")
    DocenteDTO completardatos(@PathVariable("id")  Long id);

}

