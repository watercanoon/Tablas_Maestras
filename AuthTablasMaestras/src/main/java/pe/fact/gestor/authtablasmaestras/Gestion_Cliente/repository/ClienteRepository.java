package pe.fact.gestor.authtablasmaestras.Gestion_Cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.fact.gestor.authtablasmaestras.Gestion_Cliente.entity.Cliente;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    // sp_fact_cliente_agregar (Insertar)
    @Modifying
    @Transactional
    @Query(value = "CALL sp_fact_cliente_insertar(:tipo, :num, :pat, :mat, :nom, :raz, :mail, :dire, :sexo, :cel, :pass, :usu)", nativeQuery = true)
    void registrarCliente(
            @Param("tipo") String tipoDoc, @Param("num") String numDoc,
            @Param("pat") String paterno, @Param("mat") String materno,
            @Param("nom") String nombres, @Param("raz") String razonSocial,
            @Param("mail") String correo, @Param("dire") String direccion,
            @Param("sexo") String sexo, @Param("cel") String celular,
            @Param("pass") String password, @Param("usu") Integer usuarioId
    );

    // sp_fact_cliente_modificar
    @Modifying
    @Transactional
    @Query(value = "CALL sp_fact_cliente_modificar(:id, :tipo, :num, :pat, :mat, :nom, :raz, :mail, :dire, :sexo, :cel, :usu)", nativeQuery = true)
    void actualizarCliente(
            @Param("id") Integer id, @Param("tipo") String tipoDoc,
            @Param("num") String numDoc, @Param("pat") String paterno,
            @Param("mat") String materno, @Param("nom") String nombres,
            @Param("raz") String razonSocial, @Param("mail") String correo,
            @Param("dire") String direccion, @Param("sexo") String sexo,
            @Param("cel") String celular, @Param("usu") Integer usuarioId
    );

    // sp_fact_cliente_eliminar
    @Modifying
    @Transactional
    @Query(value = "CALL sp_fact_cliente_eliminar(:id)", nativeQuery = true)
    void eliminarCliente(@Param("id") Integer id);

    // sp_fact_cliente_listar
    @Query(value = "CALL sp_fact_cliente_listar()", nativeQuery = true)
    List<Cliente> listarClientes();

    // sp_fact_cliente_listar_codigo
    @Query(value = "CALL sp_fact_cliente_listar_codigo(:id)", nativeQuery = true)
    Cliente buscarPorCodigo(@Param("id") Integer id);

    // sp_fact_cliente_listar_direccion
    @Query(value = "CALL sp_fact_cliente_listar_direccion(:dire)", nativeQuery = true)
    List<Cliente> buscarPorDireccion(@Param("dire") String direccion);
}