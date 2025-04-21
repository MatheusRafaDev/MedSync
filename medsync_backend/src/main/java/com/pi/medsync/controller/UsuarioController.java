package com.pi.medsync.controller;

import com.pi.medsync.model.Usuario;
import com.pi.medsync.repository.UsuarioRepository;
import com.pi.medsync.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*") // libera o acesso para o frontend
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioService usuarioService;

    // Listar todos os usuários
    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public Optional<Usuario> buscarPorId(@PathVariable Long id) {
        return usuarioRepository.findById(id);
    }

    // Criar novo usuário
    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        // Você pode adicionar outras validações aqui, como verificar se o email já existe
        if (usuarioService.buscarPorEmail(usuario.getEmail()) != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);  // Email já cadastrado
        }

        Usuario usuarioCriado = usuarioService.criarUsuario(usuario);
        return new ResponseEntity<>(usuarioCriado, HttpStatus.CREATED);
    }

    // Atualizar usuário existente
    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setEmail(usuarioAtualizado.getEmail());
        usuario.setSenha(usuarioAtualizado.getSenha());
        usuario.setTipo(usuarioAtualizado.getTipo());
        usuario.setAtivo(usuarioAtualizado.isAtivo());
        return usuarioRepository.save(usuario);
    }

    // Deletar usuário
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }
}
