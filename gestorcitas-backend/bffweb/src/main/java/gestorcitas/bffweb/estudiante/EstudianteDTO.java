package gestorcitas.bffweb.estudiante;

import java.sql.Date;

import lombok.Data;

@Data
public class EstudianteDTO {
    
    private Long id;
    private String nombre;
    private String cedula;
    private String carrera;
    private String curso;
    private Date fecha;
    private Long tipo;
    private String email;
    private String phone;
    
}

