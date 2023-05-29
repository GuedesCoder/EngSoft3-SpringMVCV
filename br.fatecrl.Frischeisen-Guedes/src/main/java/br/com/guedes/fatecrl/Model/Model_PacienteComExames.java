package br.com.guedes.fatecrl.Model;

import java.util.ArrayList;
import java.util.List;

public class Model_PacienteComExames {

    private Model_Paciente paciente;
    private List<Model_Exame> exames;

    public Model_PacienteComExames() {
        this.paciente = new Model_Paciente();
        this.exames = new ArrayList<>();
    }

    public Model_Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Model_Paciente paciente) {
        this.paciente = paciente;
    }

    public List<Model_Exame> getExames() {
        return exames;
    }

    public void setExames(List<Model_Exame> exames) {
        this.exames = exames;
    }
}
