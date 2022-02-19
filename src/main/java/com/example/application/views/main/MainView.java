package com.example.application.views.main;

import com.example.application.GridProdutos;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.router.Route;
import com.example.application.views.listadeprodutos.ListaDeProdutoView;

@Route
public class MainView extends VerticalLayout {

    public MainView() {
        
        add(new H1("Cadastro de Produtos"));
        
        add(new RouterLink("Cadastrar Produto", ListaDeProdutoView.class));
        add(new RouterLink("Consultar Produtos", GridProdutos.class));      
      
    }

}
