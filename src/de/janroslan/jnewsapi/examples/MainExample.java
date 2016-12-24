/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.janroslan.jnewsapi.examples;

import de.janroslan.jnewsapi.NewsRequest;
import de.janroslan.jnewsapi.NewsResult;

/**
 *
 * @author jackjan
 */
public class MainExample {
    
    public static void main(String[] args)
    {
        NewsRequest req = new NewsRequest("d2b2b70d6dfb48f1854be80466e08829","google-news");
        
        NewsResult res = req.invoke();
        
        String s = "";
    }
}
