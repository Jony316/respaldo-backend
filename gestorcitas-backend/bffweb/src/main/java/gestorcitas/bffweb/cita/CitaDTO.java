package gestorcitas.bffweb.cita;

import lombok.Data;
import java.time.LocalDate;
@Data
public class CitaDTO {
    private Long id;
    private String numeroCita;
    private LocalDate fecha;
    private Long estudianteId;
}
