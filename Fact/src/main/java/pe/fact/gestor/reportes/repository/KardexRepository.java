package pe.fact.gestor.reportes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.fact.gestor.reportes.entity.Kardex;
import pe.fact.gestor.reportes.dto.ReporteKardexDTO;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface KardexRepository extends JpaRepository<Kardex, Integer> {

    // Consulta optimizada: Trae solo lo necesario y cruza con Producto
    // Asumimos que la entidad Producto se llama 'Producto' y tiene 'codiProd'
    @Query("SELECT new pe.fact.gestor.reportes.dto.ReporteKardexDTO(" +
            "k.codiKard, k.fechMovi, p.nombProd, k.cantProd, k.cantSald, k.obseMovi, k.codiTipo) " +
            "FROM Kardex k, Producto p " +
            "WHERE k.codiProd = p.codiProd " +
            "AND k.fechMovi BETWEEN :fechaInicio AND :fechaFin " +
            "ORDER BY k.fechMovi DESC")
    List<ReporteKardexDTO> reportePorFechas(@Param("fechaInicio") LocalDateTime fechaInicio,
                                            @Param("fechaFin") LocalDateTime fechaFin);

    @Query(value = "SELECT TOP 1 cantSald FROM kardex WHERE codiProd = ?1 ORDER BY codiKard DESC", nativeQuery = true)
    Integer findLastSaldo(Integer codiProd);
}