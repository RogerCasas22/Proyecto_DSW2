package pe.com.cibertec.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import pe.com.cibertec.service.ProductoService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("")
	public String home(Model model, HttpSession session) {
		
		model.addAttribute("productos", productoService.findAll());
		

		return "usuario/home";
	}

}
