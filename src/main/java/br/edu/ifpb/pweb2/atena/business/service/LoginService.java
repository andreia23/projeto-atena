package br.edu.ifpb.pweb2.atena.business.service;

import java.util.List;

import br.edu.ifpb.pweb2.atena.business.model.UsuarioAdmin;
import br.edu.ifpb.pweb2.atena.util.PasswordUtil;

/**
 * @author andreia
 *
 */
public class LoginService {

//	@Transactional
	/**
	 * @param admin
	 * @return
	 */
	public UsuarioAdmin insert(UsuarioAdmin admin) {
		String encrip = (PasswordUtil.encryptMD5(admin.getSenha()));
		admin.setSenha(encrip);
		return usuarioDAO.insert(admin);
	}

//	@Transactional
	public List<UsuarioAdmin> findAll() {
		return this.usuarioDAO.findAll();
	}

	/**
	 * @param usuarioAdmin
	 * @return
	 */
	public UsuarioAdmin isValido(UsuarioAdmin usuarioAdmin) {

		String encrip = (PasswordUtil.encryptMD5(usuarioAdmin.getSenha()));
		UsuarioAdmin user = usuarioDAO.findByLogin(usuarioAdmin.getNome());

		if (user == null || !encrip.equals(user.getSenha())) {
			user = null;
		}

		return user;

		return null;
	}
}
