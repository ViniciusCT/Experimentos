
package teste;

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
    }
    
    
}
