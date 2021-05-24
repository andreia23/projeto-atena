package br.edu.ifpb.pweb2.atena.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifpb.pweb2.atena.business.model.UsuarioAdmin;
import br.edu.ifpb.pweb2.atena.business.repository.UsuarioAdminRepository;
import br.edu.ifpb.pweb2.atena.util.PasswordUtil;

public class LoginController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UsuarioAdminRepository usuarioAdminRepository;
	
	private PasswordUtil passwordUtil;

//	@Transactional
//	public UsuarioAdmin insert(UsuarioAdmin admin) {
//		String encrip = (passwordUtil.encryptMD5(admin.getSenha()));
//		admin.setSenha(encrip);
//		return usuarioDAO.insert(admin);
//	}

	

//	public List<UsuarioAdmin> findAll()
//	{
//		return this.usuarioDAO.findAll();
//	}

//	public UsuarioAdmin isValido(String usuario, String senha) {
//
//		String encrip = (passwordUtil.encryptMD5(senha));
//		UsuarioAdmin user = usuarioDAO.findByLogin(usuario);
//				
//		if (user == null || !encrip.equals(user.getSenha())) {
//			user = null;
//		}
//
//		return user;
//	}
}