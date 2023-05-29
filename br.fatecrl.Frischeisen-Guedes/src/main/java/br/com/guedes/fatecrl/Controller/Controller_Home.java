package br.com.guedes.fatecrl.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.guedes.fatecrl.Model.ExameListConverter;
import br.com.guedes.fatecrl.Model.Model_Exame;
import br.com.guedes.fatecrl.Model.Model_Paciente;
import br.com.guedes.fatecrl.Model.Model_PacienteComExames;

@Controller
public class Controller_Home {

	private List<Model_Exame> exames = new ArrayList<>();
    private List<Model_Paciente> pacientes = new ArrayList<>();
    private List<Model_PacienteComExames> pacientesComExames = new ArrayList<>();

	@Autowired
	private ExameListConverter exameListConverter;

	@GetMapping("/")
	public String exibirHomePage(Model model) {
		model.addAttribute("pacientesComExames", pacientesComExames);
		return "homepage";
	}

	@GetMapping("/Cadastrar_Paciente")
	public String exibirFormularioCadastroPaciente(Model model) {
	    model.addAttribute("paciente", new Model_Paciente());
        model.addAttribute("exames", exames);
        return "Cadastrar_Paciente";
	}

	@PostMapping("/salvar-paciente")
	public String salvarPaciente(@ModelAttribute @Validated Model_Paciente paciente,
			@RequestParam(value = "examesSelecionados", required = false) List<String> examesSelecionados,
			RedirectAttributes redirectAttributes) {
		if (examesSelecionados != null) {
			List<Model_Exame> examesConvertidos = new ArrayList<>();
			for (String exameSelecionado : examesSelecionados) {
				Model_Exame exame = exames.stream().filter(e -> e.getNome().equals(exameSelecionado)).findFirst()
						.orElse(null);
				if (exame != null) {
					examesConvertidos.add(exame);
				}
			}
			paciente.setExames(examesConvertidos);
		}
		pacientes.add(paciente);
		redirectAttributes.addFlashAttribute("successMessage", "Paciente cadastrado com sucesso!");
		return "redirect:/";
	}

	@GetMapping("/Listar_Pacientes")
	public String listarPacientes(Model model) {
		model.addAttribute("pacientes", pacientes);
		return "Listar_Pacientes";
	}

	@GetMapping("/Cadastrar_Exame")
	public String exibirFormularioCadastroExame(Model model) {
		model.addAttribute("exame", new Model_Exame());
		return "Cadastrar_Exame";
	}

	@PostMapping("/salvar-exame")
	public String salvarExame(@ModelAttribute Model_Exame exame) {
		exames.add(exame);
		return "redirect:/";
	}

	@GetMapping("/Listar_Exames")
	public String listarExames(Model model) {
		model.addAttribute("exames", exames);
		return "Listar_Exames";
	}

	@GetMapping("/Cadastrar_PacienteComExames")
	public String exibirFormularioCadastroPacienteComExames(Model model) {
		model.addAttribute("pacienteComExames", new Model_PacienteComExames());
		return "Cadastrar_PacienteComExames";
	}

	@PostMapping("/salvar-paciente-com-exames")
	public String salvarPacienteComExames(
			@ModelAttribute("pacienteComExames") Model_PacienteComExames pacienteComExames) {
		pacientesComExames.add(pacienteComExames);
		return "redirect:/";
	}

	@GetMapping("/Listar_PacientesComExames")
	public String listarPacientesComExames(Model model) {
		model.addAttribute("pacientesComExames", pacientesComExames);
		return "Listar_PacientesComExames";
	}

}
