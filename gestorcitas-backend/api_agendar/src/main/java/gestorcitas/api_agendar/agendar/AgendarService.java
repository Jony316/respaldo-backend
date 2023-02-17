package gestorcitas.api_agendar.agendar;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AgendarService {
 @Autowired AgendarRepository agendarRepository;
 public Agendar save(Agendar entity){
 return agendarRepository.save(entity);
 }
 public Agendar findById( Long id){
 return agendarRepository.findById(id).orElse(new Agendar());
 }
 public void deleteById(Long id){
 agendarRepository.deleteById(id);
 }
 public List<Agendar> findAll(){
 return agendarRepository.findAll();
 }
}
