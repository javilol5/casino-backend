package com.casino.backend.controller;

import com.casino.backend.model.Usuario;
import com.casino.backend.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public Usuario crear(@RequestBody Usuario u) {
        return service.crearUsuario(u);
    }

    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }
}