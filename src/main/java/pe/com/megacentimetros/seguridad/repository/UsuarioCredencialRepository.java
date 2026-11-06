package pe.com.megacentimetros.seguridad.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.seguridad.entity.UsuarioCredencialEntity;

public interface UsuarioCredencialRepository extends JpaRepository<UsuarioCredencialEntity, Long> {

	@Query("select d from UsuarioCredencialEntity d where d.estado = true")
	List<UsuarioCredencialEntity> findAllCustom();
}
