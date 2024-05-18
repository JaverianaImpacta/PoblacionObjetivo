package edu.javeriana.ingenieria.social.poblacion_objetivo.repositorio;

import edu.javeriana.ingenieria.social.poblacion_objetivo.dominio.Objetivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioObjetivo extends JpaRepository<Objetivo, Integer> {
}
