package gestorcitas.api_cita.agendar;

import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface AgendarRepository extends CrudRepository<Agendar, Long> {

    public List<Agendar> findAll();
}
