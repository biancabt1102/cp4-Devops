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
import org.springframework.web.servlet.ModelAndView;

import br.com.dimdim.model.User;
import br.com.dimdim.repository.EnderecoRepository;
import br.com.dimdim.repository.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping("/")
    public ModelAndView home() {
        Long qtdUsuarios = repository.count();
        Long qtdEnderecos = enderecoRepository.count();
        ModelAndView modelAndView = new ModelAndView("base");
        modelAndView.addObject("qtdUsuarios", qtdUsuarios);
        modelAndView.addObject("qtdEnderecos", qtdEnderecos);
        return modelAndView;
    }

    @GetMapping("/user")
    public ModelAndView index() {
        List<User> usuarios = repository.findAll();
        ModelAndView modelAndView = new ModelAndView("user");
        modelAndView.addObject("usuarios", usuarios);
        return modelAndView;
    }

    @GetMapping("/user/new")
    public String create(User user) {
        return "user-form";
    }

    @PostMapping("/user")
    public String save(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user-form";
        }
        repository.save(user);
        return "redirect:/user"; // Redireciona para a lista de usuários
    }

    // ... Outros métodos do controlador

@GetMapping("/user/edit/{id}")
public ModelAndView edit(@PathVariable Long id) {
    Optional<User> user = repository.findById(id);
    ModelAndView modelAndView = new ModelAndView("user-edit");
    modelAndView.addObject("user", user.orElse(new User()));
    return modelAndView;
}

@PostMapping("/user/update/{id}")
public ModelAndView update(@PathVariable Long id, @Valid User user, BindingResult result, Model model) {
    if (result.hasErrors()) {
        return new ModelAndView("user-edit", "user", user);
    }

    User userToUpdate = repository.findById(id).orElse(null);
    if (userToUpdate == null) {
        return new ModelAndView("redirect:/user");
    }

    userToUpdate.setName(user.getName());
    userToUpdate.setCpf(user.getCpf());
    userToUpdate.setEmail(user.getEmail());
    userToUpdate.setSenha(user.getSenha());
    userToUpdate.setData(user.getData());
    userToUpdate.setTelefone(user.getTelefone());

    repository.save(userToUpdate);

    return new ModelAndView("redirect:/user");
}

@GetMapping("/user/delete/{id}")
public ModelAndView delete(@PathVariable Long id) {
    repository.deleteById(id);
    return new ModelAndView("redirect:/user");
}


}
