package gestorcitas.bffweb.tratamiento;


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
@RequestMapping("api/tratamiento")
@CrossOrigin({"*"})
public class TratamientoController {

    @Autowired TratamientoClient client;

    @GetMapping("/")
    public List<TratamientoDTO> findAll() {
        return client.findAll();
    }

    @GetMapping("/{id}/")
    public TratamientoDTO findById(@PathVariable Long id){
        return client.findById(id);
    }

    @PostMapping("/")
    public TratamientoDTO save(@RequestBody TratamientoDTO entity){
        return client.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id){
        client.deleteById(id);
    }

    @PutMapping("/{id}/")
    public TratamientoDTO update(@PathVariable Long id, @RequestBody TratamientoDTO entity){
        return client.update(id, entity);
    }
    @PatchMapping("/{id}/")
    public TratamientoDTO partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields){

        TratamientoDTO TratamientoDTO = client.findById(id);

        // itera sobre los campos que se desean actualizar
        for (Map.Entry<String, Object> field : fields.entrySet()) {
            String fieldName = field.getKey();
            Object fieldValue = field.getValue();
            
            // utiliza reflection para establecer el valor del campo en la entidad
            try {
                Field campoEntidad = TratamientoDTO.class.getDeclaredField(fieldName);
                campoEntidad.setAccessible(true);
                campoEntidad.set(TratamientoDTO, fieldValue);
            } catch (NoSuchFieldException | IllegalAccessException ex) {
                // maneja la excepción si ocurre algún error al acceder al campo
            }
        }
        return client.update(id, TratamientoDTO);
    }
}
