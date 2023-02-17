package gestorcitas.api_docente.docente;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DocenteRepository extends JpaRepository<Docente, Long> {
 public List<Docente> findAll();
 
}