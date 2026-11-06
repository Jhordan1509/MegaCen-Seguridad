package pe.com.megacentimetros.seguridad.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "megacentimetros-microservicio-catalogo", url = "http://localhost:9091/pmega/api/")
public interface CatalogoFeignClient {
	@GetMapping("/rolsistema/{id}")
	Object getRolSistema(@PathVariable("id") Long id);
}
