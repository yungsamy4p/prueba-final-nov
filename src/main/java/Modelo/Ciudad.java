package Modelo;

public class Ciudad {
    private String nombreCiudad;
    private int poblacionCiudad;
    private String codigoPais;

    public Ciudad(int idCiudad, String nombreCiudad, int poblacionCiudad, String codigoPais) {
        this.nombreCiudad = nombreCiudad;
        this.poblacionCiudad = poblacionCiudad;
        this.codigoPais = codigoPais;
    }


    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public int getPoblacionCiudad() {
        return poblacionCiudad;
    }

    public void setPoblacionCiudad(int poblacionCiudad) {
        this.poblacionCiudad = poblacionCiudad;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    @Override
    public String toString() {
        return "Ciudad{" + "idCiudad=" + ", nombreCiudad=" + nombreCiudad + ", poblacionCiudad=" + poblacionCiudad + ", codigoPais=" + codigoPais + '}';
    }
    

}