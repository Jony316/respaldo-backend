package gestorcitas.bffweb.estudiante;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bff.estudiante", url = "http://localhost:8000/api/estudiante")
public interface EstudianteClient {

    @GetMapping("/{id}/")
    EstudianteDTO findById(@PathVariable("id") Long id);

    @GetMapping("/")
    List<EstudianteDTO> findAll();

    @PostMapping("/") 
    EstudianteDTO save(EstudianteDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@PathVariable("id")  Long id);

    @PutMapping("/{id}/")
    EstudianteDTO update(@PathVariable("id")  Long id, EstudianteDTO entity);

    @PutMapping("/{id}/completardatos/")
    EstudianteDTO completardatos(@PathVariable("id")  Long id);

}
