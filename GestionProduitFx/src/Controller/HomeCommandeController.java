package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import metier.ComCrud;
import metier.Commande;

public class HomeCommandeController  implements Initializable {
	
    @FXML
    private TableView<Commande> tablecom;



    @FXML
    private Button btncreate;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnnew;

    @FXML
    private Button btnupdate;

    @FXML
    private TableColumn<Commande, Integer> idcol;

    @FXML
    private TextField idcom;

    @FXML
    private TableColumn<Commande, String> mailcol;

    @FXML
    private TextField mailcom;

    @FXML
    private TableColumn<Commande, String> nomcol;

    @FXML
    private TextField nomcom;

    @FXML
    private TableColumn<Commande, String> prenomcol;

    @FXML
    private TextField prenomcom;
    @FXML
    private TableColumn<Commande, String> adressecol;

    

    @FXML
    private TextField adressecom;

    @FXML
    private TableColumn<Commande, Integer> telcol;

    @FXML
    private TextField telcom;

    @FXML
    void Affichecom(MouseEvent event) {
    	Commande d= tablecom.getSelectionModel().getSelectedItem();
    	idcom.setText(""+d.getId());
    	nomcom.setText(""+d.getNom());
    	prenomcom.setText(""+d.getPrenom());
    	telcom.setText(""+d.getTel());
    	mailcom.setText(""+d.getMail());
    	adressecom.setText(""+d.getAdresse());
    }

    @FXML
    void createcom(ActionEvent event) {
    	//int id = Integer.parseInt(idproduittxt.getText());
    	String nom = nomcom.getText();
    	String prenom = prenomcom.getText();
    	int tel = Integer.parseInt(telcom.getText());
    	String mail = mailcom.getText();
    	String adresse = adressecom.getText();
    	Commande d =new Commande( nom , prenom,tel,mail  , adresse);
    	ComCrud.ajouter(d);
    	System.out.println("Commande ok");
    	ObservableList<Commande> commandes= ComCrud.getALL();
		System.out.println(commandes);
		tablecom.setItems(commandes);
    }

    @FXML
    void deletecom(ActionEvent event) {
    	int id = Integer.parseInt(idcom.getText());
    	String nom = nomcom.getText();
    	String prenom = prenomcom.getText();
    	int tel = Integer.parseInt(telcom.getText());
    	String mail = mailcom.getText();
    	String adresse = adressecom.getText();
    	Commande d =new Commande( id,nom , prenom,tel,mail  , adresse);
    	ComCrud.delete(d);
    	idcom.setText("");
    	
    	nomcom.setText("");
    	prenomcom.setText("");
    	telcom.setText("");
    	mailcom.setText("");
    	adressecom.setText("");
    	
    	
    	
    	ObservableList<Commande> commandes = ComCrud.getALL();
		System.out.println(commandes);
		tablecom.setItems(commandes);
    }

    @FXML
    void newcom(ActionEvent event) {
idcom.setText("");
    	
    	nomcom.setText("");
    	prenomcom.setText("");
    	telcom.setText("");
    	mailcom.setText("");
    	adressecom.setText("");
    }

    @FXML
    void updatecom(ActionEvent event) {
    	int id = Integer.parseInt(idcom.getText());
    	String nom = nomcom.getText();
    	String prenom = prenomcom.getText();
    	int tel = Integer.parseInt(telcom.getText());
    	String mail = mailcom.getText();
    	String adresse = adressecom.getText();
    	Commande d =new Commande( id,nom , prenom,tel,mail  , adresse);
    	ComCrud.update(d);
    	
    	ObservableList<Commande> commandes = ComCrud.getALL();
		System.out.println(commandes);
		tablecom.setItems(commandes);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		idcol.setCellValueFactory(new PropertyValueFactory<Commande,Integer>("id"));
		nomcol.setCellValueFactory(new PropertyValueFactory<>("nom"));
		prenomcol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		telcol.setCellValueFactory(new PropertyValueFactory<>("tel"));
		mailcol.setCellValueFactory(new PropertyValueFactory<>("mail"));
		adressecol.setCellValueFactory(new PropertyValueFactory<>("adresse"));
		
		ObservableList<Commande> commandes = ComCrud.getALL();
		System.out.println(commandes);
		tablecom.setItems(commandes);
	}

}
