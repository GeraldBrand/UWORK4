package pe.edu.upc.s3155_uwork4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.s3155_uwork4.entities.Archivo;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IArchivoRepository extends JpaRepository<Archivo, Integer> {

    //METODO PARA LISTAR ARCHIVOS POR ID DE ASESORIA REPOSITORY
    List<Archivo> findByAsesoriaIdAsesoria(int idAsesoria);

    @Query("SELECT a FROM Archivo a WHERE a.usuario.idUsuario = :idUsuario AND a.fechaSubida = :fecha ORDER BY a.nombreArchivo ASC")
    List<Archivo> buscarPorUsuarioYFecha(@Param("idUsuario") int idUsuario, @Param("fecha") LocalDate fecha);


}