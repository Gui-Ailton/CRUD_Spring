package br.edu.usj.dev.curso;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
public class CursosController {

    @Autowired
    CursosRepository cursoRepository;

    @GetMapping(value="/")
    public ModelAndView getIndex() {
        List<Cursos> lista = new ArrayList<>();
        lista= cursoRepository.findAll();

        ModelAndView modelAndView= new ModelAndView("index");
        modelAndView.addObject("lista", lista);
        return modelAndView;
    }
    

    @GetMapping(value="/detalhes/{id}")
    public ModelAndView getDetalhes(@PathVariable Long id) {

        Cursos curso = new Cursos();
        curso = cursoRepository.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("detalhes");


        modelAndView.addObject("curso", curso);
        return  modelAndView;
    }
    

    @GetMapping(value="/cadastro")
    public ModelAndView getCadastro() {
        Cursos curso = new Cursos();
        ModelAndView modelAndView = new ModelAndView("cadastro");
        modelAndView.addObject("curso", curso);
        return modelAndView;
    }
    
    
    @PostMapping(value="/adicionar")
    public String postAdicionar(Cursos curso) {
        
       cursoRepository.save(curso);

       ModelAndView modelAndView= new ModelAndView("detalhes");
       modelAndView.addObject("curso",curso);
        return "redirect:/";
    }

    @GetMapping(value="/editar/{id}")
    public ModelAndView getEditar(@PathVariable Long id) {
   Cursos curso= new Cursos();
   curso = cursoRepository.findById(id).get();

    ModelAndView modelAndView = new ModelAndView("cadastro");
    modelAndView.addObject("curso", curso);
        return  modelAndView;
    }
    

    @GetMapping(value="/deletar/{id}")
    public String getDeletar(@PathVariable Long id) {

        cursoRepository.deleteById(id);

        return "redirect:/"; 
    }
    
    
}
