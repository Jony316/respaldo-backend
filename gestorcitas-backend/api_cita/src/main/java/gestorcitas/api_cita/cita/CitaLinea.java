package gestorcitas.api_cita.cita;

import gestorcitas.api_cita.agendar.Agendar;
import gestorcitas.api_cita.docente.Docente;
import gestorcitas.api_cita.sintomas.Sintomas;
import gestorcitas.api_cita.tratamiento.Tratamiento;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;



@Data
@Entity


public class CitaLinea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Docente docente;
    private String especialidad;
    private String jornada;
    @ManyToOne
    private Sintomas sintomas;
    @ManyToOne
    private Tratamiento tratamiento;
    @ManyToOne 
    private Agendar agendar;

    
}
