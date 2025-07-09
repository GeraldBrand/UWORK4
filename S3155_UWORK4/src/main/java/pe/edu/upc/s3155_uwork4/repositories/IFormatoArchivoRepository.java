package pe.edu.upc.s3155_uwork4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.s3155_uwork4.entities.FormatoArchivo;

import java.util.List;

@Repository
public interface IFormatoArchivoRepository extends JpaRepository<FormatoArchivo, Integer> {
    //Consultar formato de archivos subidos con extensión ".docx"
    @Query(value = "SELECT a.nombre_archivo, fa.extension\n" +
            "FROM Archivo a\n" +
            "JOIN formato_archivo fa ON a.id_formato_archivo = fa.id\n" +
            "WHERE LOWER(fa.extension) = '.docx';", nativeQuery = true)
    public List<String[]> buscarArchivosDocx();
}
