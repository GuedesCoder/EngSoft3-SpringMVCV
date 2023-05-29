package br.com.guedes.fatecrl.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.guedes.fatecrl.Model.Model_Paciente;

@Controller
@RequestMapping("/pacientes")
public class Controller_Paciente {

    private List<Model_Paciente> pacientes = new ArrayList<>();

    @PostMapping
    public String cadastrarPaciente(@ModelAttribute Model_Paciente paciente) {
        pacientes.add(paciente);
        return "redirect:/";
    }
}
