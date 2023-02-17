package gestorcitas.api_cita.docente;

import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface DocenteRepository extends CrudRepository<Docente, Long> {

    public List<Docente> findAll();
}

