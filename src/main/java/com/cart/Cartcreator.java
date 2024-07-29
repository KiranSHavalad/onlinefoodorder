package com.cart;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Cartcreator {
    private static HashMap<Integer, Cartitem> map;

    public Cartcreator() {
        if (map == null) {
            map = new HashMap<Integer, Cartitem>();
        }
    }

    public synchronized HashMap<Integer, Cartitem> additemcart(Cartitem ci) {
        if (map.containsKey(ci.getItemid())) {
            Cartitem cr = map.get(ci.getItemid());
            int newQuantity = cr.getQuantity() + ci.getQuantity();
            cr.setQuantity(newQuantity);
            cr.setQprice(newQuantity * ci.getQprice());
        } else {
            map.put(ci.getItemid(), ci);
        }
        return map;
    }

    public void update(Cartitem ci, int quantity) {
    	if(quantity > 1) {
    		Cartitem cr = map.get(ci.getItemid());
    		cr.setQuantity(quantity);
    		cr.setQprice(quantity*ci.getPrice());
    		map.put(ci.getItemid(), cr);
    	} else if(quantity == 1 ) {
    		Cartitem cm = map.get(ci.getItemid());
    		cm.setQuantity(1);
    		cm.setQprice(ci.getPrice());
    		map.put(ci.getItemid(),cm);
    	}
    }
    
    public void updateone(Cartitem ci) {
    	Cartitem cr = map.get(ci.getItemid());
    	map.put(ci.getItemid(), cr);
    }

    public void delete(HashMap<Integer, Cartitem> cart, int itemId) {
        cart.remove(itemId);
        
    }
        	
        
        
    

    public HashMap<Integer, Cartitem> getCartItems() {
        return map;
    }
}
