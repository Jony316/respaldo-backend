package gestorcitas.bffweb.docente;



import lombok.Data;

@Data
public class DocenteDTO {
    
    private Long id;
    private String nombre;
    private String especialidad;
    private String jornada;
    private String correo;
    private String telefono;

}
