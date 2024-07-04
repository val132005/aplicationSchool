package com.gestionEstudiantesBackend.model.estudiante;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Column(name = "nombre")
    private  String nombre;

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
    private  String ciudadDeNacimiento;

    @Column(name = "paisDeNacimiento")
    private String paisDeNacimiento;

    @Column(name = "nivelAcademico")
    private String nivelAcademico;

    @Column(name = "cursoAlQuePertenece")
    private int cursoAlQuePertenece;

    @Column(name = "numeroDeTelefono")
    private long numeroDeTelefono;

    @Column(name = "email")
    private String email;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "nombreDelAcudiente")
    private String nombreDelAcudiente;

    @Column(name = "relacionEntreElAcudienteYEstudiante")
    private String relacionEntreElAcudienteYEstudiante;

    @Column(name = "telefonoDelAcudiente")
    private Long telefonoDelAcudiente;

    @Column(name = "emailDelAcudiente")
    private String emailDelAcudiente;





}
