package gestorcitas.api_cita.cita;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.util.ResourceUtils;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import gestorcitas.api_cita.estudiante.EstudianteClient;
import gestorcitas.api_cita.estudiante.EstudianteDTO;


@Service
public class CitaService {
    @Autowired CitaRepository citaRepository;
    @Autowired EstudianteClient estudianteClient;


    public Cita save(Cita entity){
        return citaRepository.save(entity);
    }

    public Cita findById( Long id){
        return citaRepository.findById(id).orElse(new Cita());
    }

    public void deleteById(Long id){
        citaRepository.deleteById(id);
    }

    public List<Cita> findAll(){
        return citaRepository.findAll();
    }

    public JasperPrint getCitaReporte(Long id) {

        Map<String, Object> reportParameters = new HashMap<String, Object>();
        Cita cita = findById(id);
        if (cita.getId()==null)
            return null;
        
        reportParameters.put("nro", cita.getNumeroCita());
        reportParameters.put("fecha",Date.valueOf(cita.getFecha()));

        EstudianteDTO estudiante =  estudianteClient.findEstudianteById(cita.getEstudianteId());
        reportParameters.put("nombre_estudiante", estudiante.getNombre());
        reportParameters.put("cedula", estudiante.getCedula());
        
        List<Map<String, Object>> dataList = new ArrayList<>();

        for (CitaLinea linea : cita.getLineas()){
            Map<String, Object> data = new HashMap<>();
            data.put("nombreDocente", linea.getDocente().getNombre());
            data.put("especialidad",linea.getEspecialidad());
            data.put("jornada",linea.getJornada());
            dataList.add(data);
        }
        
        

        reportParameters.put("lineasCita", new JRBeanCollectionDataSource(dataList));

        JasperPrint reportJasperPrint = null;
        try {
            reportJasperPrint = JasperFillManager.fillReport(
                    JasperCompileManager.compileReport(
                            ResourceUtils.getFile("classpath:jrxml/cita.jrxml")
                                    .getAbsolutePath()) // path of the jasper report
                    , reportParameters // dynamic parameters
                    , new JREmptyDataSource());
        } catch (FileNotFoundException | JRException e) {
            e.printStackTrace();
        }
        return reportJasperPrint;
    }

}
