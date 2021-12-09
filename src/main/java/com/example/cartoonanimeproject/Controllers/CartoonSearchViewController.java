package com.example.cartoonanimeproject.Controllers;

import com.example.cartoonanimeproject.APIResponse;
import com.example.cartoonanimeproject.APIUtility;
import com.example.cartoonanimeproject.CartoonSearch;
import com.example.cartoonanimeproject.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CartoonSearchViewController implements Initializable {

    @FXML
    private ImageView imageView;

    @FXML
    private ListView<CartoonSearch> cartoonListView;

    @FXML
    private TextField searchTextField;

    @FXML
    private Label msgLabel;

    @FXML
    private Button getMoreInfoButton;

    @FXML
    void getMoreInfo(ActionEvent event) throws IOException, InterruptedException {
        String malId = cartoonListView.getSelectionModel().getSelectedItem().getMalId();
        System.out.println(malId);
        SceneChanger.changeScenes(event, "details-view.fxml", malId);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //setCartoonFound(false, false);
       // msgLabel.setVisible(false);

        cartoonListView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldCartoon, cartoonSelected) -> {
                    try {
                        imageView.setImage(new Image(cartoonSelected.getImageUrl()));
                        //setCartoonFound(true,true);
//                        throw new Exception("invalid image");
                    } catch (Exception e) {
                        imageView.setImage(new Image("default.jpg"));
                    }
                });
    }

    @FXML
    private void searchDetails() throws IOException, InterruptedException {
        cartoonListView.getItems().clear();

        APIResponse apiResponse = APIUtility.getCartoonsData(searchTextField.getText());
        // here you need to sort the data
        cartoonListView.getItems().addAll(apiResponse.getResult());
        //System.out.println(apiResponse);

        ArrayList<CartoonSearch> list = new ArrayList<>();
        cartoonListView.getItems().addAll(list);
        updateLabel();


    }
    private void updateLabel(){
        msgLabel.setText("Number of cartoons/anime are " +"  "+ cartoonListView.getItems().stream().count());
    }

}
