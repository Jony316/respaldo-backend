package gestorcitas.api_cita.sintomas;

import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface SintomasRepository extends CrudRepository<Sintomas, Long> {

    public List<Sintomas> findAll();
}