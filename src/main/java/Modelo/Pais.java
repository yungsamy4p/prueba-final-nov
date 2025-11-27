package Modelo;

public class Pais {
    private String nombrePais;
    private String continentePais;
    private int poblacionPais;
    private String codigoPais;
    private boolean tipoGobierno;


    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getContinentePais() {
        return continentePais;
    }

    public void setContinentePais(String continentePais) {
        this.continentePais = continentePais;
    }

    public int getPoblacionPais() {
        return poblacionPais;
    }

    public void setPoblacionPais(int poblacionPais) {
        this.poblacionPais = poblacionPais;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public boolean isTipoGobierno() {
        return tipoGobierno;
    }

    public void setTipoGobierno(boolean tipoGobierno) {
        this.tipoGobierno = tipoGobierno;
    }

    @Override
    public String toString() {
        return "Pais{" + "idCiudad=" + ", nombrePais=" + nombrePais + ", continentePais=" + continentePais + ", poblacionPais=" + poblacionPais + ", codigoPais=" + codigoPais + ", tipoGobierno=" + tipoGobierno + '}';
    }
    
}
