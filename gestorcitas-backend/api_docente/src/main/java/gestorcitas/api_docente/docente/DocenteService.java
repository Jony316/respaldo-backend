package gestorcitas.api_docente.docente;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin({"*"})
@Service
public class DocenteService {
 @Autowired DocenteRepository docenteRepository;
 public Docente save(Docente entity){
 return docenteRepository.save(entity);
 }
 public Docente findById( Long id){
 return docenteRepository.findById(id).orElse(new Docente());
 }
 public void deleteById(Long id){
 docenteRepository.deleteById(id);
 }
 public List<Docente> findAll(){
 return docenteRepository.findAll();
 }
}

