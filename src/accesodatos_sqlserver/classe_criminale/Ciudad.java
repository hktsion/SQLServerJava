package accesodatos_sqlserver.classe_criminale;

/**
 * @version 1.1;
 * @author h3kt0r;  
 * @see hectorochoa.es
 */
public class Ciudad {

    private String _id;
    private String pais;
    private String ciudad;
    private String ruta_imagen;
    private String lugares;
    private String aux;

    public Ciudad() {
        System.out.println("Creado un nuevo objeto ciudad");
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getAux() {
        return aux;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setAux(String aux) {
        this.aux = aux;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setRuta_imagen(String ruta_imagen) {
        this.ruta_imagen = ruta_imagen;
    }

    public void setLugares(String lugares) {
        this.lugares = lugares;
    }

    public String getId() {
        return _id;
    }

    public String getPais() {
        return pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getRuta_imagen() {
        return ruta_imagen;
    }

    public String getLugares() {
        return lugares;
    }

}
