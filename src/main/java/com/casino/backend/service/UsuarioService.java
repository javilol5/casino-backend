package com.casino.backend.service;

import com.casino.backend.model.Usuario;
import com.casino.backend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public Usuario crearUsuario(Usuario u) {
        u.setSaldo(1000); // saldo inicial casino
        return repo.save(u);
    }

    public List<Usuario> listar() {
        return repo.findAll();
    }
}