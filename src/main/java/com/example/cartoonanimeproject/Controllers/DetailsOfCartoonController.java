package com.example.cartoonanimeproject.Controllers;

import com.example.cartoonanimeproject.APIUtility;
import com.example.cartoonanimeproject.CartoonSearch;
import com.example.cartoonanimeproject.CartoonTotalInfo;
import com.example.cartoonanimeproject.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class DetailsOfCartoonController {

        @FXML
        private Label episodeLabel;

        @FXML
        private Label airingLabel;

        @FXML
        private Label typeLabel;

        @FXML
        private Label scoreLabel;

        @FXML
        private Label startDateLabel;

        @FXML
        private Label endDateLabel;

        @FXML
        private ListView<String> synopsisListView;

        @FXML
        private Label animeTitleLabel;


        @FXML
        private TextField urlTextField;

        @FXML
        private ImageView imageView;








    public void loadCartoonInfo( String malId){

        CartoonTotalInfo cartoonInfo = null;
        try {
            cartoonInfo = APIUtility.getMoreInfo(malId);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        animeTitleLabel.setText(cartoonInfo.getTitle());
        episodeLabel.setText(cartoonInfo.getEpisodes());
        airingLabel.setText(cartoonInfo.getAiring());
        typeLabel.setText(cartoonInfo.getType());
        scoreLabel.setText(cartoonInfo.getScore());
        startDateLabel.setText(cartoonInfo.getStartDate());
        endDateLabel.setText(cartoonInfo.getEndDate());
        synopsisListView.getItems().addAll(cartoonInfo.getSynopsis());
        imageView.setImage(new Image(cartoonInfo.getImageUrl()));
        urlTextField.setText(cartoonInfo.getUrl());





    }
    @FXML
    private void returnBack(ActionEvent event) throws IOException, InterruptedException {
        SceneChanger.changeScenes(event,"CartoonSearchView.fxml");

    }
}
