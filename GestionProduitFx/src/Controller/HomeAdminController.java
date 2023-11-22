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
import metier.Admin;
import metier.AdminCrud;
public class HomeAdminController  implements Initializable {

    @FXML
    private TableView<Admin> tablelog;
    @FXML
    private Button btncreate;

    @FXML
    private Button btndelete;

    @FXML
    private Button btnnew;

    @FXML
    private Button btnupdate;

    @FXML
    private TextField idadmin;

    @FXML
    private TableColumn<Admin, Integer> idcol;

    @FXML
    private TextField loginadmin;

    @FXML
    private TableColumn<Admin, String> logincol;

    @FXML
    private TextField passadmin;

    @FXML
    private TableColumn<Admin, String> passcol;



    @FXML
    void Afficheadmin(MouseEvent event) {
    	Admin a = tablelog.getSelectionModel().getSelectedItem();
    	idadmin.setText(""+a.getId());
    	loginadmin.setText(""+a.getLogin());
    	passadmin.setText(""+a.getPassword());
    }

    @FXML
    void createadmin(ActionEvent event) {
    	String login = loginadmin.getText();
    	String password = passadmin.getText();
    	Admin a =new Admin( login,password);
    	AdminCrud.ajouter(a);
    	System.out.println("categ ok");
    	ObservableList<Admin> admins = AdminCrud.getALL();
		System.out.println(admins);
		tablelog.setItems(admins);
    }

    @FXML
    void deleteadmin(ActionEvent event) {
    	int id = Integer.parseInt(idadmin.getText());
    	String login = loginadmin.getText();
    	String password = passadmin.getText();
    	Admin a =new Admin( id,login,password);
    	AdminCrud.delete(a);
    	ObservableList<Admin> admins = AdminCrud.getALL();
		System.out.println(admins);
		tablelog.setItems(admins);
		idadmin.setText("");
    	loginadmin.setText("");
    	passadmin.setText("");
		
    }

    @FXML
    void newadmin(ActionEvent event) {
       idadmin.setText("");
       loginadmin.setText("");
       passadmin.setText("");
    	
    }

    @FXML
    void updateadmin(ActionEvent event) {
    	int id = Integer.parseInt(idadmin.getText());
    	String login = loginadmin.getText();
    	String password = passadmin.getText();
    	Admin a =new Admin( id,login,password);
    	AdminCrud.update(a);
    	ObservableList<Admin> admins = AdminCrud.getALL();
		System.out.println(admins);
		tablelog.setItems(admins);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		idcol.setCellValueFactory(new PropertyValueFactory<Admin,Integer>("id"));
		logincol.setCellValueFactory(new PropertyValueFactory<>("login"));
		passcol.setCellValueFactory(new PropertyValueFactory<>("password"));
		
		ObservableList<Admin> admins = AdminCrud.getALL();
		System.out.println(admins);
		tablelog.setItems(admins);
	}

}
