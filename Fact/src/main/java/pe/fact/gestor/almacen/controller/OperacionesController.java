package pe.fact.gestor.almacen.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.fact.gestor.almacen.repository.ViewAlmacenRepository;
import pe.fact.gestor.almacen.service.AlmacenService;
import pe.fact.gestor.tablasmaestras.entity.Producto;
import pe.fact.gestor.tablasmaestras.entity.Tecnico;
import pe.fact.gestor.tablasmaestras.repository.ProductoRepository;
import pe.fact.gestor.tablasmaestras.repository.TecnicoRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/operaciones")
@CrossOrigin(origins = "*")
public class OperacionesController {

    @Autowired private ProductoRepository productoRepo;
    @Autowired private TecnicoRepository tecnicoRepo;
    @Autowired private AlmacenService almacenService;
    @Autowired private ViewAlmacenRepository viewAlmacenRepo;

    // ELIMINAMOS validarSesion y cerrarsesion porque ahora
    // eso lo maneja tu AuthController (el del puerto 8082)

    @RequestMapping(value = "/productocrud", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> productoCRUD(@RequestParam String tipo,
                                            @RequestParam(required = false) Integer codigo,
                                            @RequestParam(required = false) String nombre) {
        Map<String, Object> response = new HashMap<>();
        try {
            switch (tipo) {
                case "1": response.put("data", productoRepo.findAll()); break;
                case "2": response.put("data", productoRepo.findById(codigo).orElse(null)); break;
                case "3":
                    productoRepo.save(new Producto(0, nombre));
                    response.put("resultado", "ok");
                    break;
                case "4":
                    Producto p = productoRepo.findById(codigo).orElseThrow();
                    p.setNombProd(nombre);
                    productoRepo.save(p);
                    response.put("resultado", "ok");
                    break;
            }
        } catch (Exception e) { response.put("resultado", "error"); }
        return response;
    }

    @RequestMapping(value = "/trabajadorcrud", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> tecnicoCRUD(@RequestParam String tipo,
                                           @RequestParam(required = false) Integer codigo,
                                           @RequestParam(required = false) String nombre,
                                           @RequestParam(required = false) String dni) {
        Map<String, Object> response = new HashMap<>();
        try {
            switch (tipo) {
                case "1": response.put("data", tecnicoRepo.findAll()); break;
                case "2": response.put("data", tecnicoRepo.findById(codigo).orElse(null)); break;
                case "3":
                    tecnicoRepo.save(new Tecnico(0, nombre, dni));
                    response.put("resultado", "ok");
                    break;
                case "4":
                    Tecnico t = tecnicoRepo.findById(codigo).orElseThrow();
                    t.setNombTecn(nombre);
                    t.setDniTecn(dni);
                    tecnicoRepo.save(t);
                    response.put("resultado", "ok");
                    break;
            }
        } catch (Exception e) { response.put("resultado", "error"); }
        return response;
    }

    @RequestMapping(value = "/registrarmovimiento", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, String> registrarMovimiento(
            @RequestParam Integer codiProd, @RequestParam Integer codiTipo,
            @RequestParam Integer codiTrab, @RequestParam Integer cantProd,
            @RequestParam String obseMovi,
            @RequestParam(required = false) Integer codiUsu) { // Cambiado: ya no usa HttpSession

        Map<String, String> res = new HashMap<>();
        try {
            // Si el token no nos envía el usuario aún, usamos el 1 por defecto
            Integer usuarioId = (codiUsu != null) ? codiUsu : 1;

            almacenService.registrarMovimiento(codiProd, codiTipo, codiTrab, cantProd, obseMovi, usuarioId);
            res.put("resultado", "ok");
        } catch (Exception e) {
            res.put("resultado", "error");
        }
        return res;
    }

    @RequestMapping(value = "/mostrarsaldos", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> mostrarSaldos() {
        Map<String, Object> response = new HashMap<>();
        try {
            response.put("data", viewAlmacenRepo.findAll());
        } catch (Exception e) {
            response.put("data", new ArrayList<>());
            response.put("error", e.getMessage());
        }
        return response;
    }
}