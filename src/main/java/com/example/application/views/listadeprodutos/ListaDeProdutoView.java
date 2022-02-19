package com.example.application.views.listadeprodutos;

// @author Henrique Andrew da Silva
import com.example.application.GridProdutos;
import com.example.application.Produto;
import com.example.application.ValidaCampos;
import com.example.application.views.main.MainView;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import org.springframework.beans.factory.annotation.Autowired;

@Route("cadastrarproduto/")
public class ListaDeProdutoView extends VerticalLayout {

    Produto produto;

    public ListaDeProdutoView(@Autowired ValidaCampos service) {
        FormLayout form = new FormLayout();

        TextArea descProduto = new TextArea("Descrição do Produto");
        descProduto.setPlaceholder("Descrição completa do produto");
        descProduto.getStyle().set("maxHeight", "300px").set("minHeight", "200");

        Select<String> descClassif = new Select<>();
        descClassif.setItems("Bebida", "Salgadinho", "Biscoito", "Chocolate");
        descClassif.setLabel("Classificação");
        descClassif.setPlaceholder("Selecione a classificação do produto");

        TextField unidMedida = new TextField();
        unidMedida.setLabel("Unidade de medida");
        unidMedida.setPlaceholder("Unidade de medida do produto");

        NumberField valor = new NumberField("Valor");
        valor.setPlaceholder("Valor do produto");
        valor.setPrefixComponent(VaadinIcon.DOLLAR.create());
        valor.setSuffixComponent(new Span(",00"));

        Checkbox cadAtivo = new Checkbox();
        cadAtivo.setLabel("Ativo");
        cadAtivo.setValue(true);

        Button gravar = new Button("Gravar");
        gravar.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> e) {
                Notification.show(service.validaDescricao(descProduto.getValue()));
                Notification.show(service.validaUnidade(unidMedida.getValue()));
            }
        });            
        
        add(new H1("Cadastrar Produto"));
        add(new RouterLink("Menu Principal", MainView.class));
        add(new RouterLink("Consultar Produtos", GridProdutos.class));
        form.add(descProduto, descClassif, unidMedida, valor, cadAtivo, gravar);

        add(new H1(form), form);
    }

}
