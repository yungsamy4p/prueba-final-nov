package Modelo;

public class Idioma {
    private String nombreIdioma;
    private boolean oficial;
    private String codigoPais;


    public Idioma(int idIdioma, String nombreIdioma, boolean oficial, String codigoPais) {
        this.nombreIdioma = nombreIdioma;
        this.oficial = oficial;
        this.codigoPais = codigoPais;
    }


    public String getNombreIdioma() {
        return nombreIdioma;
    }

    public void setNombreIdioma(String nombreIdioma) {
        this.nombreIdioma = nombreIdioma;
    }

    public boolean isOficial() {
        return oficial;
    }

    public void setOficial(boolean oficial) {
        this.oficial = oficial;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    @Override
    public String toString() {
        return "Idioma{" + "idIdioma=" + ", nombreIdioma=" + nombreIdioma + ", oficial=" + oficial + ", codigoPais=" + codigoPais + '}';
    }


}