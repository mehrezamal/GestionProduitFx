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
import metier.Categ;
import metier.CategCrud;


public class HomeCategController implements Initializable {
   
	 @FXML
	    private TableView<Categ> tablecateg;
    @FXML
    private Button btncreate;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnnew;

    @FXML
    private Button btnupdate;

    @FXML
    private TableColumn<Categ, Integer> codecol;

    @FXML
    private TextField idcode;

    @FXML
    private TextField idnom;

    @FXML
    private TableColumn<Categ, String> nomcol;

   

    @FXML
    void Affichecateg(MouseEvent event) {
    	Categ g = tablecateg.getSelectionModel().getSelectedItem();
    	idcode.setText(""+g.getCode());
    	idnom.setText(""+g.getNomcateg());
 
    }

    @FXML
    void Newcateg(ActionEvent event) {
	idcode.setText("");
    	
    	idnom.setText("");
    	
    }

    @FXML
    void createcateg(ActionEvent event) {
    	//int id = Integer.parseInt(idproduittxt.getText());
    	//int code = Integer.parseInt(idcode.getText());
    	String nomcateg = idnom.getText();
    	Categ g =new Categ( nomcateg);
    	CategCrud.ajouter(g);
    	System.out.println("categ ok");
    	ObservableList<Categ> categs = CategCrud.getALL();
		System.out.println(categs);
		tablecateg.setItems(categs);
    }

    @FXML
    void deletecateg(ActionEvent event) {
    	int code = Integer.parseInt(idcode.getText());
    	String nomcateg = idnom.getText();
    	Categ g =new Categ( code,nomcateg);
    	CategCrud.delete(g);
    	ObservableList<Categ> categs = CategCrud.getALL();
		System.out.println(categs);
		tablecateg.setItems(categs);
		idcode.setText("");
    	idnom.setText("");
		
		
    }

    @FXML
    void updatecateg(ActionEvent event) {
    	int code = Integer.parseInt(idcode.getText());
    	String nomcateg = idnom.getText();
    	Categ g =new Categ( code,nomcateg);
    	CategCrud.update(g);
    	ObservableList<Categ> categs = CategCrud.getALL();
		System.out.println(categs);
		tablecateg.setItems(categs);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	
				codecol.setCellValueFactory(new PropertyValueFactory<Categ,Integer>("code"));
				nomcol.setCellValueFactory(new PropertyValueFactory<>("nomcateg"));
				
				ObservableList<Categ> categs = CategCrud.getALL();
				System.out.println(categs);
				tablecateg.setItems(categs);
	}

}
