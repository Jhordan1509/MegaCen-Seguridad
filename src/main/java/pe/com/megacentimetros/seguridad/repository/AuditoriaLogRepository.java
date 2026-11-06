package pe.com.megacentimetros.seguridad.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.seguridad.entity.AuditoriaLogEntity;

public interface AuditoriaLogRepository extends JpaRepository<AuditoriaLogEntity, Long> {

	@Query("select d from AuditoriaLogEntity d where d.estado = true")
	List<AuditoriaLogEntity> findAllCustom();
}
