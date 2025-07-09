package pe.edu.upc.s3155_uwork4.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.s3155_uwork4.dtos.UsuarioConCantidadDTO;
import pe.edu.upc.s3155_uwork4.entities.Usuario;
import pe.edu.upc.s3155_uwork4.entities.UsuarioPremio;
import pe.edu.upc.s3155_uwork4.repositories.IUsuarioPremioRepository;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IUsuarioPremioService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioPremioServiceImplement implements IUsuarioPremioService {

    @Autowired
    private IUsuarioPremioRepository upR;

    @Override
    public List<UsuarioPremio> listar() {
        return upR.findAll();
    }

    @Override
    public void Registrar(UsuarioPremio up) {
        upR.save(up);
    }

    @Override
    public UsuarioPremio listarporid(int id) {
        return upR.findById(id).orElse(new UsuarioPremio());
    }

    @Override
    public void Modificar(UsuarioPremio up) {
        upR.save(up);
    }

    @Override
    public void Eliminar(int id) {
        upR.deleteById(id);
    }

    @Override
    public List<UsuarioConCantidadDTO> usuariosConMasDeNPremios(Long n) {
        List<Object[]> resultados = upR.findUsuariosConMasDeNPremios(n);
        List<UsuarioConCantidadDTO> dtoList = new ArrayList<>();

        for (Object[] fila : resultados) {
            Usuario u = (Usuario) fila[0];
            Long cantidad = (Long) fila[1];
            dtoList.add(new UsuarioConCantidadDTO(u.getUsername(), cantidad));
        }

        return dtoList;
    }
}
