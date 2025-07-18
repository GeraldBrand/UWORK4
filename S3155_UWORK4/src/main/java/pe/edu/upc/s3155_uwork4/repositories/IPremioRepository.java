package pe.edu.upc.s3155_uwork4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.s3155_uwork4.entities.Premio;

import java.util.List;

@Repository
public interface IPremioRepository extends JpaRepository<Premio, Integer> {
    // Puedes agregar consultas personalizadas aquí si las necesitas
    public List<Premio> findByNombrePremContainingIgnoreCase(String keyword);
}

