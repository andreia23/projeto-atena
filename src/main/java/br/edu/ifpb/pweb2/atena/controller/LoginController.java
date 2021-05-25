package br.edu.ifpb.pweb2.atena.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifpb.pweb2.atena.business.model.UsuarioAdmin;
import br.edu.ifpb.pweb2.atena.business.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getForm(ModelAndView modelAndView) {
		modelAndView.setViewName("login/login");
		modelAndView.addObject("usuario", new UsuarioAdmin());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView valide(UsuarioAdmin usuarioAdmin, HttpSession session, ModelAndView modelAndView,
			RedirectAttributes redirectAttts) {

		if (loginService.isValido(usuarioAdmin) == null) {
			if (loginService.findAll().isEmpty()) {
				loginService.insert(usuarioAdmin);
				modelAndView.setViewName("redirect:/home");
			} else {
				redirectAttts.addFlashAttribute("mensagem", "Login e/ou senha inválidos!");
				modelAndView.setViewName("redirect:/login");
			}
		}else {
			session.setAttribute("usuario", usuarioAdmin);
			modelAndView.setViewName("redirect:/home");
		}

//		if ((usuarioAdmin = loginService.isValido(usuarioAdmin)) != null) {
//			session.setAttribute("usuario", usuarioAdmin);
//			modelAndView.setViewName("redirect:/home");
//		} else {
//			redirectAttts.addFlashAttribute("mensagem", "Login e/ou senha inválidos!");
//			modelAndView.setViewName("redirect:/login");
//		}
		
		return modelAndView;
	}

	@RequestMapping("/out")
	public ModelAndView logout(ModelAndView mav, HttpSession session) {
		session.invalidate();
		mav.setViewName("redirect:/login");
		return mav;
	}

}