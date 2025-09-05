package com.example.tienda.Service;

import com.example.tienda.DTO.UsuarioCreatedDTO;
import com.example.tienda.Repository.UsuarioRepository;
import com.example.tienda.model.usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {  private final UsuarioRepository repository;


    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<usuario> listarTodas() {
        return repository.findAll();
    }

    public usuario guardar(usuario usu) {
        return repository.save(usu);
    }

    public usuario obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public usuario actualizar(Long id, UsuarioCreatedDTO datos) {
        usuario rep = obtenerPorId(id);
        rep.setNombre(datos.getNombre());
        rep.setEmail(datos.getEmail());
        return repository.save(rep);
    }


}
