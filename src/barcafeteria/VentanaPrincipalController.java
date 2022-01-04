package barcafeteria;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author i_rom
 */
public class VentanaPrincipalController implements Initializable {

    @FXML
    private Button anadirBoton;
    @FXML
    private Button modificarBoton;
    @FXML
    private Button borrarBoton;
    @FXML
    private TableColumn<?, ?> idColumna;
    @FXML
    private TableColumn<?, ?> empleadoColumna;
    @FXML
    private TableColumn<?, ?> mesaColummna;
    @FXML
    private TableColumn<?, ?> fechaColumna;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButton(ActionEvent event) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Anadir.fxml"));
        Parent root  = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    
}
