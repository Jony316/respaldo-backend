package gestorcitas.api_cita.cita;

import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface CitaRepository extends CrudRepository<Cita, Long>{

    List<Cita> findAll();
}

