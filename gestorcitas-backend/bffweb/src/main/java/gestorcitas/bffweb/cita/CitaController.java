package gestorcitas.bffweb.cita;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/cita")
@CrossOrigin({"*"})
public class CitaController {

    @Autowired CitaClient client;

    @GetMapping("/")
    public List<CitaDTO> findAll() {
        return client.findAll();
    }

    @GetMapping("/{id}/")
    public CitaDTO findById(@PathVariable Long id){
        return client.findById(id);
    }

    @PostMapping("/")
    public CitaDTO save(@RequestBody CitaDTO entity){
        return client.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id){
        client.deleteById(id);
    }

    @PutMapping("/{id}/")
    public CitaDTO update(@PathVariable Long id, @RequestBody CitaDTO entity){
        return client.update(id, entity);
    }
    @PatchMapping("/{id}/")
    public CitaDTO partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields){

        CitaDTO CitaDTO = client.findById(id);

        // itera sobre los campos que se desean actualizar
        for (Map.Entry<String, Object> field : fields.entrySet()) {
            String fieldName = field.getKey();
            Object fieldValue = field.getValue();
            
            // utiliza reflection para establecer el valor del campo en la entidad
            try {
                Field campoEntidad = CitaDTO.class.getDeclaredField(fieldName);
                campoEntidad.setAccessible(true);
                campoEntidad.set(CitaDTO, fieldValue);
            } catch (NoSuchFieldException | IllegalAccessException ex) {
                // maneja la excepción si ocurre algún error al acceder al campo
            }
        }
        return client.update(id, CitaDTO);
    }
}
