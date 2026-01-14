package pe.fact.gestor.authtablasmaestras.Gestion_Plan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.fact.gestor.authtablasmaestras.Gestion_Plan.entity.Plan;
import pe.fact.gestor.authtablasmaestras.Gestion_Plan.repository.PlanRepository;
import java.util.List;

@Service
public class PlanService {

    @Autowired
    private PlanRepository repository;

    public List<Plan> listarTodos() {
        return repository.listarPlanes();
    }

    public void crear(Plan plan) {
        if(plan.getUsuarioRegistroId() == null) plan.setUsuarioRegistroId(1);
        repository.registrarPlan(plan.getNombPlan(), plan.getMontPlan(), plan.getTipoPlan(), plan.getUsuarioRegistroId());
    }

    // --- NUEVO ---
    public void actualizar(Plan plan) {
        if(plan.getCodiPlan() == null) throw new RuntimeException("ID requerido");
        if(plan.getUsuarioRegistroId() == null) plan.setUsuarioRegistroId(1);

        repository.actualizarPlan(
                plan.getCodiPlan(),
                plan.getNombPlan(),
                plan.getMontPlan(),
                plan.getTipoPlan(),
                plan.getUsuarioRegistroId()
        );
    }

    // --- NUEVO ---
    public void eliminar(Integer id) {
        repository.eliminarPlan(id);
    }

    public void activar(Integer id) {
        repository.activarPlan(id);
    }
}