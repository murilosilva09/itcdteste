package itcd.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import itcd.dto.UsuarioDTO;
import itcd.entidades.Usuario;
import itcd.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/salvar")
	public ResponseEntity<Object> cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		var usuario = new Usuario();
		BeanUtils.copyProperties(usuarioDTO, usuario);
		usuario.setDataInclusao(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Usuario>> getAllUsuarios() {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll());
	}

	@PutMapping("/{id}")
	
	public ResponseEntity<Object> getOneUsuario(@PathVariable(value = "id") Long id,
												@RequestBody UsuarioDTO usuarioDTO){
		Optional<Usuario> usuarioOptional = usuarioService.findById(id);
		if(!usuarioOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario not found");
		}
		var usuario = usuarioOptional.get();
		usuario.setNumeroUsuario(usuarioDTO.getNumeroUsuario());
		usuario.setDescricaoExercicioCargo(usuarioDTO.getDescricaoExercicioCargo());
		usuario.setIdLocalidade(usuarioDTO.getIdLocalidade());
		usuario.setMasp(usuarioDTO.getMasp());
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(usuario));
	}
}
