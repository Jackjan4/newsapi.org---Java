/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.janroslan.jnewsapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author jackjan
 */
public class NewsRequest {

    private final String apiKey;
    private String newsSource;
    private SortBy sort;

    public NewsRequest(String apiKey, String newsSource, SortBy sort) {
        this.apiKey = apiKey;
        this.newsSource = newsSource;
        this.sort = sort;
    }

    public NewsRequest(String apiKey, String newsSource) {
        this.apiKey = apiKey;
        this.newsSource = newsSource;
        this.sort = null;
    }

    public NewsResult invoke() {

        String htmlSite = "";
        URL url = null;
        try {
            if (sort != null) {
                url = new URL("https://newsapi.org/v1/articles?source=" + newsSource + "&sortBy=" + sort.toString() + "&apiKey=" + apiKey);
            } else {
                url = new URL("https://newsapi.org/v1/articles?source=" + newsSource + "&apiKey=" + apiKey);
            }
        } catch (MalformedURLException ex) {
            return null;
        }

        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                htmlSite += inputLine;
            }
        } catch (IOException ex) {
            return null;
        }

        return new NewsResult(htmlSite);
    }

    public NewsResult invoke(String newsSource) {
        this.newsSource = newsSource;
        return invoke();
    }

    public NewsResult invoke(String newsSource, SortBy sort) {
        this.newsSource = newsSource;
        this.sort = sort;
        return invoke();
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getNewsSource() {
        return newsSource;
    }

    public SortBy getSort() {
        return sort;
    }

}
