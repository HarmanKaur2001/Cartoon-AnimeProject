package com.example.cartoonanimeproject;

import com.google.gson.annotations.SerializedName;

public class CartoonSearch implements Comparable<CartoonSearch>{
        @SerializedName("title")
        private String title;

        @SerializedName("image_url")
        private String imageUrl;

        @SerializedName("mal_id")
        private String malId;

        @SerializedName("type")
        private String type;

        @SerializedName("episodes")
        private String episodes;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getMalId() {
        return malId;
    }

    public void setMalId(String malId) {
        this.malId = malId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEpisodes() {
        return episodes;
    }

    public void setEpisodes(String episodes) {
        this.episodes = episodes;
    }

    public String toString()
        {
            return String.format("%s-%s",title, type, episodes);
        }


    @Override
    public int compareTo(CartoonSearch otherCartoonSearch) {
        return this.getTitle().compareTo(otherCartoonSearch.getTitle());
    }
}


