package com.pi.medsync.service;

import com.pi.medsync.model.Usuario;
import com.pi.medsync.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Método para criar um novo usuário
    public Usuario criarUsuario(Usuario usuario) {
        // Você pode adicionar mais validações aqui, como checar se o email já existe

        // Salvar o novo usuário no banco de dados
        return usuarioRepository.save(usuario);
    }

    // Método para buscar um usuário pelo email (exemplo adicional)
    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}
