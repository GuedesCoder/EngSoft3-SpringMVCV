package br.com.guedes.fatecrl.Model;

import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ExameListConverter implements Converter<String, Model_Exame> {

    private final List<Model_Exame> exames;

    public ExameListConverter(List<Model_Exame> exames) {
        this.exames = exames;
    }

    @Override
    public Model_Exame convert(String source) {
        for (Model_Exame exame : exames) {
            if (exame.getNome().equals(source)) {
                return exame;
            }
        }
        return null;
    }
}