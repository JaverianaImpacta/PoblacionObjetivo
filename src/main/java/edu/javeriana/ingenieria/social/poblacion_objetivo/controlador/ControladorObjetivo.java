package edu.javeriana.ingenieria.social.poblacion_objetivo.controlador;

import edu.javeriana.ingenieria.social.poblacion_objetivo.dominio.Objetivo;
import edu.javeriana.ingenieria.social.poblacion_objetivo.servicio.ServicioObjetivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/poblacionesObjetivo")
@CrossOrigin(origins="http://localhost:4200")
public class ControladorObjetivo {
    @Autowired
    private ServicioObjetivo servicio;

    @GetMapping("listar")
    public List<Objetivo> obtenerPoblacioensObjetivo() {
        return servicio.obtenerPoblacionesObjetivo();
    }

    @GetMapping("obtener")
    public ResponseEntity<Objetivo> obtenerPoblacionObjetivo(@RequestParam Integer id){
        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!servicio.poblacionObjetivoExiste(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerPoblacionObjetivo(id), HttpStatus.OK);
    }

    @PostMapping("crear")
    public ResponseEntity<Objetivo> crearPoblacionObjetivo(@RequestBody Objetivo objetivo){
        if(objetivo == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(servicio.poblacionObjetivoExiste(objetivo.getId())){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(servicio.crearPoblacionObjetivo(objetivo), HttpStatus.CREATED);
    }

    @PutMapping("actualizar")
    public ResponseEntity<Objetivo> actualizarPoblacionObjetivo(@RequestParam Integer id, @RequestBody Objetivo objetivo){
        if(id == null || objetivo == null || !id.equals(objetivo.getId())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(servicio.actualizarPoblacionObjetivo(id, objetivo) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(objetivo, HttpStatus.OK);
    }

    @DeleteMapping("eliminar")
    public ResponseEntity<HttpStatus> borrarPoblacionObjetivo(@RequestParam Integer id){
        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(servicio.borrarPoblacionObjetivo(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
