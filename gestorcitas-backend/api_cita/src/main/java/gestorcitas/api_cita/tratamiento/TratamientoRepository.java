package gestorcitas.api_cita.tratamiento;

import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface TratamientoRepository extends CrudRepository<Tratamiento, Long> {

    public List<Tratamiento> findAll();
}