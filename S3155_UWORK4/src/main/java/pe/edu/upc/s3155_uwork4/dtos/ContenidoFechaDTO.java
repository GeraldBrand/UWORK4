package pe.edu.upc.s3155_uwork4.dtos;

import java.time.LocalDate;

public class ContenidoFechaDTO {
    private String contenido;
    private LocalDate fechaMensaje;

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFechaMensaje() {
        return fechaMensaje;
    }

    public void setFechaMensaje(LocalDate fechaMensaje) {
        this.fechaMensaje = fechaMensaje;
    }
}
