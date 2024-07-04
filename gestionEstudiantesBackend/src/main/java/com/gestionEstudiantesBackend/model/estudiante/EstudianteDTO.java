package com.gestionEstudiantesBackend.model.estudiante;

import lombok.*;
import jakarta.validation.constraints.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteDTO {

    @NotNull
    @Size(min = 1, max = 50)
    private String nombre;
    @NotNull
    private String estado;
    @NotNull
    private String tipoDocumento;
    @NotNull
    private long numeroDeDocumento;
    @NotNull
    private String genero;
    @NotNull
    private int edad;
    @NotNull
    private Date fechaDeNacimiento;
    private String ciudadDeNacimiento;
    private String paisDeNacimiento;
    @NotNull
    private String nivelAcademico;
    @NotNull
    private int cursoAlQuePertenece;
    @NotNull
    private long numeroDeTelefono;
    @Email
    private String email;
    @NotNull
    private String direccion;
    @NotNull
    private String nombreDelAcudiente;
    @NotNull
    private String relacionEntreElAcudienteYEstudiante;
    @NotNull
    private Long telefonoDelAcudiente;
    @Email
    @NotNull
    private String emailDelAcudiente;
    }

