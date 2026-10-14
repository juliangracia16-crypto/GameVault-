package com.example.GameVault.service;

import com.example.GameVault.models.Usuario;
import com.example.GameVault.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario obtenerUsuarioLogeado(){
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(1l);
        if(usuarioOpt.isPresent()){
            return usuarioOpt.get();
        }else{
            Usuario usuario = new Usuario();
            usuario.setContrasenia("1234");
            usuario.setEmail("itson@itson.edu.mx");
            usuario.setNombre("Itson");
            return usuarioRepository.save(usuario);
        }
    }
}
