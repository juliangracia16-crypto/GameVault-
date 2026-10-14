package com.example.GameVault.repository;

import com.example.GameVault.models.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JuegoRepository extends JpaRepository<Juego, Long> {

    List<Juego> findByTituloContainingIgnoreCase(String titulo);

    List<Juego> findByUsuarioId(Long usuarioId);

    List<Juego> findByPrecioLessThan(Double precio);

    @Query("SELECT j FROM Juego j ORDER BY j.id DESC")
    List<Juego> obtenerJuegosRecientes();

    @Query("SELECT j FROM Juego j WHERE LOWER(j.descripcion) LIKE LOWER(CONCAT('m%', :palabra,'%'))")
    List<Juego> buscarPorDescripcion(String palabra);
}
