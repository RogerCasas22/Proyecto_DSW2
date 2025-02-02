package pe.com.cibertec.controller;

import java.util.List;
import java.util.Optional;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import pe.com.cibertec.model.Orden;
import pe.com.cibertec.model.Usuario;
import pe.com.cibertec.service.IOrdenService;
import pe.com.cibertec.service.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
private final Logger logger= LoggerFactory.getLogger(UsuarioController.class);
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IOrdenService ordenService;
	

	
	
	// /usuario/registro
		@GetMapping("/registro")
		public String create() {
			return "usuario/registro";
		}
		
		// guardar ususario en la base de datos
		@PostMapping("/save")
		public String save(Usuario usuario) {
			logger.info("Usuario registro: {}", usuario);
			usuario.setTipo("USER");
			usuarioService.save(usuario);		
			return "redirect:/";
		}
		
		//login
		@GetMapping("/login")
		public String login() {
			return "usuario/login";
		}
		
		//acceder con usuario temporal
		@PostMapping("/acceder")
		public String acceder(Usuario usuario, HttpSession session) {
			logger.info("Accesos : {}", usuario);
			
			Optional<Usuario> user=usuarioService.findByEmail(usuario.getEmail());
			//logger.info("Usuario de db: {}", user.get());
			
			if (user.isPresent()) {
				session.setAttribute("idusuario", user.get().getId());
				
				if (user.get().getTipo().equals("ADMIN")) {
					return "redirect:/administrador";
				}else {
					return "redirect:/";
				}
			}else {
				logger.info("Usuario no existe");
			}
			
			return "redirect:/";
		}
		
		@GetMapping("/compras")
		public String obtenerCompras(Model model, HttpSession session) {
			model.addAttribute("sesion", session.getAttribute("idusuario"));
			
			Usuario usuario= usuarioService.findById(  Integer.parseInt(session.getAttribute("idusuario").toString()) ).get();
			List<Orden> ordenes= ordenService.findByUsuario(usuario);
			logger.info("ordenes {}", ordenes);
			
			model.addAttribute("ordenes", ordenes);
			
			return "usuario/compras";
		}
}
