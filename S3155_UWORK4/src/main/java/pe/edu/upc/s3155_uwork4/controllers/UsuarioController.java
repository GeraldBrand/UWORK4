package pe.edu.upc.s3155_uwork4.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.s3155_uwork4.dtos.ContenidoFechaDTO;
import pe.edu.upc.s3155_uwork4.dtos.UsernameSinPasswordDTO;
import pe.edu.upc.s3155_uwork4.dtos.UsuarioDTO;
import pe.edu.upc.s3155_uwork4.entities.Rol;
import pe.edu.upc.s3155_uwork4.entities.Usuario;
import pe.edu.upc.s3155_uwork4.repositories.IRolRepository;
import pe.edu.upc.s3155_uwork4.servicesinterfaces.IUsuarioService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioService uS;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IRolRepository iRolRepository;


    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN') or hasAuthority('ESTUDIANTESUPERIOR') or hasAuthority('ESTUDIANTEINFERIOR')")
    @GetMapping
    public List<UsuarioDTO> Listar() {
    return uS.listar().stream().map( x->{
          ModelMapper m = new ModelMapper();
          return m.map(x,UsuarioDTO.class);
      }).collect(Collectors.toList());
    }

    @GetMapping("/listarsinpassword")
    public List<UsernameSinPasswordDTO> ListarUsernameSinPassword()
    {
        List<String[]> lista = uS.ListarUsernameSinPassword();
        List<UsernameSinPasswordDTO> ListDTO=new ArrayList<>();
        for(String[] columna:lista){
            UsernameSinPasswordDTO dto=new UsernameSinPasswordDTO();
            dto.setIdUsuario(Integer.parseInt(columna[0]));
            dto.setUsername(columna[1]);
            dto.setCorreo(columna[2]);
            dto.setCiclo(Integer.parseInt(columna[3]));
            dto.setPuntos(Integer.parseInt(columna[4]));
            dto.setCarrera(columna[5]);
            dto.setCentro_de_estudios(columna[6]);
            // 🔄 Convertir el ID de rol (como string) a objeto Rol
            Rol rol = iRolRepository.findById(Integer.parseInt(columna[7]))
                    .orElseThrow(() -> new RuntimeException("Rol no encontrado: " + columna[7]));
            dto.setRol(rol); // ✅ Asignación correcta
            dto.setEstado(Boolean.parseBoolean(columna[8]));
            ListDTO.add(dto);
        }
        return ListDTO;
    }

    @PostMapping
    public void Registrar(@RequestBody UsuarioDTO dto){
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto,Usuario.class);
        String encodedPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encodedPassword);
        uS.Registrar(u);

    }

    @GetMapping("/{id}")
    public UsuarioDTO Listarporid(@PathVariable("id") int id){
        ModelMapper m = new ModelMapper();
        UsuarioDTO dto = m.map(uS.listarporid(id),UsuarioDTO.class);
        return dto;
    }

    @PutMapping
    public void Modificar(@RequestBody UsuarioDTO dto){
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto,Usuario.class);
        uS.Modificar(u);
    }

    @DeleteMapping( "/{id}")
    public void Eliminar(@PathVariable("id") int id){
        uS.Eliminar(id);
    }

    @PreAuthorize("hasAuthority('DESARROLLADOR') or hasAuthority('ADMIN') or hasAuthority('ESTUDIANTESUPERIOR') or hasAuthority('ESTUDIANTEINFERIOR')")
    @GetMapping ("/BuscarMensaje")
    public List<ContenidoFechaDTO> BuscarMensaje(@RequestParam int id_usuario)
    {
        List<String[]> lista = uS.BuscarMensajeOrdenadosPorFecha(id_usuario);
        List<ContenidoFechaDTO> ListDTO=new ArrayList<>();
        for(String[] columna:lista){
            ContenidoFechaDTO dto=new ContenidoFechaDTO();
            dto.setContenido(columna[0]);
            dto.setFechaMensaje(LocalDate.parse(columna[1]));
            ListDTO.add(dto);
        }
        return ListDTO;
    }
}