package gestorcitas.bffweb.sintomas;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bff.sintomas", url = "http://localhost:8085/api/sintomas")
public interface SintomasClient {

    @GetMapping("/{id}/")
    SintomasDTO findById(@PathVariable("id") Long id);

    @GetMapping("/")
    List<SintomasDTO> findAll();

    @PostMapping("/") 
    SintomasDTO save(SintomasDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@PathVariable("id")  Long id);

    @PutMapping("/{id}/")
    SintomasDTO update(@PathVariable("id")  Long id, SintomasDTO entity);

    @PutMapping("/{id}/completardatos/")
    SintomasDTO completardatos(@PathVariable("id")  Long id);

}