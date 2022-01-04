package barcafeteria;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;

/**
 * FXML Controller class
 *
 * @author i_rom
 */
public class AnadirController implements Initializable {

    @FXML
    private Label empleadoText;
    @FXML
    private Label mesaText;
    @FXML
    private Label productoText;
    @FXML
    private ComboBox<String> empleadoIn;
    @FXML
    private ComboBox<Integer> mesaIn;
    @FXML
    private ComboBox<?> productoIn;
    @FXML
    private Label cantText;
    @FXML
    private Spinner<?> cantIn;
    @FXML
    private Button productoBoton;
    @FXML
    private Button aceptarAnadirBoton;
    @FXML
    private Button cancelarAnadirBoton;
    
    private String[] empleados = {"Luis", "Mikel", "Tomas", "Ana", "Irati"};
    private Integer[] mesas = {1,2,3,4,5,6,7,8,9,10};
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        empleadoIn.getItems().addAll(empleados);
        mesaIn.getItems().addAll(mesas);
    }    
    
}
