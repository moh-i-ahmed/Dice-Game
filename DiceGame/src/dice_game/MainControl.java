package dice_game;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainControl {
	

    @FXML
    private TextField player_name;
    
    @FXML
    private TextField player_name1;
    
    @FXML
    private ImageView logo;

  
    
    @FXML
    void onPlayClicked(ActionEvent event) throws IOException {
    	
    	String name1= player_name.getText();
    	String name2= player_name1.getText();
    	
    	
    	Stage stage=new Stage();
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("Roll_Pane.fxml"));
		Parent root=(Parent)loader.load();
		RollControl sc =loader.getController();
		sc.setText(name1);
		sc.setText1(name2);
		
		stage.setScene(new Scene(root));
		stage.show();
		
    }
    
    
    
    
    
    
    
    
    
    

}

