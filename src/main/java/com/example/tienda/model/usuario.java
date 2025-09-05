package com.example.tienda.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "usuario")
public class usuario  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotNull
    @Size(max = 120)
    @Column(unique = true, nullable = false, length = 120)
    private String email;

    @NotNull
    @Size(max = 120)
    private String nombre;

    @NotNull
    @Size(min = 6, max = 255)
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference(value = "usuario-quejas")
    private List<Queja> quejas;

    @NotNull
    @Column(name = "creado_en", nullable = false, updatable = false)
    private LocalDateTime creadoEn = LocalDateTime.now();


    public long getId() { return id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public void setPassword(String password) { this.password = password; }








    public List<Queja> getQuejas() { return quejas; }
    public void setQuejas(List<Queja> quejas) { this.quejas = quejas; }

}