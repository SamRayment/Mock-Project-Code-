import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.*;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import java.util.ArrayList;
import javafx.scene.shape.Line;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.WindowEvent;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.event.Event;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Main
{
    public static ComboBox titleComboBox;
    public static TextField fornameTextField;
    public static TextField surnameTextField;
    public static TextField emailTextField;
    public static TextField mobilePhoneTextField;
    public static TextField address1TextField;
    public static TextField address2TextField;
    public static TextField townOrCityTextField;
    public static TextField countyTextField;
    public static TextField postcodeTextField;
    public static String[] contactDetails;      
    public static ObservableList<Contacts> data = FXCollections.observableArrayList();
    public static TableView<Contacts> table;
    
    public static void main(String args[]) 
    {
        launchFX();              
    }

    private static void launchFX() 
    {
        // Initialises JavaFX
        new JFXPanel();
        // Runs initialisation on the JavaFX thread
        Platform.runLater(() -> initialiseGUI());
    }

    private static void initialiseGUI() 
    {
        table = new TableView<Contacts>();
        table.setEditable(true);
        table.setLayoutX(220);
        table.setLayoutY(100);

        TableColumn <Contacts, String>colTitle = new TableColumn("Title");
        colTitle.setMinWidth(60);
        colTitle.setCellValueFactory(   //Creates the table Column colTitle
            new PropertyValueFactory<Contacts, String>("Title"));

        TableColumn <Contacts, String>colForename = new TableColumn("Forename");
        colForename.setMinWidth(60);    //Creates the table Column colForename
        colForename.setCellValueFactory(
            new PropertyValueFactory<Contacts, String>("Forename"));

        TableColumn <Contacts, String>colSurname = new TableColumn("Surname");
        colSurname.setMinWidth(60);
        colSurname.setCellValueFactory( //Creates the table Column colSurname
            new PropertyValueFactory<Contacts, String>("Surname"));

        TableColumn <Contacts, String>colEmail = new TableColumn("Email");
        colEmail.setMinWidth(60);   //Creates the table Column colTitle
        colEmail.setCellValueFactory(
            new PropertyValueFactory<Contacts, String>("Email"));

        TableColumn <Contacts, String>colMobilePhone = new TableColumn("Mobile Phone");
        colMobilePhone.setMinWidth(60); //Creates the table Column colTitle
        colMobilePhone.setCellValueFactory(
            new PropertyValueFactory<Contacts, String>("mobilePhone"));

        TableColumn <Contacts, String>colAddress1 = new TableColumn("Address 1");
        colAddress1.setMinWidth(60);
        colAddress1.setCellValueFactory(    //Creates the table Column colTitle
            new PropertyValueFactory<Contacts, String>("address1"));

        TableColumn <Contacts, String>colAddress2 = new TableColumn("Address 2");
        colAddress2.setMinWidth(60);
        colAddress2.setCellValueFactory(
            new PropertyValueFactory<Contacts, String>("address2"));

        TableColumn <Contacts, String>colTownOrCity = new TableColumn("Town/City");
        colTownOrCity.setMinWidth(60);
        colTownOrCity.setCellValueFactory(
            new PropertyValueFactory<Contacts, String>("townOrCity"));

        TableColumn <Contacts, String>colCounty = new TableColumn("County");
        colCounty.setMinWidth(60);
        colCounty.setCellValueFactory(
            new PropertyValueFactory<Contacts, String>("county"));

        TableColumn <Contacts, String>colPostcode = new TableColumn("Postcode");
        colPostcode.setMinWidth(60);
        colPostcode.setCellValueFactory(
            new PropertyValueFactory<Contacts, String>("postcode"));

        table.getColumns().addAll(colTitle, colForename, colSurname, colEmail, colMobilePhone, colAddress1, colAddress2, colTownOrCity, colCounty, colPostcode);
        Label contactsLabel = new Label();
        contactsLabel.setText("Current Contacts: ");
        contactsLabel.setLayoutX(220);
        contactsLabel.setLayoutY(80);

        Line line = new Line(200, 0, 200, 1248);

        Button newContactBtn = new Button("New Contact");
        newContactBtn.setLayoutX(10);
        newContactBtn.setLayoutY(80);
        newContactBtn.setPrefWidth(170);

        Button newGroupBtn = new Button("New Group");
        newGroupBtn.setLayoutX(10);
        newGroupBtn.setLayoutY(120);
        newGroupBtn.setPrefWidth(170);

        Button currentContactBtn = new Button("Current Contacts");
        currentContactBtn.setLayoutX(10);
        currentContactBtn.setLayoutY(160);
        currentContactBtn.setPrefWidth(170);

        Button currentGroupBtn = new Button("Current Groups");
        currentGroupBtn.setLayoutX(10);
        currentGroupBtn.setLayoutY(200);
        currentGroupBtn.setPrefWidth(170);

        getDataFromTextFile();

        Stage stage = new Stage();
        stage.setTitle("Inventory Application");
        stage.setResizable(true);
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));                        
        stage.setWidth(1240);
        stage.setHeight(738);
        stage.setOnCloseRequest((WindowEvent we) -> terminate());
        stage.show(); 

        rootPane.getChildren().addAll(table, contactsLabel);
        rootPane.getChildren().addAll(newContactBtn, newGroupBtn, currentContactBtn, currentGroupBtn, line );
    }

    private static void getDataFromTextFile() {
        try{
            FileReader fr = new FileReader("Address.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                contactDetails = line.split(", ");

                data.add(new Contacts(contactDetails[0],contactDetails[1], contactDetails[2], contactDetails[3], contactDetails[4], contactDetails[5], contactDetails[6], contactDetails[7], contactDetails[8], contactDetails[9]));
                
            }
            System.out.println(data);
            br.close(); 
            viewContactsInTable();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private static void viewContactsInTable(){
        for (Contacts c : data){
            table.getItems().add(c);
        }
        
    }

    private static void terminate(){
        System.exit(0);
    }

}
