package gestorcitas.api_sintomas.sintomas;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Sintomas {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private LocalDate fecha;
   private String descripcion;
   private String diagnostico; 
}