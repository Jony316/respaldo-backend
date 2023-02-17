package gestorcitas.bffweb.agendar;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bff.agendar", url = "http://localhost:8084/api/agendar")
public interface AgendarClient {

    @GetMapping("/{id}/")
    AgendarDTO findById(@PathVariable("id") Long id);

    @GetMapping("/")
    List<AgendarDTO> findAll();

    @PostMapping("/") 
    AgendarDTO save(AgendarDTO entity);

    @DeleteMapping("/{id}/")
    void deleteById(@PathVariable("id")  Long id);

    @PutMapping("/{id}/")
    AgendarDTO update(@PathVariable("id")  Long id, AgendarDTO entity);

    @PutMapping("/{id}/completardatos/")
    AgendarDTO completardatos(@PathVariable("id")  Long id);

}
