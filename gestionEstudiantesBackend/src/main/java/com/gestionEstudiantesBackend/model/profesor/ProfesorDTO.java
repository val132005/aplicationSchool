package com.gestionEstudiantesBackend.model.profesor;

import com.gestionEstudiantesBackend.model.curso.CursoDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorDTO {

    @NotNull
    private String estado;
    @NotNull
    private String nombre;
    @NotNull
    private String tipoDocumento;
    @NotNull
    private long numeroDeDocumento;
    private String genero;
    @NotNull
    private int edad;
    @NotNull
    private Date fechaDeNacimiento;
    private String ciudadDeNacimiento;
    private String paisDeNacimiento;
    @NotNull
    private long numeroDeTelefono;
    @Email
    @NotNull
    private String email;
    @NotNull
    private String direccion;
    @NotNull
    private CursoDTO cursoDTO;


}
