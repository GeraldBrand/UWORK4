package pe.edu.upc.s3155_uwork4.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.s3155_uwork4.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> listar();
    public void Registrar(Usuario u);
    public Usuario listarporid(int id);
    public void Modificar(Usuario u);
    public void Eliminar(int id);
    public List<String[]> ListarUsernameSinPassword();
    public List<String[]> BuscarMensajeOrdenadosPorFecha(int id_usuario);
}
