package com.senai.apiusuarios.repository;

import com.senai.apiusuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

// Usuario é a minha superclasse, e o Long é o tipo de dado da minha chave primária de Usuario
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
