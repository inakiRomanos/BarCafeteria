package barcafeteria;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
    public TableView<Pedidos> tablaPrincipal;

    public static ObservableList<Pedidos> datos;
    @FXML
    private TableColumn<Pedidos, String> idColumna;
    @FXML
    private TableColumn<Pedidos, String> empleadoColumna;
    @FXML
    private TableColumn<Pedidos, String> mesaColumna;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        idColumna.setCellValueFactory(new PropertyValueFactory<>("id"));
        empleadoColumna.setCellValueFactory(new PropertyValueFactory<>("empleado"));
        mesaColumna.setCellValueFactory(new PropertyValueFactory<>("mesa"));

        datos = FXCollections.observableArrayList(
                new Pedidos(contadorPedidos.numeroPedido(), "Luis", "1"),
                new Pedidos(contadorPedidos.numeroPedido(), "Tomas", "8"),
                new Pedidos(contadorPedidos.numeroPedido(), "Tomas", "5"),
                new Pedidos(contadorPedidos.numeroPedido(), "Irati", "4"),
                new Pedidos(contadorPedidos.numeroPedido(), "Ana", "10"),
                new Pedidos(contadorPedidos.numeroPedido(), "Ana", "9"),
                new Pedidos(contadorPedidos.numeroPedido(), "Mikel", "6"),
                new Pedidos(contadorPedidos.numeroPedido(), "Tomas", "5"),
                new Pedidos(contadorPedidos.numeroPedido(), "Luis", "2"),
                new Pedidos(contadorPedidos.numeroPedido(), "Tomas", "3"),
                new Pedidos(contadorPedidos.numeroPedido(), "Tomas", "8"),
                new Pedidos(contadorPedidos.numeroPedido(), "Irati", "10")
        );
        tablaPrincipal.setItems(datos);
        tablaPrincipal.setRowFactory(tv -> {
            TableRow<Pedidos> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HojaPedido.fxml"));
                    Parent root = null;
                    try {
                        root = (Parent) fxmlLoader.load();
                    } catch (IOException ex) {
                        Logger.getLogger(VentanaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.show();
                }
            });
            return row;
        });
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

    @FXML
    private void borrar(ActionEvent event) {
        Pedidos p = (Pedidos) tablaPrincipal.getSelectionModel().getSelectedItem();
        datos.remove(p);
    }

}
