package edu.javeriana.ingenieria.social.poblacion_objetivo.servicio;

import edu.javeriana.ingenieria.social.poblacion_objetivo.dominio.Objetivo;
import edu.javeriana.ingenieria.social.poblacion_objetivo.repositorio.RepositorioObjetivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioObjetivo {
    @Autowired
    private RepositorioObjetivo repositorio;

    public List<Objetivo> obtenerPoblacionesObjetivo(){
        return repositorio.findAll();
    }

    public Objetivo obtenerPoblacionObjetivo(Integer id){
        return repositorio.findById(id).orElse(null);
    }

    public Objetivo crearPoblacionObjetivo(Objetivo objetivo){
        return repositorio.save(objetivo);
    }

    public Objetivo actualizarPoblacionObjetivo(Integer id, Objetivo objetivo){
        if(!poblacionObjetivoExiste(id)){
            return null;
        }
        objetivo.setId(id);
        return repositorio.save(objetivo);
    }

    public Objetivo borrarPoblacionObjetivo(Integer id){
        Objetivo aux = repositorio.findById(id).orElse(null);
        if(aux == null){
            return null;
        }
        repositorio.delete(aux);
        return aux;
    }

    public boolean poblacionObjetivoExiste(Integer id){
        return repositorio.existsById(id);
    }
}
