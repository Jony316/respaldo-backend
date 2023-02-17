package gestorcitas.api_cita.docente;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
    
@Service
public class DocenteService {
    @Autowired DocenteRepository entityRepository;

    public Docente save(Docente entity){
        return entityRepository.save(entity);
    }

    public Docente findById( Long id){
        return entityRepository.findById(id).orElse(new Docente());
    }

    public void deleteById(Long id){
        entityRepository.deleteById(id);
    }

    public List<Docente> findAll(){
        return entityRepository.findAll();
    }
}

