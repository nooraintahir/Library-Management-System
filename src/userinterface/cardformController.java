package userinterface;

import java.util.ArrayList;

import businesslogic.Borrower;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class cardformController {

    @FXML
    private TextField id;

    @FXML
    private TextField name;

    @FXML
    private TextField password;

    @FXML
    private Button requestcard;

    @FXML
    private Text warning;

    @FXML
    void requestcard(ActionEvent event) {
    	
    	Main m=new Main();
    	int bid=Integer.parseInt(id.getText());
    	if(name.getText()==Main.bname && bid==Main.borrowerid && password.getText()==Main.bpass)
    	{
    		ArrayList<Borrower> borr = m.getBLController().readborrower();
    		int index=-1;
			for (int i = 0; i < borr.size(); i++)
		        if (borr.get(i).getBorrowerid()==bid)
		            index= i;
			
				    			
			if(index==-1) //checking if that userid exists
			{
				warning.setText("Wrong ID");
			}
			if (borr.get(index).getLibraryCard()==true)
			{
				warning.setText("You already have a library card!");
			}
			else {
	    		borr.get(index).setForm(true);
	    		warning.setText("Form sent!");
			}
    	}
    	warning.setText("Information incorrect!");

    }

}
