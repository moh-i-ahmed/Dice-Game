package dice_game;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainControl {
	

    @FXML
    private TextField player_name;
    
    

    @FXML
    void onPlayClicked(ActionEvent event) throws IOException {
    	
    	Player p1 = new Player(player_name.getText());
        String name= player_name.getText();
    	
    	String pl_name = player_name.getText();
    	Stage stage=new Stage();
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("Roll_Pane.fxml"));
		Parent root=(Parent)loader.load();
		RollControl sc =loader.getController();
		sc.setText(pl_name);
		
		stage.setScene(new Scene(root));
		stage.show();



    }

}

