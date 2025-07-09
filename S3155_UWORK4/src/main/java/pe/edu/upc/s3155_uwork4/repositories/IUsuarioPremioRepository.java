package pe.edu.upc.s3155_uwork4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.s3155_uwork4.entities.UsuarioPremio;

import java.util.List;

@Repository
public interface IUsuarioPremioRepository extends JpaRepository<UsuarioPremio, Integer> {

    @Query("SELECT up.usuario, COUNT(up) as total " +
            "FROM UsuarioPremio up " +
            "GROUP BY up.usuario " +
            "HAVING COUNT(up) > :n")
    List<Object[]> findUsuariosConMasDeNPremios(@Param("n") Long n);
}
