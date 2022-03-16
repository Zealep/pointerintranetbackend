package com.pointerweb.pointerintranetbackend.repository.jdbc;

import com.pointerweb.pointerintranetbackend.model.dto.GaleriaPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class GaleriaJdbcRepository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<GaleriaPrincipal> getPrincipales(){

        String sql = "select g.idGaleriaFoto,g.titulo,g.fecha, DATE_FORMAT(g.fecha,'%Y') as year,f.pathArchivo as imagenPrincipal from rh_in_tz_galeria_foto g" +
                " inner join rh_in_tz_datos_archivo f on g.idGaleriaFoto = f.idCodigoRelacional" +
                " where f.inFotoPrincipal = 'S' and f.idProceso = '00030'";
        return (List<GaleriaPrincipal>)jdbcTemplate.query(sql, new GaleriaPrincipalMapper());

    }

    private static final class GaleriaPrincipalMapper implements RowMapper<GaleriaPrincipal> {

        @Override
        public GaleriaPrincipal mapRow(ResultSet rs, int rowNum) throws SQLException {

            GaleriaPrincipal g = new GaleriaPrincipal();
            g.setIdGaleriaFoto(rs.getString("idGaleriaFoto"));
            g.setTitulo(rs.getString("titulo"));
            g.setFecha(rs.getDate("fecha"));
            g.setYear(rs.getString("year"));
            g.setImagenPrincipal(rs.getString("imagenPrincipal"));
            return g;

        }
    }
}
