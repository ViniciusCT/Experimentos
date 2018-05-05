
package ComboBox;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ExemploListaComComboBox extends Application{
    ObservableList<String> itensLista;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FlowPane layout = new FlowPane();
        //Criar uma lista de strings;
        ListView<String> listView = new ListView<>();
        //Criar os itens string;
        ObservableList<String> itensLista = FXCollections.observableArrayList("1",
                "2","3","4","5","1.1","1.2","1.3","1.4","1.5","2.1","2.2","2.3"
        ,"3.1","4.1","4.2","4.3","4.4","5.1","5.2","5.3","5.4","5.5");
        //Adicionar os intens a lista;
        listView.setItems(itensLista);
        
        //Criando o combobox;
        ComboBox box = new ComboBox();
        //Criando os itens do combobox;
        ObservableList<String> itensBox = FXCollections.observableArrayList("1","2","3","4","5");
        //inserindo os itens no combobox;
        box.setItems(itensBox);
        //Adicionando um evento para quando um item for selecionado no combobox;
        
        box.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(newValue);
            }
            
        });
        
        layout.getChildren().addAll(box,listView);
        
        Scene cena = new Scene(layout, 500, 600);
        
        primaryStage.setScene(cena);
        
        primaryStage.show();
    }
    
    public static void main(String[] args){
        launch(args);
    }
    
    
}
