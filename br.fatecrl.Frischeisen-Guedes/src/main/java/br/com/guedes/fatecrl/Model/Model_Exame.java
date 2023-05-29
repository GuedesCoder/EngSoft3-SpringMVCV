package br.com.guedes.fatecrl.Model;

import java.time.LocalDate;

public class Model_Exame {
    private static int proximoId = 1;
    private int id;
    private String nome;
    private LocalDate dataRealizacao;

    public Model_Exame() {
        this.id = proximoId;
        proximoId++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        throw new UnsupportedOperationException("Operação não suportada: Não é possível alterar o ID do exame.");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(LocalDate dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }
}
