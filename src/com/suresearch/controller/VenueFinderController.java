/**
 *
 */
package com.suresearch.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fi.foyt.foursquare.api.FoursquareApi;
import fi.foyt.foursquare.api.FoursquareApiException;
import fi.foyt.foursquare.api.Result;
import fi.foyt.foursquare.api.entities.Category;
import fi.foyt.foursquare.api.entities.CompactVenue;
import fi.foyt.foursquare.api.entities.VenuesSearchResult;

/**
 * @author rajendraswarna
 *
 */

@Controller
public class VenueFinderController {

    @RequestMapping("/home")
    public String showHome() {
	return "Home";
    }

    @RequestMapping(value="/venueFinderHome", method=RequestMethod.POST)
    public void getCategory(@RequestParam("searchTerms") String searchTerm) {
        System.out.println("***" + searchTerm);

    }

    @RequestMapping("/results")
    public String showProductsListing(Model model,@RequestParam("searchTerms") String searchTerm) throws FoursquareApiException {
    //String category =  model.@RequestParam("searchTerm");
	model.addAttribute("results", searchVenues(searchTerm));
	return "venueResults";
    }

	public List<String> searchVenues(String category)  {
    	List<String> results = new ArrayList<String>();
    	String ll = "51.500096,-0.590662";

    	// First we need a initialize FoursquareApi.
	    FoursquareApi foursquareApi = new FoursquareApi("13Z01ON0L32HP5PMNM5XE2LAWBUY4FBJXJJW2TXUB4SGIBHG", "4ZI1SXIUYHAC3KYFGAOE4P3VFFRP0XGCTJ4CZCZ3QB4JRTHO",null);

	    // After client has been initialized we can make queries.
	    Result<VenuesSearchResult> result;
		try {
		    result = foursquareApi.venuesSearch(ll, null, null, null, null, null, null, getCategoryId(category), null, null, null, null, ll);
		    // result = foursquareApi.venuesExplore(ll, null, null, null, null, null, null, "4bf58dd8d48988d1f1931735", null, null, null, 8000, null);


	    if (result.getMeta().getCode() == 200) {
	      // if query was ok we can finally we do something with the data
	      for (CompactVenue venue : result.getResult().getVenues()) {
	        // TODO: Do something we the data
	        System.out.println(venue.getName());
	        results.add((venue.getName()).toString());
	      }

	    } else {
	      // TODO: Proper error handling
	      System.out.println("Error occured: ");
	      System.out.println("  code: " + result.getMeta().getCode());
	      System.out.println("  type: " + result.getMeta().getErrorType());
	      System.out.println("  detail: " + result.getMeta().getErrorDetail());

	    }
		} catch (FoursquareApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return results;
	  }

    private String getCategoryId(String category) {

    	String catId = "4d4b7104d754a06370d81259";
    	try {
        	// First we need a initialize FoursquareApi.
    	    FoursquareApi foursquareApi = new FoursquareApi("13Z01ON0L32HP5PMNM5XE2LAWBUY4FBJXJJW2TXUB4SGIBHG", "4ZI1SXIUYHAC3KYFGAOE4P3VFFRP0XGCTJ4CZCZ3QB4JRTHO",null);

    		List<Category> cats = new ArrayList<Category>();
	      Result<Category[]> res = foursquareApi.venuesCategories();
	      Category[] catss = res.getResult();
	      cats.addAll(Arrays.asList(catss));
	      for (Category cat : cats) {
	    	  System.out.println("-----" + cat.getId() + "-" + cat.getName());
	    	  Category[] subCat = cat.getCategories();
	    	  if (subCat != null && subCat.length > 0) {
	    		  for (int i = 0; i < subCat.length; i++) {
	    			  System.out.println("========" + subCat[i].getId() + "-" +subCat[i].getName());
	    	    	  if (category.equalsIgnoreCase(subCat[i].getName())) {
	    	    		  catId = subCat[i].getId();
	    	    	  }
	    		  }
	    	  }
	    	  if (category.equalsIgnoreCase(cat.getName())) {
	    		  catId = cat.getId();
	    	  }
	      }
		} catch (FoursquareApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	  	System.out.println("-----" + category + "-" + catId);
	    return catId;
    }

}
