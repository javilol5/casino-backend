package com.casino.backend.service;

import com.casino.backend.model.Usuario;
import com.casino.backend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    // REGISTRO
    public Usuario register(Usuario u) {

        Optional<Usuario> existing = repo.findByUsername(u.getUsername());

        if (existing.isPresent()) {
            throw new RuntimeException("El usuario ya existe");
        }

        u.setSaldo(1000.0);
        return repo.save(u);
    }

    // LOGIN
    public Usuario login(String username, String password) {

        Usuario user = repo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return user;
    }
}