package pe.com.megacentimetros.seguridad.service;

import java.util.List;
import pe.com.megacentimetros.seguridad.entity.AuditoriaLogEntity;

public interface AuditoriaLogService {

	List<AuditoriaLogEntity> findAll();

	List<AuditoriaLogEntity> findAllCustom();

	AuditoriaLogEntity findById(Long id);

	AuditoriaLogEntity add(AuditoriaLogEntity obj);

	AuditoriaLogEntity update(AuditoriaLogEntity obj, Long id);

	AuditoriaLogEntity delete(Long id);

	AuditoriaLogEntity enable(Long id);
}
