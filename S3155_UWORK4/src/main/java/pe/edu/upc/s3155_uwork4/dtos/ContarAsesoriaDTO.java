package pe.edu.upc.s3155_uwork4.dtos;

import java.time.LocalDate;

public class ContarAsesoriaDTO {
    private LocalDate fechaAsesoria;
    private int cantidad;

    public LocalDate getFechaAsesoria() {
        return fechaAsesoria;
    }

    public void setFechaAsesoria(LocalDate fechaAsesoria) {
        this.fechaAsesoria = fechaAsesoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
