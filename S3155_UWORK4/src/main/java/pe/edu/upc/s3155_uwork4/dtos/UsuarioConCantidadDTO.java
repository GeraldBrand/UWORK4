package pe.edu.upc.s3155_uwork4.dtos;

public class UsuarioConCantidadDTO {
    private String nombreUsuario;
    private Long cantidadPremios;

    public UsuarioConCantidadDTO() {}

    public UsuarioConCantidadDTO(String nombreUsuario, Long cantidadPremios) {
        this.nombreUsuario = nombreUsuario;
        this.cantidadPremios = cantidadPremios;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Long getCantidadPremios() {
        return cantidadPremios;
    }

    public void setCantidadPremios(Long cantidadPremios) {
        this.cantidadPremios = cantidadPremios;
    }
}
