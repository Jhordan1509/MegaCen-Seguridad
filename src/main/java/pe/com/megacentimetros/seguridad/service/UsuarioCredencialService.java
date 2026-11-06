package pe.com.megacentimetros.seguridad.service;

import java.util.List;
import pe.com.megacentimetros.seguridad.entity.UsuarioCredencialEntity;

public interface UsuarioCredencialService {

	List<UsuarioCredencialEntity> findAll();

	List<UsuarioCredencialEntity> findAllCustom();

	UsuarioCredencialEntity findById(Long id);

	UsuarioCredencialEntity add(UsuarioCredencialEntity obj);

	UsuarioCredencialEntity update(UsuarioCredencialEntity obj, Long id);

	UsuarioCredencialEntity delete(Long id);

	UsuarioCredencialEntity enable(Long id);
}
