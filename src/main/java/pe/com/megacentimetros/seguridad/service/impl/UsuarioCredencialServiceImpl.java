package pe.com.megacentimetros.seguridad.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.seguridad.client.PersonaFeignClient;
import pe.com.megacentimetros.seguridad.client.CatalogoFeignClient;
import pe.com.megacentimetros.seguridad.exception.ResourceNotFoundException;
import pe.com.megacentimetros.seguridad.entity.UsuarioCredencialEntity;
import pe.com.megacentimetros.seguridad.repository.UsuarioCredencialRepository;
import pe.com.megacentimetros.seguridad.service.UsuarioCredencialService;

@Service
public class UsuarioCredencialServiceImpl implements UsuarioCredencialService {

	private UsuarioCredencialRepository repositorio;
	private PersonaFeignClient personaFeignClient;
	private CatalogoFeignClient catalogoFeignClient;

	public UsuarioCredencialServiceImpl(UsuarioCredencialRepository repositorio,
			PersonaFeignClient personaFeignClient,
			CatalogoFeignClient catalogoFeignClient) {
		this.repositorio = repositorio;
		this.personaFeignClient = personaFeignClient;
		this.catalogoFeignClient = catalogoFeignClient;
	}

	@Override
	public List<UsuarioCredencialEntity> findAll() {
		List<UsuarioCredencialEntity> lista = repositorio.findAll();
		for (UsuarioCredencialEntity usuarioCredencial : lista) {
			if (usuarioCredencial.getCodper() != null) {
				usuarioCredencial.setPersonal(personaFeignClient.getPersonal(usuarioCredencial.getCodper()));
			}
			usuarioCredencial.setRolsistema(catalogoFeignClient.getRolSistema(usuarioCredencial.getCodrol()));
		}
		return lista;
	}
	@Override
	public List<UsuarioCredencialEntity> findAllCustom() {
		List<UsuarioCredencialEntity> lista = repositorio.findAllCustom();
		for (UsuarioCredencialEntity usuarioCredencial : lista) {
			if (usuarioCredencial.getCodper() != null) {
				usuarioCredencial.setPersonal(personaFeignClient.getPersonal(usuarioCredencial.getCodper()));
			}
			usuarioCredencial.setRolsistema(catalogoFeignClient.getRolSistema(usuarioCredencial.getCodrol()));
		}
		return lista;
	}
	@Override
	public UsuarioCredencialEntity findById(Long id) {
		UsuarioCredencialEntity usuarioCredencial = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("UsuarioCredencial con id " + id + " no existe"));
		if (usuarioCredencial.getCodper() != null) {
			usuarioCredencial.setPersonal(personaFeignClient.getPersonal(usuarioCredencial.getCodper()));
		}
		usuarioCredencial.setRolsistema(catalogoFeignClient.getRolSistema(usuarioCredencial.getCodrol()));
		return usuarioCredencial;
	}
	@Override
	public UsuarioCredencialEntity add(UsuarioCredencialEntity obj) {
		obj.setEstado(true);
		if (obj.getFechaCreacion() == null) {
			obj.setFechaCreacion(LocalDateTime.now());
		}
		return repositorio.save(obj);
	}
	@Override
	public UsuarioCredencialEntity update(UsuarioCredencialEntity obj, Long id) {
		UsuarioCredencialEntity objusu = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("UsuarioCredencial con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objusu, "codigo", "fechaCreacion");
		return repositorio.save(objusu);
	}
	@Override
	public UsuarioCredencialEntity delete(Long id) {
		UsuarioCredencialEntity objusu = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("UsuarioCredencial con id " + id + " no existe"));
		objusu.setEstado(false);
		return repositorio.save(objusu);
	}
	@Override
	public UsuarioCredencialEntity enable(Long id) {
		UsuarioCredencialEntity objusu = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("UsuarioCredencial con id " + id + " no existe"));
		objusu.setEstado(true);
		return repositorio.save(objusu);
	}
}
