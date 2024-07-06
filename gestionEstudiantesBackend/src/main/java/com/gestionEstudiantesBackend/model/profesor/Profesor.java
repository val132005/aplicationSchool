package com.gestionEstudiantesBackend.model.profesor;

import com.gestionEstudiantesBackend.model.Estado;
import com.gestionEstudiantesBackend.model.Genero;
import com.gestionEstudiantesBackend.model.TipoDocumento;
import com.gestionEstudiantesBackend.model.curso.Curso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "profesores")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column(name = "nombre")
    private String nombre;

    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;

    @Column(name = "numeroDeDocumento")
    private long numeroDeDocumento;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Column(name = "edad")
    private int edad;

    @Column(name = "fechaDeNacimiento")
    private Date fechaDeNacimiento;

    @Column(name = "ciudadDeNacimiento")
    private String ciudadDeNacimiento;

    @Column(name = "paisDeNacimiento")
    private String paisDeNacimiento;

    @Column(name = "numeroDeTelefono")
    private long numeroDeTelefono;

    @Column(name = "email")
    private String email;

    @Column(name = "direccion")
    private String direccion;

    @OneToOne(mappedBy = "profesor")
    private Curso curso;

}
