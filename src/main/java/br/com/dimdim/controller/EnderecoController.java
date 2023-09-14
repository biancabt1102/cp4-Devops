package br.com.dimdim.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.dimdim.model.Endereco;
import br.com.dimdim.model.User;
import br.com.dimdim.repository.EnderecoRepository;
import br.com.dimdim.repository.UserRepository;

@Controller
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	EnderecoRepository repository;
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping()
	public ModelAndView index() {
		List<Endereco> history = repository.findAll();
		ModelAndView modelAndView = new ModelAndView("endereco");
		modelAndView.addObject("historico", history);
		return modelAndView;
	}
	
	@GetMapping("{id}")
	public ModelAndView get(@PathVariable Long id) {
		List<Endereco> history = repository.findByUserId(id);
		Optional<User> user = userRepo.findById(id);
		ModelAndView modelAndView = new ModelAndView("user-endereco");
		modelAndView.addObject("cliente", user.get());
		modelAndView.addObject("historico", history);
		return modelAndView;
	}
	
	@GetMapping("/new/{id}")
	public ModelAndView create(@PathVariable Long id, Endereco endereco) {
		Optional<User> user = userRepo.findById(id);
		System.out.println(endereco);
		ModelAndView modelAndView = new ModelAndView("endereco-form");
		modelAndView.addObject("userId", user.get().getId());
		modelAndView.addObject("nomeUsuario", user.get().getName());
		return modelAndView;
	}
	
	@PostMapping("/new/{id}")
	public String save(@PathVariable Long id, @Valid Endereco endereco, BindingResult result, Model model) {
		Optional<User> user = userRepo.findById(id);
		endereco.setUser(user.get());
		
		if (result.hasErrors()) {
			model.addAttribute("userId", endereco.getUser().getId());
			model.addAttribute("nomeUsuario", endereco.getUser().getName());
			return "endereco-form";
		}
		endereco.setId(null);
		System.out.println(endereco);
		repository.save(endereco);
		List<Endereco> history = repository.findByUserId(endereco.getUser().getId());
		model.addAttribute("cliente", endereco.getUser());
		model.addAttribute("historico", history);
		return "redirect:/endereco/"+id;
	}
}
