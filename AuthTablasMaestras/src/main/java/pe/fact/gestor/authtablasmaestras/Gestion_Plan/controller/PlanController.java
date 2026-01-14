package pe.fact.gestor.authtablasmaestras.Gestion_Plan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.fact.gestor.authtablasmaestras.Gestion_Plan.entity.Plan;
import pe.fact.gestor.authtablasmaestras.Gestion_Plan.service.PlanService;
import java.util.List;

@RestController
@RequestMapping("/api/planes")
@CrossOrigin(origins = "*")
public class PlanController {

    @Autowired
    private PlanService service;

    @GetMapping("/listar")
    public ResponseEntity<List<Plan>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> guardar(@RequestBody Plan plan) {
        try {
            service.crear(plan);
            return ResponseEntity.ok("Plan registrado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    // --- NUEVO: MODIFICAR ---
    @PutMapping("/modificar")
    public ResponseEntity<String> modificar(@RequestBody Plan plan) {
        try {
            service.actualizar(plan);
            return ResponseEntity.ok("Plan actualizado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    // --- NUEVO: ELIMINAR ---
    @DeleteMapping("/eliminar")
    public ResponseEntity<String> eliminar(@RequestParam("id") Integer id) {
        try {
            service.eliminar(id);
            return ResponseEntity.ok("Plan eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/activar") // Usamos PUT porque actualizamos estado
    public ResponseEntity<String> activar(@RequestParam("id") Integer id) {
        try {
            service.activar(id);
            return ResponseEntity.ok("Plan activado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}