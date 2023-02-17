package gestorcitas.api_cita.sintomas;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
    
@Service
public class SintomasService {
    @Autowired SintomasRepository entityRepository;

    public Sintomas save(Sintomas entity){
        return entityRepository.save(entity);
    }

    public Sintomas findById( Long id){
        return entityRepository.findById(id).orElse(new Sintomas());
    }

    public void deleteById(Long id){
        entityRepository.deleteById(id);
    }

    public List<Sintomas> findAll(){
        return entityRepository.findAll();
    }
}
