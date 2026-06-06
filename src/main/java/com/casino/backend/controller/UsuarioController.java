package com.casino.backend.controller;

import com.casino.backend.model.Usuario;
import com.casino.backend.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }
    // REGISTRO
    @PostMapping("/register")
    public Usuario register(@RequestBody Usuario u) {
        return service.register(u);
    }

    // LOGIN
    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario u) {
        return service.login(u.getUsername(), u.getPassword());
    }
}