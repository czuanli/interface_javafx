package application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PaymentController {

    @FXML
    private Button success;
    
    @FXML
    private Button cancel;
    
    
    @FXML
    private Button back;

    @FXML
    void successPayment(ActionEvent event) throws Exception{
    	try {

			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("PaymentSuccessView.fxml"));
			Scene scene = new Scene(root,443,339);
			stage.setTitle("Paiement réussi");
			stage.setScene(scene);
			stage.show();
			
			Stage precedentStage = (Stage) success.getScene().getWindow();
		    // do what you have to do
			precedentStage.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    
    @FXML
    void cancel(ActionEvent event) throws IOException {
    	
		try {

			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("panierView.fxml"));
			Scene scene = new Scene(root,1094,623);
			stage.setTitle("Panier");
			stage.setScene(scene);
			stage.show();
			
			Stage precedentStage = (Stage) cancel.getScene().getWindow();
		    // do what you have to do
			precedentStage.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void backStage(ActionEvent event) throws Exception{
    	
    	try {

			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
			Scene scene = new Scene(root,1094,623);
			stage.setTitle("Accueil");
			stage.setScene(scene);
			stage.show();
			
			Stage precedentStage = (Stage) cancel.getScene().getWindow();
		    // do what you have to do
			precedentStage.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}