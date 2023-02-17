package gestorcitas.bffweb.cita;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bff.cita", url = "http://localhost:8083/api/cita")
public interface CitaClient {

    @GetMapping("/{id}/")
    CitaDTO findById(@PathVariable("id") Long id);

    @GetMapping("/")
    List<CitaDTO> findAll();

    @PostMapping("/") 
    CitaDTO save(CitaDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@PathVariable("id")  Long id);

    @PutMapping("/{id}/")
    CitaDTO update(@PathVariable("id")  Long id, CitaDTO entity);

    @PutMapping("/{id}/completardatos/")
    CitaDTO completardatos(@PathVariable("id")  Long id);

}