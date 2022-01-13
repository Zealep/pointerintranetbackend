package com.pointerweb.pointerintranetbackend.service.impl;

import com.pointerweb.pointerintranetbackend.model.dto.RptAsistencia;
import com.pointerweb.pointerintranetbackend.model.dto.RptBoleta;
import com.pointerweb.pointerintranetbackend.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import javax.sql.DataSource;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Service("reporteService")
public class ReporteServiceImpl implements ReporteService {

    @Autowired
    private DataSource dataSource;

    @Value("${url-path-report-boleta}")
    private String URL_PATH_REPORT_BOLETA;

    @Override
    public byte[] reporteAsistencia(RptAsistencia rptAsistencia) {

        Map<String,Object> p = new HashMap<>();
        /*
        LocalDate date = LocalDate.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        */

        p.put("varEmpresa", rptAsistencia.getVarEmpresa());
        p.put("varFechaDesde",rptAsistencia.getVarFechaDesde());
        p.put("varFechaHasta",rptAsistencia.getVarFechaHasta());
        p.put("varidArea"," ");
        p.put("varidCentroCosto"," ");
        p.put("varidTipoPlanilla", " ");
        p.put("varidTrabajador", rptAsistencia.getVarIdTrabajador());
        p.put("varSucursal", " ");
        p.put("varUsuario", " ");

        JasperReport report;
        JasperPrint print;

        try {

            URL url = this.getClass().getResource("/reportes/asistencia/rptHorarioTrabajadorTodos.jasper");
            report = (JasperReport) JRLoader.loadObject(url);
            //InputStream employeeReportStream = getClass().getResourceAsStream("/reportes/asistencia/rptHorarioTrabajadorTodos.jrxml");
            //JasperReport jasperReport = JasperCompileManager.compileReport(employeeReportStream);
            print = JasperFillManager.fillReport(report, p, dataSource.getConnection());
            return JasperExportManager.exportReportToPdf(print);


        } catch (JRException | SQLException e) {

            e.printStackTrace();
            return null;
        }
    }

    @Override
    public byte[] reporteBoleta(RptBoleta rptBoleta) {
        Map<String,Object> p = new HashMap<>();

        /*
        LocalDate date = LocalDate.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        */

        p.put("varEmpresa", rptBoleta.getVarEmpresa());
        p.put("varPeriodo",rptBoleta.getVarPeriodo());
        p.put("varTrabajador",rptBoleta.getVarTrabajador());
        p.put("varTipoBoleta",1);
        p.put("varTipoPlanilla"," ");
        p.put("varCentroCosto", " ");
        p.put("varArea", " ");
        p.put("varIdEstablecimiento", " ");
        p.put("SUBREPORT_DIR",URL_PATH_REPORT_BOLETA);

        JasperReport report;
        JasperPrint print;

        try {

            URL url = this.getClass().getResource("/reportes/boleta/rptBoletaTrabajador01.jasper");
            report = (JasperReport) JRLoader.loadObject(url);
            //InputStream employeeReportStream = getClass().getResourceAsStream("/reportes/asistencia/rptHorarioTrabajadorTodos.jrxml");
            //JasperReport jasperReport = JasperCompileManager.compileReport(employeeReportStream);
            print = JasperFillManager.fillReport(report, p, dataSource.getConnection());
            return JasperExportManager.exportReportToPdf(print);


        } catch (JRException | SQLException e) {

            e.printStackTrace();
            return null;
        }
    }

}
