package dam.carlosbarrionuevo.ut3menuofactivities.model;

import android.widget.ImageView;

import java.io.Serializable;

public class Item  implements Serializable {
    private int idImagen;
    private String version;
    private String nombre_Version;
    private String  year;
    private String napi;
    private String url;




    public Item() {
    }

    public Item(int idImagen, String version, String nombre_Version, String year, String napi, String url) {
        this.idImagen = idImagen;
        this.version = version;
        this.nombre_Version = nombre_Version;
        this.year = year;
        this.napi = napi;
        this.url = url;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getNombre_Version() {
        return nombre_Version;
    }

    public void setNombre_Version(String nombre_Version) {
        this.nombre_Version = nombre_Version;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getNapi() {
        return napi;
    }

    public void setNapi(String napi) {
        this.napi = napi;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Item{" +
                "idImagen=" + idImagen +
                ", version='" + version + '\'' +
                ", nombre_Version='" + nombre_Version + '\'' +
                ", year=" + year +
                ", napi=" + napi +
                ", url='" + url + '\'' +
                '}';
    }
}

