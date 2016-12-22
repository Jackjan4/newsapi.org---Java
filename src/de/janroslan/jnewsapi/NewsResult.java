/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.janroslan.jnewsapi;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author jackjan
 */
public class NewsResult {
    
    private String status;
    private String source;
    private String sortBy;
    private Article[] articles;
    
    public NewsResult(String jsonResponse)
    {
        JSONObject obj = new JSONObject(jsonResponse);
        status = obj.getString("status");
        source = obj.getString("source");
        sortBy = obj.getString("sortBy");
        
        JSONArray arr = obj.getJSONArray("articles");
        articles = new Article[arr.length()];
        for(int i = 0; i < arr.length(); i++)
        {
            articles[i] = new Article(arr.getJSONObject(i));
        }
    }

    public String getStatus() {
        return status;
    }

    public String getSource() {
        return source;
    }

    public String getSortBy() {
        return sortBy;
    }

    public Article[] getArticles() {
        return articles;
    }
    
    
    
}
