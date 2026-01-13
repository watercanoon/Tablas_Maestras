package pe.fact.gestor.authtablasmaestras.Gestion_Cliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.fact.gestor.authtablasmaestras.Gestion_Cliente.entity.Cliente;
import pe.fact.gestor.authtablasmaestras.Gestion_Cliente.service.ClienteService;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    // 1. GET /cliente/listar
    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    // 2. y 3. BÚSQUEDA HÍBRIDA (Código o Dirección)
    // Cumple con: /cliente/listar/{codigo} Y /cliente/listar/{direccion}
    @GetMapping("/listar/{parametro}")
    public ResponseEntity<?> buscar(@PathVariable("parametro") String parametro) {
        if (esNumero(parametro)) {
            // Es un número -> Buscamos por Codigo (ID)
            Cliente c = service.buscarPorId(Integer.parseInt(parametro));
            return c != null ? ResponseEntity.ok(c) : ResponseEntity.notFound().build();
        } else {
            // Es texto -> Buscamos por Direccion
            List<Cliente> lista = service.buscarPorDireccion(parametro);
            return ResponseEntity.ok(lista);
        }
    }

    // 4. POST /cliente/agregar
    @PostMapping("/agregar")
    public ResponseEntity<String> agregar(@RequestBody Cliente cliente) {
        try {
            service.registrar(cliente);
            return ResponseEntity.ok("Cliente registrado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    // 5. PUT /cliente/modificar (BODY @RequestBody)
    @PutMapping("/modificar")
    public ResponseEntity<String> modificar(@RequestBody Cliente cliente) {
        try {
            service.modificar(cliente);
            return ResponseEntity.ok("Cliente modificado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    // 6. DELETE /cliente/eliminar (DELETE @RequestParam)
    // URL esperada: /cliente/eliminar?id=1
    @DeleteMapping("/eliminar")
    public ResponseEntity<String> eliminar(@RequestParam("id") Integer id) {
        try {
            service.eliminar(id);
            return ResponseEntity.ok("Cliente eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    // --- Utilidad para detectar si es número ---
    private boolean esNumero(String str) {
        if (str == null) return false;
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}