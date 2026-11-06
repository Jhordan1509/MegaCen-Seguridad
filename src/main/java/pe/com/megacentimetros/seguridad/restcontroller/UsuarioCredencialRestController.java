package pe.com.megacentimetros.seguridad.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.megacentimetros.seguridad.entity.UsuarioCredencialEntity;
import pe.com.megacentimetros.seguridad.service.UsuarioCredencialService;

@RestController
@RequestMapping("/api/usuariocredencial")
public class UsuarioCredencialRestController {

	@Autowired
	private UsuarioCredencialService servicio;

	@GetMapping
	public List<UsuarioCredencialEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<UsuarioCredencialEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public UsuarioCredencialEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public UsuarioCredencialEntity add(@RequestBody UsuarioCredencialEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public UsuarioCredencialEntity update(@RequestBody UsuarioCredencialEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public UsuarioCredencialEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public UsuarioCredencialEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
