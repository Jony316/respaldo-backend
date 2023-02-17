package gestorcitas.api_cita.tratamiento;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Tratamiento {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;
 private String nombre;
 private String descripcion;
 private String lapso; 
 private String medicamentos; 
}