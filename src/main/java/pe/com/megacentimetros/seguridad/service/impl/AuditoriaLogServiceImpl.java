package pe.com.megacentimetros.seguridad.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.seguridad.exception.ResourceNotFoundException;
import pe.com.megacentimetros.seguridad.entity.AuditoriaLogEntity;
import pe.com.megacentimetros.seguridad.repository.AuditoriaLogRepository;
import pe.com.megacentimetros.seguridad.service.AuditoriaLogService;

@Service
public class AuditoriaLogServiceImpl implements AuditoriaLogService {

	private AuditoriaLogRepository repositorio;

	public AuditoriaLogServiceImpl(AuditoriaLogRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<AuditoriaLogEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<AuditoriaLogEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public AuditoriaLogEntity findById(Long id) {
		AuditoriaLogEntity auditoriaLog = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("AuditoriaLog con id " + id + " no existe"));
		return auditoriaLog;
	}
	@Override
	public AuditoriaLogEntity add(AuditoriaLogEntity obj) {
		obj.setEstado(true);
		if (obj.getFecha() == null) {
			obj.setFecha(LocalDateTime.now());
		}
		return repositorio.save(obj);
	}
	@Override
	public AuditoriaLogEntity update(AuditoriaLogEntity obj, Long id) {
		AuditoriaLogEntity objaud = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("AuditoriaLog con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objaud, "codigo");
		return repositorio.save(objaud);
	}
	@Override
	public AuditoriaLogEntity delete(Long id) {
		AuditoriaLogEntity objaud = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("AuditoriaLog con id " + id + " no existe"));
		objaud.setEstado(false);
		return repositorio.save(objaud);
	}
	@Override
	public AuditoriaLogEntity enable(Long id) {
		AuditoriaLogEntity objaud = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("AuditoriaLog con id " + id + " no existe"));
		objaud.setEstado(true);
		return repositorio.save(objaud);
	}
}
