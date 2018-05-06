/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AlterarPerguntaController implements Initializable {

    @FXML
    private TextField txtAlterarDisciplina;

    @FXML
    private TextField txtAlterarAssunto;

    @FXML
    private TextField txtAlterarDescricao;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnCancelar;
    
    @FXML
    private ImageView imagemEnunciado;

    @FXML
    private ImageView imagemResposta;
    
    private Pergunta pergunta;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    public void setPergunta(Pergunta pergunta){
        this.pergunta = pergunta;
    }
    
    public void carregarCampos(){
        txtAlterarDisciplina.setText(pergunta.getDisciplina());
        txtAlterarAssunto.setText(pergunta.getAssunto());
        txtAlterarDescricao.setText(pergunta.getDescricao());
        imagemEnunciado.setImage(new Image("file:///"+pergunta.getImagemEnunciado()));
        imagemResposta.setImage(new Image("file:///"+pergunta.getImagemResposta()));
    }
}
