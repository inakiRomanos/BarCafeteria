package barcafeteria;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SortEvent;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private ComboBox<String> productoIn;
    @FXML
    private Label cantText;
    @FXML
    private Spinner<Integer> cantIn;
    @FXML
    private Button productoBoton;
    @FXML
    private Button aceptarAnadirBoton;
    @FXML
    private Button cancelarAnadirBoton;

    static public String[] empleados = {"Luis", "Mikel", "Tomas", "Ana", "Irati"};
    static public Integer[] mesas = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    static public String[] listaProductos = {"Bocadillo", "Racion", "Cerveza", "Vino", "Refresco", "Cafe", "Infusion"};
    static public String nombreEmpleado;
    static public int numeroMesa;
    @FXML
    private TableColumn<Productos, String> productoNuevo;
    @FXML
    private TableColumn<Productos, String> cantidadNueva;
    @FXML
    private TableView<Productos> tablaAnadir;

    public static ObservableList<Productos> datosAnadir;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        empleadoIn.getItems().addAll(empleados);
        mesaIn.getItems().addAll(mesas);
        productoIn.getItems().addAll(listaProductos);

        SpinnerValueFactory<Integer> nuevoValor = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 20);
        cantIn.setValueFactory(nuevoValor);

        productoNuevo.setCellValueFactory(new PropertyValueFactory<>("producto"));
        cantidadNueva.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        
        datosAnadir = FXCollections.observableArrayList();
        tablaAnadir.setItems(datosAnadir);

    }

    @FXML
    private void anadir(ActionEvent event) {
        
        datosAnadir.add(new Productos(productoIn.getValue(), Integer.toString(cantIn.getValue()), nombreEmpleado));
        tablaAnadir.setItems(datosAnadir);

    }

}
