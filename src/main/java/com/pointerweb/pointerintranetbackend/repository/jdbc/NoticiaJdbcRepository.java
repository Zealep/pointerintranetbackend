package com.pointerweb.pointerintranetbackend.repository.jdbc;

import com.pointerweb.pointerintranetbackend.model.dto.GaleriaPrincipal;
import com.pointerweb.pointerintranetbackend.model.dto.NoticiaPrincipal;
import com.pointerweb.pointerintranetbackend.service.DatoArchivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

@Component
public class NoticiaJdbcRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;



    public List<NoticiaPrincipal> getPrincipales(){

        String sql = "select n.idNoticia,n.titulo,n.detalle,n.fecha,DATE_FORMAT(n.fecha,'%Y') as year,DATE_FORMAT(n.fecha,'%m') as month,DATE_FORMAT(n.fecha,'%M') as mes, f.pathArchivo as imagen from rh_in_tz_noticia n" +
                " inner join rh_in_tz_datos_archivo f on n.idNoticia = f.idCodigoRelacional where f.idProceso = '00031'";
        return (List<NoticiaPrincipal>)jdbcTemplate.query(sql, new NoticiaPrincipalMapper());

    }

    private static final class NoticiaPrincipalMapper implements RowMapper<NoticiaPrincipal> {

        @Autowired
        private DatoArchivoService datoArchivoService;

        @Override
        public NoticiaPrincipal mapRow(ResultSet rs, int rowNum) throws SQLException {

            NoticiaPrincipal g = new NoticiaPrincipal();
            g.setIdNoticia(rs.getString("idNoticia"));
            g.setTitulo(rs.getString("titulo"));
            g.setDetalle(rs.getBytes("detalle"));
            g.setFecha(rs.getDate("fecha"));
            g.setYear(rs.getString("year"));
            g.setMonth(rs.getString("month"));
            g.setMes(rs.getString("mes"));
            g.setImagen(rs.getString("imagen"));
            g.setHtml(new String(rs.getBytes("detalle")));
            return g;

        }
    }

}
