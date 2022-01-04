package com.pointerweb.pointerintranetbackend.service;

import com.pointerweb.pointerintranetbackend.model.dto.RptAsistencia;
import com.pointerweb.pointerintranetbackend.model.dto.RptBoleta;

public interface ReporteService {

    byte[] reporteAsistencia(RptAsistencia rptAsistencia);

    byte[] reporteBoleta(RptBoleta rptBoleta);
}
