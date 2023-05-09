package userinterface;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;

import businesslogic.Book;
import businesslogic.Borrowed;

public class borrowedlistController {

	 @FXML
    private TableColumn<Book, String> author;

    @FXML
    private Text catalog;

    @FXML
    private Text getcard;

    @FXML
    private TableColumn<Book, Integer> id;

    @FXML
    private Button refresh;

    @FXML
    private TableColumn<Book, String> title;

    @FXML
    private Text viewborrowedbooks;
    
    @FXML
    private TableView<Book> booktable;

    @FXML
    void borrowedbookspage(MouseEvent event) {
    	Main m = new Main();
		try {
			m.changeScene("borrowedbooks.fxml");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void cardform(MouseEvent event) {
    	Main m = new Main();
		try {
			m.changeScene("cardform.fxml");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void refreshbutton(ActionEvent event) {
    	Main m = new Main();
    	ArrayList<Book> b = m.getBLController().readbook();
    	ArrayList<Borrowed> book = m.getBLController().readborr();

    	final ObservableList<Book> data = FXCollections.observableArrayList();

    	for (Borrowed borrowed : book) {
    	    if (borrowed.getUserid() == Main.borrowerid) {
    	        int bid = borrowed.getBookid();
    	        for (Book bookItem : b) {
    	            if (bookItem.getBookid() == bid) {
    	                data.add(bookItem);
    	            }
    	        }
    	    }
    	}

    	id.setCellValueFactory(new PropertyValueFactory<Book, Integer>("Bookid"));
    	title.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
    	author.setCellValueFactory(new PropertyValueFactory<Book, String>("Author"));

    	booktable.setItems(data);

    }

    @FXML
    void showcatalogpage(MouseEvent event) {
    	Main m = new Main();
		try {
			m.changeScene("catalogmem.fxml");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

}
