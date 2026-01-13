package pe.fact.gestor.authtablasmaestras.Gestion_Concepto.controller;


import org.springframework.web.bind.annotation.*;
import pe.fact.gestor.authtablasmaestras.Gestion_Concepto.entity.Concepto;
import pe.fact.gestor.authtablasmaestras.Gestion_Concepto.service.ConceptoService;

import java.util.List;

@RestController
@RequestMapping("/concepto")
@CrossOrigin(origins = "*")
public class ConceptoController {

    private final ConceptoService conceptoService;

    public ConceptoController(ConceptoService conceptoService) {
        this.conceptoService = conceptoService;
    }

    // GET → LISTAR
    @GetMapping("/listar")
    public List<Concepto> listar() {
        return conceptoService.listar();
    }

    // POST → AGREGAR
    @PostMapping("/agregar")
    public void agregar(@RequestBody Concepto concepto) {
        conceptoService.agregar(concepto);
    }

    // PUT → MODIFICAR
    @PutMapping("/modificar")
    public void modificar(@RequestBody Concepto concepto) {
        conceptoService.modificar(concepto);
    }
}
