/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class TelaPrincipalController implements Initializable {

    @FXML
    private TableView<Pergunta> tablePerguntas;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> disciplina;

    @FXML
    private TableColumn<?, ?> assunto;

    @FXML
    private TableColumn<?, ?> descricao;

    @FXML
    private Button btnCriar;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnExcluir;

    @FXML
    private Label lblId;

    @FXML
    private Label lblDisciplina;

    @FXML
    private Label lblAssunto;

    @FXML
    private Label lblDescricao;

    @FXML
    private ImageView imagemEnunciado;

    @FXML
    private ImageView imagemResposta;

    @FXML
    private TextField txtDisciplina;

    @FXML
    private TextField txtAssunto;

    @FXML
    private TextField txtDescricao;

    @FXML
    private Button btnImagemEnunciado;

    @FXML
    private Button btnImagemResposta;
    
    @FXML
    private ImageView imagemRecebidaEnunciado;

    @FXML
    private ImageView imagemRecebidaResposta;
    
    //Lista de perguntas do banco
    private List<Pergunta> perguntas;
    //Lista de Observable, nessecario para as perguntas serem inseridas na tabela;
    private ObservableList perguntasFormatadas;
    //Classe do bd para realizar os métodos;
    private PerguntaDAO dao;
    //Obejeto que sera inserindo no banco;
    private Pergunta pergunta;
    //Imagem default
    private String caminho;
    private Image imageDefault;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dao = new PerguntaDAO();
        pergunta = new Pergunta();
        //Imagem default
        caminho = System.getProperty("user.dir")+"/src/imagem/default.jpg";
        imageDefault = new Image("file:///"+caminho);
        //Iniciar a tebela com as perguntas;
        iniciarTabela();
        preencherTabela();
        
        
    }

    public void preencherTabela(){
        //Insere a imagem padrao;
        imagemEnunciado.setImage(imageDefault);
        pergunta.setImagemEnunciado(caminho);
        imagemResposta.setImage(imageDefault);
        pergunta.setImagemResposta(caminho);
        ///////////////////////////////
        perguntas = dao.read();
        if(perguntas != null){
            perguntasFormatadas = FXCollections.observableList(perguntas);

            tablePerguntas.setItems(perguntasFormatadas);
        }
        
    }
    
    public void iniciarTabela(){
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        id.setPrefWidth(30);
        disciplina.setCellValueFactory(new PropertyValueFactory<>("disciplina"));
        assunto.setCellValueFactory(new PropertyValueFactory<>("assunto"));
        descricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
    }
    
    public void inserirPergunta(){
        
        String erro = "";
        
        if(txtDisciplina.getText().equals("")){
            erro = erro + "Campo 'Disciplina' obragatório!\n";
        }
        if(txtAssunto.getText().equals("")){
            erro = erro + "Campo 'Assunto' obragatório!\n";
        }
        if(txtDescricao.getText().equals("")){
            erro = erro + "Campo 'Descricão' obragatório!\n";
        }
        
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Resultado da operação");
        
        if(erro.length()==0){
            
            pergunta.setDisciplina(txtDisciplina.getText());
            pergunta.setAssunto(txtAssunto.getText());
            pergunta.setDescricao(txtDescricao.getText());
            dao.insert(pergunta);
            preencherTabela();
            
            alerta.setHeaderText("Operação concluída:");
            alerta.setContentText("Pergunta adicionada com sucesso!");
            alerta.showAndWait();
            
            limparCamposInput();
        }else{
            alerta.setHeaderText("Erro ao executar a operação:");
            alerta.setContentText(erro);
            alerta.showAndWait();
        }
        
    }
    //Limpar os campos de entrada
    public void limparCamposInput(){
        txtDisciplina.setText("");
        txtAssunto.setText("");
        txtDescricao.setText("");
        imagemEnunciado.setImage(imageDefault);
        imagemResposta.setImage(imageDefault);
    }
    //Limpar os campos de saida
    public void limparCamposOutPut(){
        lblDisciplina.setText("");
        lblAssunto.setText("");
        lblDescricao.setText("");
        imagemRecebidaEnunciado.setImage(imageDefault);
        imagemRecebidaResposta.setImage(imageDefault);
    }
    
    public void itemSelecionado(){
        Pergunta p = tablePerguntas.getSelectionModel().getSelectedItem();
        
        if(p != null){
            lblId.setText(""+p.get_Id());
            lblDisciplina.setText(p.getDisciplina());
            lblAssunto.setText(p.getAssunto());
            lblDescricao.setText(p.getDescricao());
            
            String imageEnunciado = p.getImagemEnunciado();
            String imageResposta = p.getImagemResposta();
            
            if(imageEnunciado != null){
                imagemRecebidaEnunciado.setImage(new Image("file:///"+imageEnunciado));
            }else{
                imagemRecebidaEnunciado.setImage(imageDefault);
            }
            
            if(imageResposta != null){
                imagemRecebidaResposta.setImage(new Image("file:///"+p.getImagemResposta()));
            }else{
                imagemRecebidaResposta.setImage(imageDefault);
            }
            
        }else{
            limparCamposOutPut();
        }
    }
    
    public void excluirPergunta(){
        Pergunta p = tablePerguntas.getSelectionModel().getSelectedItem();
        
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Resultado da operação");
        
        if(p != null){
            dao.remove(p);
            alerta.setHeaderText("Operação concluida:");
            alerta.setContentText("A pergunta seleciona foi removida com sucesso!");
            preencherTabela();
        }else{
            alerta.setHeaderText("Erro na operação!");
            alerta.setContentText("Algo de errado não está certo, verifique alguma coisa!");
        }
        
        alerta.showAndWait();
    }
    
    public void alterarPergunta() throws IOException{
        Pergunta p = tablePerguntas.getSelectionModel().getSelectedItem();
        
        if(p != null){
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(TelaPrincipalController.class.getResource("AlterarPergunta.fxml"));
            
            Parent root = loader.load();
            
            Stage alterarPergunta = new Stage();
            
            AlterarPerguntaController apc = loader.getController();
            apc.setPergunta(p);
            apc.carregarCampos();
            
            Scene cena = new Scene(root);
            alterarPergunta.setScene(cena);
            
            alterarPergunta.showAndWait();
            /*
            Stage alterarPergunta = new Stage();
            
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResource("AlterarPergunta.fxml").openStream());
            
            AlterarPerguntaController apc = loader.getController();
            apc.setPergunta(p);
            
            Scene cena = new Scene(root, 300, 280);
            alterarPergunta.setScene(cena);
            
            alterarPergunta.showAndWait();
            */
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Resultado da operação");
            alerta.setHeaderText("Erro ao realizar a operação:");
            alerta.setContentText("Selecione uma pergunta para altera-lá!");
            alerta.showAndWait();
        }
    }
    
    @FXML
    public void escolherImagemEnunciado(){
        
        FileChooser fc = new FileChooser();
        String caminho = System.getProperty("user.dir") + "/src/imagem/";
        fc.setInitialDirectory(new File(caminho));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagens","*.jpg","*.png","*.jpeg"));
        File arquivo = fc.showOpenDialog(new Stage());
        
        if(arquivo != null){
            imagemEnunciado.setImage(new Image("file:///"+arquivo.getAbsolutePath()));
            pergunta.setImagemEnunciado(arquivo.getAbsolutePath());
        }
        
    }
    
    @FXML
    public void escolherImagemResposta(){
        
        FileChooser fc = new FileChooser();
        String caminho = System.getProperty("user.dir") + "/src/imagem/";
        fc.setInitialDirectory(new File(caminho));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagens","*.jpg","*.png","*.jpeg"));
        File arquivo = fc.showOpenDialog(new Stage());
        
        if(arquivo != null){
            imagemResposta.setImage(new Image("file:///"+arquivo.getAbsolutePath()));
            pergunta.setImagemResposta(arquivo.getAbsolutePath());
        }
        
    }
    
}
