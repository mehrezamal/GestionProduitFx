package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class HomeController {

    @FXML
    private AnchorPane bodyHome;

    @FXML
    private Button btnadmin;

    @FXML
    private Button btncategorie;

    @FXML
    private Button btnclient;

    @FXML
    private Button ptnproduit;

    @FXML
    void adminHome(ActionEvent event) {
    	try {
        	Parent adminghome = FXMLLoader.load(getClass().getResource("/view/homeadmin.fxml"));
           bodyHome.getChildren().removeAll();
        bodyHome.getChildren().setAll(adminghome);

        	} catch (IOException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        	}
    }

    @FXML
    void categorieHome(ActionEvent event) {
    	try {
        	Parent categhome = FXMLLoader.load(getClass().getResource("/view/homecateg.fxml"));
           bodyHome.getChildren().removeAll();
        bodyHome.getChildren().setAll(categhome);

        	} catch (IOException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        	}
    }

    @FXML
    void ComHome(ActionEvent event) {
    	try {
        	Parent Comhome = FXMLLoader.load(getClass().getResource("/view/homecomande.fxml"));
           bodyHome.getChildren().removeAll();
        bodyHome.getChildren().setAll(Comhome);

        	} catch (IOException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        	}
        }


    	@FXML
    	void produitHome(ActionEvent event) {
    	try {
    	Parent produithome = FXMLLoader.load(getClass().getResource("/view/homeproduit.fxml"));
       bodyHome.getChildren().removeAll();
    bodyHome.getChildren().setAll(produithome);

    	} catch (IOException e) {
    	// TODO Auto-generated catch block
    	e.printStackTrace();
    	}
    }

}
