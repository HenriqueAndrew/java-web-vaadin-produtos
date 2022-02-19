package com.example.application;

// @author Henrique Andrew da Silva

import java.io.Serializable;
import org.springframework.stereotype.Service;

@Service
public class ValidaCampos implements Serializable {            
     
    
    public String validaDescricao(String descricao) {
        if (descricao == null || descricao.isEmpty()) {
            return "Descrição do produto não informada";
        } else {
            return descricao;
        }
    }
    
    public String validaUnidade(String unidade) {
        if (unidade == null || unidade.isEmpty()) {
            return "Unidade de medida não informada";
        } else {
            return unidade;
        }
    }
    
}
