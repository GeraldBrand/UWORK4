package pe.edu.upc.s3155_uwork4.dtos;

public class ConsultarFormatoArchivoDTO {
    String nombreArchivo;
    String extension;

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
