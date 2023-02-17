package gestorcitas.bffweb.estudiante;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bff.tipoestudiante", url = "http://localhost:8000/api/tipoestudiante")
public interface TipoEstudianteClient {

    @GetMapping("/{id}/")
    TipoEstudianteDTO findById(@PathVariable("id") Long id);

    @GetMapping("/")
    List<TipoEstudianteDTO> findAll();

    @PostMapping("/") 
    TipoEstudianteDTO save(TipoEstudianteDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@PathVariable("id")  Long id);

    @PutMapping("/{id}/")
    TipoEstudianteDTO update(@PathVariable("id")  Long id, TipoEstudianteDTO entity);

    

}