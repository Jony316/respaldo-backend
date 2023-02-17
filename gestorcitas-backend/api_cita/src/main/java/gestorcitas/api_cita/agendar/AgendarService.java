package gestorcitas.api_cita.agendar;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
    
@Service
public class AgendarService {
    @Autowired AgendarRepository entityRepository;

    public Agendar save(Agendar entity){
        return entityRepository.save(entity);
    }

    public Agendar findById( Long id){
        return entityRepository.findById(id).orElse(new Agendar());
    }

    public void deleteById(Long id){
        entityRepository.deleteById(id);
    }

    public List<Agendar> findAll(){
        return entityRepository.findAll();
    }
}
