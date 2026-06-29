package com.utp.cochera.service;

import com.utp.cochera.exception.RecursoNoEncontradoException;
import com.utp.cochera.model.Usuario;
import com.utp.cochera.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listar() { return usuarioRepository.findAll(); }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Usuario no encontrado"));
    }

    public Usuario crear(Usuario usuario) { return usuarioRepository.save(usuario); }

    public Usuario actualizar(Long id, Usuario datos) {
        Usuario usuario = buscarPorId(id);
        usuario.setNombres(datos.getNombres());
        usuario.setCorreo(datos.getCorreo());
        usuario.setRol(datos.getRol());
        return usuarioRepository.save(usuario);
    }

    public void eliminar(Long id) { usuarioRepository.delete(buscarPorId(id)); }
}
