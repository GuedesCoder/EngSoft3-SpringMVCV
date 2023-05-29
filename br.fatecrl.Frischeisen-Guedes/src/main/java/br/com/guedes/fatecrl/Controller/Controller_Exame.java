package br.com.guedes.fatecrl.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.guedes.fatecrl.Model.Model_Exame;

@Controller
@RequestMapping("/exames")
public class Controller_Exame {

    private List<Model_Exame> exames = new ArrayList<>();

    @PostMapping
    public String cadastrarExame(@ModelAttribute Model_Exame exame) {
        exames.add(exame);
        return "redirect:/";
    }
}
