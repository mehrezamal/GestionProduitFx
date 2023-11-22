package Controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
//import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import metier.Produit;
import metier.ProduitCrud;

public class HomeProduitController   implements Initializable {
	
	 @FXML
	    private TableView<Produit> tableproduit;
	 
	
    @FXML
    private Button createbtn;

    @FXML
    private Button deletebtn;

   

    @FXML
    private TableColumn<Produit, String> idnom;

    @FXML
    private TableColumn<Produit,Integer > idprix;

    @FXML
    private TableColumn<Produit, Integer> idproduit;
    @FXML
    private TableColumn<Produit, String> idcateg;

@FXML
private TextField categtxt;


    @FXML
    private TextField idproduittxt;

    @FXML
    private Button newbtn;

    @FXML
    private TextField nomtxt;

    @FXML
    private TextField prixtxt;

   

    @FXML
    private Button updatebtn;
    
    @FXML
    void afficheproduit(MouseEvent event) {
    	Produit p = tableproduit.getSelectionModel().getSelectedItem();
    	idproduittxt.setText(""+p.getId());
    	nomtxt.setText(""+p.getLib());
    	prixtxt.setText(""+p.getPrix());
    	categtxt.setText(""+p.getCateg());
    }

    @FXML
    void createproduit(ActionEvent event) {
    	

    	//int id = Integer.parseInt(idproduittxt.getText());
    	String lib = nomtxt.getText();
    	int prix = Integer.parseInt(prixtxt.getText());
    	String categ = categtxt.getText();
    	Produit p =new Produit( lib ,"null","null",prix , categ);
    	ProduitCrud.ajouter(p);
    	System.out.println("produits ok");
    	ObservableList<Produit> produits = ProduitCrud.getALL();
		System.out.println(produits);
		tableproduit.setItems(produits);
    }

    @FXML
    void deleteproduit(ActionEvent event) {
    	    	int id = Integer.parseInt(idproduittxt.getText());
    	    	String lib = nomtxt.getText();
    	    	int prix = Integer.parseInt(prixtxt.getText());
    	    	String categ = categtxt.getText();
    	    	Produit p =new Produit (id, lib ,"null","null",prix , categ);
    	    	ProduitCrud.delete(p);
    	    	idproduittxt.setText("");
    	    	
    	    	nomtxt.setText("");
    	    	prixtxt.setText("");
    	    	categtxt.setText("");
    	    	
    	    	
    	    	
    	    	ObservableList<Produit> produits = ProduitCrud.getALL();
    			System.out.println(produits);
    			tableproduit.setItems(produits);
    			
    	    }

 

    @FXML
    void newproduit(ActionEvent event) {
    	idproduittxt.setText("");
    	
    	nomtxt.setText("");
    	prixtxt.setText("");
    	categtxt.setText("");
    	
    }

    @FXML
    void updateproduit(ActionEvent event) {
    	
    	    	int id = Integer.parseInt(idproduittxt.getText());
    	    	String lib = nomtxt.getText();
    	    	int prix = Integer.parseInt(prixtxt.getText());
    	    	String categ = categtxt.getText();
    	    	Produit p =new Produit(id, lib ,"null","null",prix , categ);
    	    	ProduitCrud.update(p);
    	    	ObservableList<Produit> produits = ProduitCrud.getALL();
    			System.out.println(produits);
    			tableproduit.setItems(produits);
    		
    			
    	    }

   

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		idproduit.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("id"));
		idnom.setCellValueFactory(new PropertyValueFactory<>("lib"));
		idprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
		idcateg.setCellValueFactory(new PropertyValueFactory<>("categ"));
		ObservableList<Produit> produits = ProduitCrud.getALL();
		System.out.println(produits);
		tableproduit.setItems(produits);
		
	}

	}



