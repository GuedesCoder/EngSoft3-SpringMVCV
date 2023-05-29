package br.com.guedes.fatecrl.Model;

import java.time.LocalDate;
import java.util.List;

public class Model_Paciente {
	private String cpf;
	private String nome;
	private LocalDate dataNascimento;

    private List<Model_Exame> exames;

	
	public Model_Paciente() {
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Model_Exame> getExames() {
		return exames;
	}

	public void setExames(List<Model_Exame> exames) {
		this.exames = exames;
	}
	
	
	
}