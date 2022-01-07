package barcafeteria;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableColumn<Pedidos, Integer> numeroPedidoColumna;
    @FXML
    private TableColumn<Pedidos, String> empleadoColumna;
    @FXML
    private TableColumn<Pedidos, String> mesaColumna;
    @FXML
    public TableView<Pedidos> tablaPrincipal;
    
    public static ObservableList<Pedidos> datos;
    
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        numeroPedidoColumna.setCellValueFactory(new PropertyValueFactory<>("id"));
        empleadoColumna.setCellValueFactory(new PropertyValueFactory<>("empleado"));
        mesaColumna.setCellValueFactory(new PropertyValueFactory<>("mesa"));
        
        datos = FXCollections.observableArrayList(
        new Pedidos(contadorPedidos.numeroPedido(), "Manuel", "1"),
        new Pedidos(contadorPedidos.numeroPedido(), "Susana", "8"),
        new Pedidos(contadorPedidos.numeroPedido(), "Susana", "5"),     
        new Pedidos(contadorPedidos.numeroPedido(), "Susana", "4"),     
        new Pedidos(contadorPedidos.numeroPedido(), "Susana", "10"),     
        new Pedidos(contadorPedidos.numeroPedido(), "Susana", "9"),     
        new Pedidos(contadorPedidos.numeroPedido(), "Susana", "6"),     
        new Pedidos(contadorPedidos.numeroPedido(), "Susana", "5"),     
        new Pedidos(contadorPedidos.numeroPedido(), "Susana", "2"),     
        new Pedidos(contadorPedidos.numeroPedido(), "Susana", "3"),     
        new Pedidos(contadorPedidos.numeroPedido(), "Susana", "8"),
        new Pedidos(contadorPedidos.numeroPedido(), "Susana", "10")            
        );
        
        tablaPrincipal.setItems(datos);

        
    }

    @FXML
    private void modificarBoton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Modificar.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void nuevo(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Anadir.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    

}
