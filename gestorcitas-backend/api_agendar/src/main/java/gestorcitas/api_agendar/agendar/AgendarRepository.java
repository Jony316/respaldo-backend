package gestorcitas.api_agendar.agendar;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AgendarRepository extends JpaRepository<Agendar, Long> {
 public List<Agendar> findAll();
 
}