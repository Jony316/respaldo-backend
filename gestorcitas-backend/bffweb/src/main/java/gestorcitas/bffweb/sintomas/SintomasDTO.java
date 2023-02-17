package gestorcitas.bffweb.sintomas;

import lombok.Data;
import java.time.LocalDate;
@Data
public class SintomasDTO {
    private Long id;
    private LocalDate fecha;
    private String descripcion;
    private String diagnostico; 

}
