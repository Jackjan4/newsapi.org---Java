/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.janroslan.jnewsapi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author jackjan
 */
public class Article {

    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private Date publishedAt;

    Article(JSONObject jsonObject) {
        author = (jsonObject.get("author").toString().equals("null")) ? null : (String) jsonObject.get("author");
        title = (String) jsonObject.get("title");

        description = (jsonObject.get("description").toString().equals("null")) ? null : (String) jsonObject.get("description");

        url = (String) jsonObject.get("url");
        urlToImage = (String) jsonObject.get("urlToImage");

        String publish = (jsonObject.get("publishedAt").toString().equals("null")) ? null : (String) jsonObject.get("publishedAt");
        if (publish != null) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            try {
                publishedAt = df.parse(publish);
            } catch (ParseException ex) {
                publishedAt = null;
            }
        }
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

}
