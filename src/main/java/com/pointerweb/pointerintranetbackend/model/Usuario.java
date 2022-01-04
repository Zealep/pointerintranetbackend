package com.pointerweb.pointerintranetbackend.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "usuarios")
@SqlResultSetMapping(
        name="perfilMapping",
        classes={
                @ConstructorResult(
                        targetClass= Perfil.class,
                        columns={
                                @ColumnResult(name="NombreCompleto",type = String.class),
                                @ColumnResult(name="Cargo",type = String.class),
                                @ColumnResult(name="Empresa",type = String.class),
                                @ColumnResult(name="FechaIngreso",type = String.class),
                                @ColumnResult(name="Correo",type = String.class),
                                @ColumnResult(name="Telefonos",type = String.class),
                                @ColumnResult(name="JefeDirecto",type = String.class),
                                @ColumnResult(name="Cumpleanos",type = String.class)
                        }
                )
        }
)
@NamedNativeQuery(name="Usuario.getDatosPerfil", query="CALL spu_Web_PerfilTrabajador(:varTrabajador)", resultSetMapping="perfilMapping")
public class Usuario implements Serializable {

    @Id
    @Column(name = "idUsuario")
    private String idUsuario;

    @Column(name="idEmpresa")
    private String idEmpresa;

    @Column(name = "varUsuario")
    private String usuario;

    @Column(name = "varPass")
    private String password;

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
