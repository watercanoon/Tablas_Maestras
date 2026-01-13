package pe.fact.gestor.authtablasmaestras.Gestion_Personal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "personal")
public class Personal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codiPers")
    private Integer codiPers;

    @Column(name = "TipoDocu")
    private String tipoDocu;

    @Column(name = "numeDocu")
    private String numeDocu;

    @Column(name = "appaPers")
    private String appaPers;

    @Column(name = "apmaPers")
    private String apmaPers;

    @Column(name = "nombPers")
    private String nombPers;

    @Column(name = "codiHora")
    private Integer codiHora;

    @Column(name = "codiRol")
    private Integer codiRol;

    @Column(name = "estaPers")
    private Integer estaPers;

    // ===== GETTERS Y SETTERS =====

    public Integer getCodiPers() {
        return codiPers;
    }

    public void setCodiPers(Integer codiPers) {
        this.codiPers = codiPers;
    }

    public String getTipoDocu() {
        return tipoDocu;
    }

    public void setTipoDocu(String tipoDocu) {
        this.tipoDocu = tipoDocu;
    }

    public String getNumeDocu() {
        return numeDocu;
    }

    public void setNumeDocu(String numeDocu) {
        this.numeDocu = numeDocu;
    }

    public String getAppaPers() {
        return appaPers;
    }

    public void setAppaPers(String appaPers) {
        this.appaPers = appaPers;
    }

    public String getApmaPers() {
        return apmaPers;
    }

    public void setApmaPers(String apmaPers) {
        this.apmaPers = apmaPers;
    }

    public String getNombPers() {
        return nombPers;
    }

    public void setNombPers(String nombPers) {
        this.nombPers = nombPers;
    }

    public Integer getCodiHora() {
        return codiHora;
    }

    public void setCodiHora(Integer codiHora) {
        this.codiHora = codiHora;
    }

    public Integer getCodiRol() {
        return codiRol;
    }

    public void setCodiRol(Integer codiRol) {
        this.codiRol = codiRol;
    }

    public Integer getEstaPers() {
        return estaPers;
    }

    public void setEstaPers(Integer estaPers) {
        this.estaPers = estaPers;
    }
}
