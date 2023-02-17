package gestorcitas.api_cita.estudiante;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "bff.estudiante", url = "http://localhost:8000/api/estudiante")
public interface EstudianteClient {

    @GetMapping("/{id}/")
    EstudianteDTO findEstudianteById(@PathVariable("id") Long id);
}
