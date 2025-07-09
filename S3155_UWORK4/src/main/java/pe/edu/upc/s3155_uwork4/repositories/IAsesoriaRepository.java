package pe.edu.upc.s3155_uwork4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.s3155_uwork4.entities.Asesoria;

import java.util.List;

@Repository
public interface IAsesoriaRepository extends JpaRepository<Asesoria, Integer> {

    List<Asesoria> findByUsuarioInferiorIdUsuarioOrUsuarioSuperiorIdUsuario(int idInferior, int idSuperior);
    //Cantidad de asesorías agrupadas por fecha
    @Query(value = "SELECT fecha_asesoria::date AS fecha, COUNT(*) AS cantidad_asesorias\n" +
            "FROM Asesoria\n" +
            "GROUP BY fecha_asesoria::date\n" +
            "ORDER BY fecha;", nativeQuery = true)
    public List<String[]> contarAsesoriasPorFecha();
}
