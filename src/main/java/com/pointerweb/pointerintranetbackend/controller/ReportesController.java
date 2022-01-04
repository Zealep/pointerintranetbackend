package com.pointerweb.pointerintranetbackend.controller;

import com.pointerweb.pointerintranetbackend.model.dto.RptAsistencia;
import com.pointerweb.pointerintranetbackend.model.dto.RptBoleta;
import com.pointerweb.pointerintranetbackend.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reporte")
public class ReportesController {

    @Autowired
    private ReporteService reporteService;

    @PostMapping(value = "/asistencia", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> generarAsistencia(@RequestBody RptAsistencia rptAsistencia){
        byte[] data = null;
        try {
            data = reporteService.reporteAsistencia(rptAsistencia);
        } catch (Exception e) {
            return new ResponseEntity<byte[]>(data, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<byte[]>(data, HttpStatus.OK);
    }

    @PostMapping(value = "/boleta", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> generarBoleta(@RequestBody RptBoleta rptBoleta){
        byte[] data = null;
        try {
            data = reporteService.reporteBoleta(rptBoleta);
        } catch (Exception e) {
            return new ResponseEntity<byte[]>(data, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<byte[]>(data, HttpStatus.OK);
    }
}
