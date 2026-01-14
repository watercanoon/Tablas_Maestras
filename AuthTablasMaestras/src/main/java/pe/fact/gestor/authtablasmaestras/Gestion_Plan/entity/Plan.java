package pe.fact.gestor.authtablasmaestras.Gestion_Plan.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "plan")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codiPlan")
    private Integer codiPlan;

    @Column(name = "nombPlan")
    private String nombPlan;

    @Column(name = "montPlan")
    private BigDecimal montPlan;

    @Column(name = "tipoPlan")
    private Integer tipoPlan;

    @Column(name = "estdPlan")
    private String estdPlan; // 'V' = Activo, 'A' = Anulado

    @Transient
    private Integer usuarioRegistroId;
}