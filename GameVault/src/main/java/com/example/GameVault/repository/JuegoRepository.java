package com.example.GameVault.repository;

import com.example.GameVault.models.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JuegoRepository extends JpaRepository<Juego, Long> {

    List<Juego> findByTituloContainingIgnoreCase(String titulo);

    List<Juego> findByPrecioLessThan(Double precio);

    @Query("SELECT j FROM Juegos j ORDER BY j.id DESC")
    List<Juego> obtenerJuegosRecientes();

    @Query("SELECT j FROM Juegos j WHERE LOWER(j.descripcion) LIKE LOWER(CONCAT('m%', :palabra,'%'))")
    List<Juego> buscarPorDescripcion(String palabra);
}
