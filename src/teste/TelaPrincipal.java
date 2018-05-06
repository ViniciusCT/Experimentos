
package teste;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaPrincipal extends Application{
    
    private static final int WIDTH = 673;
    private static final int HEIGHT = 505;

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        FXMLLoader loader = new FXMLLoader();
        
        Parent telaPrincipal = loader.load(getClass().getResource("TelaPrincipal.fxml").openStream());
        Scene cena = new Scene(telaPrincipal, WIDTH, HEIGHT);
        primaryStage.setScene(cena);
        primaryStage.show();
        
    }
    
    public static void main(String args[]){
        launch(args);
        
        
        //teste();
    }
    
    public static void teste(){
        /*
        //Mover arquivo
        File arquivo  = new File(System.getProperty("user.dir")+"/db/db_quiz_academy.db");
        File dir = new File("C:/Level Up");
        
        System.out.println(arquivo.renameTo(new File(dir,arquivo.getName())));
        */
        /*
        //Listar arquivos em pasta
        File diretorio = new File(System.getProperty("user.dir")+"/db/");
        File[] arquivos = diretorio.listFiles();
        
        for(File f: arquivos){
            System.out.println(f.getName());
        }
        */
    }
}
