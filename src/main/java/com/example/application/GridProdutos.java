package com.example.application;

// @author Henrique Andrew da Silva
import com.example.application.views.listadeprodutos.ListaDeProdutoView;
import com.example.application.views.main.MainView;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("listaprodutos/")
public class GridProdutos extends VerticalLayout {

    public GridProdutos() {
        H2 selecionado = new H2();
        selecionado.setVisible(false);

        Grid<Produto> grid = new Grid<>(Produto.class);
        grid.setItems(Produto.listaProduto());
        
        grid.setColumns("id", "descricao", "classif", "unid_medida", "valor_unit");
        
        grid.removeColumnByKey("id");        
        grid.getColumnByKey("unid_medida")
                .setHeader("Unidade")
                .setTextAlign(ColumnTextAlign.CENTER)
                .setWidth("100px");
        
        grid.setSelectionMode(Grid.SelectionMode.SINGLE);        
        grid.addSelectionListener(event -> {
            Produto produto = event.getFirstSelectedItem().get();
            if (produto == null) {
                selecionado.setVisible(false);
            } else {
                selecionado.setText(produto.toString());
                selecionado.setVisible(true);
            }
        });
        
        add(new H1("Lista de Produtos")) ;
        add(new RouterLink("Menu Principal", MainView.class));
        add(new RouterLink("Cadastrar Produto", ListaDeProdutoView.class));
        add(grid, selecionado);
 
    }
}
