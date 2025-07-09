package pe.edu.upc.s3155_uwork4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.s3155_uwork4.entities.Usuario;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    public Usuario findOneByUsername(String nombreUsuario);
    @Query(value="SELECT \n" +
            "  u.id_usuario,\n" +
            "  u.username,\n" +
            "  u.correo,\n" +
            "  u.ciclo,\n" +
            "  u.puntos,\n" +
            "  u.carrera,\n" +
            "  u.centro_de_estudios,\n" +
            "  u.id_rol,\n" +
            "  u.estado\n" +
            "FROM usuario u;", nativeQuery = true)
    public List<String[]> ListarUsernameSinPassword();

    //Mensajes de un usuario ordenados por fecha
    @Query(value = "SELECT m.contenido, m.fecha_mensaje\n" +
            "FROM Mensaje m\n" +
            "WHERE m.id_usuario = :id_usuario\n" +
            "ORDER BY m.fecha_mensaje ASC;", nativeQuery = true)
    public List<String[]> BuscarMensajeOrdenadosPorFecha(@Param("id_usuario") int id_usuario);

}
