package gestorcitas.api_cita.cita;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("api/cita")
@CrossOrigin({"*"})
public class CitaController {
    @Autowired CitaService citaService;

    @GetMapping("/")
    public List<Cita> findAll(){
        return citaService.findAll();
    }

    @GetMapping("/{id}/")
    public Cita findById(@PathVariable Long id){
        return citaService.findById(id);
    }

    @PostMapping("/")
    public Cita save(@RequestBody Cita entity){
        return citaService.save(entity);
    }

    @PutMapping("/{id}/")
    public Cita update(@RequestBody Cita entity){
        return citaService.save(entity);
    }

    @DeleteMapping("/{id}/")
    public void deleteById(@PathVariable Long id){
        citaService.deleteById(id);
    }

    @GetMapping("/pdf/{id}/")
	public ResponseEntity<byte[]> getCitaReporte(@PathVariable long id) throws JRException {

		JasperPrint reporte = citaService.getCitaReporte(id);
        
        if (reporte==null)
            return new ResponseEntity<byte[]>(null, null, HttpStatus.NOT_FOUND);
        
		HttpHeaders headers = new HttpHeaders();
		// set the PDF format
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.setContentDispositionFormData("filename", "cita.pdf");
		// create the report in PDF format
		return new ResponseEntity<byte[]>
(JasperExportManager.exportReportToPdf(reporte), headers, HttpStatus.OK);

	}

}
