package com.example.application;

// @author Henrique Andrew da Silva

import java.util.HashSet;
import java.util.Set;


public class Produto {
    
    private int id;
    private String descricao;   
    private String classif;
    private String unid_medida;
    private double valor_unit;
    
    public Produto (){
        
    }
    
    public Produto (int id, String descricao, String classif, String unid_medida, double valor_unit){
        this.id = id;
        this.descricao = descricao;        
        this.classif = classif;
        this.unid_medida = unid_medida;
        this.valor_unit = valor_unit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getClassif() {
        return classif;
    }

    public void setClassif(String classif) {
        this.classif = classif;
    }

    public String getUnid_medida() {
        return unid_medida;
    }

    public void setUnid_medida(String unid_medida) {
        this.unid_medida = unid_medida;
    }

    public double getValor_unit() {
        return valor_unit;
    }

    public void setValor_unit(float valor_unit) {
        this.valor_unit = valor_unit;
    }
    
    public static Set<Produto> listaProduto(){
        HashSet<Produto> produtos = new HashSet<>();
        produtos.add(new Produto(1, "Refrigerante Coca-Cola 200 ml", "Bebida", "Garrafa", 1.39));
        produtos.add(new Produto(2, "Refrigerante Guaraná Antarctica 237 ml", "Bebida", "Garrafa", 1.09));
        produtos.add(new Produto(3, "Salgadinho Doritos Queijo Nacho 84g", "Salgadinho", "Pacote", 7.49));
        produtos.add(new Produto(4, "Salgadinho Ruffles Batata Frita Original 96g", "Salgadinho", "Pacote", 6.99));
        produtos.add(new Produto(5, "Biscoito Bauducco Wafer Maxi Chocolate 117g", "Biscoito", "Pacote", 2.49));
        produtos.add(new Produto(6, "Chocolate Alpino Nestlé 90g", "Chocolate", "Barra", 5.19));
        return produtos;
    }
    
    @Override
    public String toString(){
        return descricao;
    }

}
