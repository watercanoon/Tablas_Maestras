package pe.fact.gestor.authtablasmaestras.Gestion_Cliente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.fact.gestor.authtablasmaestras.Gestion_Cliente.entity.Cliente;
import pe.fact.gestor.authtablasmaestras.Gestion_Cliente.repository.ClienteRepository;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public void registrar(Cliente c) {
        // Validar usuario auditoria por defecto
        if(c.getUsuarioRegistroId() == null) c.setUsuarioRegistroId(1);
        if(c.getRaznSociClie() == null) c.setRaznSociClie("-"); // Evitar null en SP

        repository.registrarCliente(
                c.getCodiTipoDocu(), c.getNumeDocu(), c.getAppaClie(), c.getApmaClie(),
                c.getNombClie(), c.getRaznSociClie(), c.getMailClie(), c.getDireClie(),
                c.getSexoClie(), c.getCeluClie(), c.getPassClie(), c.getUsuarioRegistroId()
        );
    }

    public void modificar(Cliente c) {
        if(c.getCodiClie() == null) throw new RuntimeException("ID requerido para modificar");
        if(c.getUsuarioRegistroId() == null) c.setUsuarioRegistroId(1);

        repository.actualizarCliente(
                c.getCodiClie(), c.getCodiTipoDocu(), c.getNumeDocu(), c.getAppaClie(),
                c.getApmaClie(), c.getNombClie(), c.getRaznSociClie(), c.getMailClie(),
                c.getDireClie(), c.getSexoClie(), c.getCeluClie(), c.getUsuarioRegistroId()
        );
    }

    public void eliminar(Integer id) {
        repository.eliminarCliente(id);
    }

    public List<Cliente> listar() {
        return repository.listarClientes();
    }

    public Cliente buscarPorId(Integer id) {
        return repository.buscarPorCodigo(id);
    }

    public List<Cliente> buscarPorDireccion(String direccion) {
        return repository.buscarPorDireccion(direccion);
    }
}