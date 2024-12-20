package com.example.cartoonanimeproject.Controllers;

import com.example.cartoonanimeproject.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class DetailsOfCartoonController implements InitializeCartoonSearch {

        @FXML
        private Label episodeLabel;

        @FXML
        private Label airingLabel;

        @FXML
        private Label typeLabel;

        @FXML
        private Label scoreLabel;

        @FXML
        private Label durationLabel;

        @FXML
        private TextArea synopsisTextArea;

        @FXML
        private Label animeTitleLabel;

        @FXML
        private Label rankLabel;

        @FXML
        private Label popularityLabel;

        @FXML
        private Label membersLabel;

        @FXML
        private TextField urlTextField;

        @FXML
        private ImageView imageView;

        @FXML
        private Label ratingLabel;

        public void loadCartoonInfo(String malId)
        {

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
        durationLabel.setText(cartoonInfo.getDuration());
        typeLabel.setText(cartoonInfo.getType());
        synopsisTextArea.setText(cartoonInfo.getSynopsis());
        imageView.setImage(new Image(cartoonInfo.getImageUrl()));
        urlTextField.setText(cartoonInfo.getUrl());
        ratingLabel.setText(cartoonInfo.getRating());
        membersLabel.setText(cartoonInfo.getMembers());
        rankLabel.setText(cartoonInfo.getRank());
        popularityLabel.setText(cartoonInfo.getPopularity());
        }
    @FXML
    private void returnBack(ActionEvent event) throws IOException, InterruptedException {
        SceneChanger.changeScenes(event,"CartoonSearchView.fxml");
        }
}


