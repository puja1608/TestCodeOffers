package com.example.buyonegetoneapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ApplyDiscount {
	
	 @PostMapping("/maximizeDiscountOffer1")
	    public DiscountResponse maximizeDiscountOffer1(@RequestBody List<Integer> priceList) {
	        Collections.sort(priceList, Collections.reverseOrder()); // Sort prices in descending order
	        List<Integer> discountedItems = new ArrayList<>();
	        List<Integer> payableItems = new ArrayList<>();
	        boolean[] used = new boolean[priceList.size()];

	        for (int i = 0; i < priceList.size(); i++) {
	            if (!used[i]) {
	                discountedItems.add(priceList.get(i));
	                
	                boolean foundPair = false;
	                
	                for (int j = i + 1; j < priceList.size(); j++) {
	                    if (!used[j] && priceList.get(j) < priceList.get(i)) {
	                        discountedItems.add(priceList.get(j));
	                        payableItems.add(priceList.get(i));
	                        used[j] = true;
	                        foundPair = true;
	                        break;
	                    }
	                }
	                if (!foundPair) {
	                    payableItems.add(priceList.get(i));
	                }
	            }
	        }
	        
	        DiscountResponse response = new DiscountResponse();
	        response.setDiscountedItems(discountedItems);
	        response.setPayableItems(payableItems);
	        return response;
	 }
	 
	 @PostMapping("/maximizeDiscountOffer2")
	    public DiscountResponse maximizeDiscountOffer2(@RequestBody List<Integer> priceList) {
	        Collections.sort(priceList, Collections.reverseOrder()); // Sort prices in descending order
	        List<Integer> discountedItems = new ArrayList<>();
	        List<Integer> payableItems = new ArrayList<>();
	        boolean[] used = new boolean[priceList.size()];

	        for (int i = 0; i < priceList.size(); i++) {
	            if (!used[i]) {
	                discountedItems.add(priceList.get(i));
	                boolean foundPair = false;
	                for (int j = i + 1; j < priceList.size(); j++) {
	                    if (!used[j] && priceList.get(j) < priceList.get(i)) {
	                        discountedItems.add(priceList.get(j));
	                        payableItems.add(priceList.get(i));
	                        used[j] = true;
	                        foundPair = true;
	                        break;
	                    }
	                }
	                if (!foundPair) {
	                    payableItems.add(priceList.get(i));
	                }
	            }
	        }

	        DiscountResponse response = new DiscountResponse();
	        response.setDiscountedItems(discountedItems);
	        response.setPayableItems(payableItems);
	        return response;
	    }
	 
	 
	   @PostMapping("/maximizeDiscountOffer3")
	    public DiscountResponse maximizeDiscountOffer3(@RequestBody List<Integer> priceList) {
 	        Collections.sort(priceList);

	        List<Integer> discountedItems = new ArrayList<>();
	        List<Integer> payableItems = new ArrayList<>();

	        // Iterate : pairs of products
	        for (int i = 0; i < priceList.size(); i += 2) {
	            if (i + 1 < priceList.size() && priceList.get(i + 1) < priceList.get(i)) {
 
	            	discountedItems.add(priceList.get(i + 1));
	                discountedItems.add(priceList.get(i));
	            } else {
 
	            	payableItems.add(priceList.get(i));
	                if (i + 1 < priceList.size()) {
	                    payableItems.add(priceList.get(i + 1));
	                }
	            }
	        }

 	        return new DiscountResponse(discountedItems, payableItems);
	    }

	 
	 @GetMapping("/maximizeDiscount")
	    public DiscountResponse maximizeDiscount1() {
	        
	        
	        DiscountResponse response = new DiscountResponse();
	        response.setDiscountedItems(null);
	        response.setPayableItems(null);
 	        return response;
	 }
}
	  
 
