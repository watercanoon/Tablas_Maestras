package pe.fact.gestor.authtablasmaestras.Gestion_Concepto.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "concepto")
public class Concepto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codiConc;

    private String nombConc;
    private Double montConc;
    private Integer codiPlan;
    private Integer codiMes;
    private String estdConc;

    // Getters y Setters
    public Integer getCodiConc() {
        return codiConc;
    }

    public void setCodiConc(Integer codiConc) {
        this.codiConc = codiConc;
    }

    public String getNombConc() {
        return nombConc;
    }

    public void setNombConc(String nombConc) {
        this.nombConc = nombConc;
    }

    public Double getMontConc() {
        return montConc;
    }

    public void setMontConc(Double montConc) {
        this.montConc = montConc;
    }

    public Integer getCodiPlan() {
        return codiPlan;
    }

    public void setCodiPlan(Integer codiPlan) {
        this.codiPlan = codiPlan;
    }

    public Integer getCodiMes() {
        return codiMes;
    }

    public void setCodiMes(Integer codiMes) {
        this.codiMes = codiMes;
    }

    public String getEstdConc() {
        return estdConc;
    }

    public void setEstdConc(String estdConc) {
        this.estdConc = estdConc;
    }
}
