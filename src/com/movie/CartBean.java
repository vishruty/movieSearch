package com.movie;

import java.util.ArrayList;

public class CartBean {
    private ArrayList<String> alCartItems = new ArrayList<String>();
   
    public void addCartItem(String movieName) {
    	int s=alCartItems.size();
    	if(s==10)
    		return;
        alCartItems.add(movieName);
    }
    
    public int cartSize() {
    	return alCartItems.size();
    }

}

