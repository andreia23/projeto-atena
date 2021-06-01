package br.edu.ifpb.pweb2.atena.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifpb.pweb2.atena.business.model.UsuarioAdmin;
import br.edu.ifpb.pweb2.atena.business.repository.UsuarioAdminRepository;
import br.edu.ifpb.pweb2.atena.util.PasswordUtil;

/**
 * @author andreia
 *
 */
@Service
public class LoginService {
	
	private UsuarioAdminRepository usuarioAdminRepository;

	@Autowired
	public LoginService(UsuarioAdminRepository usuarioAdminRepository) {
		this.usuarioAdminRepository = usuarioAdminRepository;
	}

	/**
	 * @param admin
	 * @return
	 */
	@Transactional
	public UsuarioAdmin insert(UsuarioAdmin admin) {
		String encrip = (PasswordUtil.encryptMD5(admin.getSenha()));
		admin.setSenha(encrip);
		return usuarioAdminRepository.save(admin);
	}

	@Transactional
	public List<UsuarioAdmin> findAll() {
		return this.usuarioAdminRepository.findAll();
	}

	/**
	 * @param usuarioAdmin
	 * @return
	 */
	public UsuarioAdmin isValido(UsuarioAdmin usuarioAdmin) {

		String encrip = (PasswordUtil.encryptMD5(usuarioAdmin.getSenha()));
		UsuarioAdmin user = usuarioAdminRepository.findByName(usuarioAdmin.getNome());

		if (user == null || !encrip.equals(user.getSenha())) {
			user = null;
		}

		return user;
	}
}
