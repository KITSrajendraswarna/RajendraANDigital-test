/**
 *
 */
package com.suresearch.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.suresearch.api.VenueFinderAPIProvider;
import com.suresearch.service.VenueFinderServiceException;
import com.suresearch.service.VenueFinderServiceImpl;

/**
 * @author rswarna
 *
 */

@Controller
public class VenueFinderController {

	VenueFinderServiceImpl venueFinder;
	VenueFinderAPIProvider venueAPI;

	public VenueFinderController() {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/suresearch/context/venuefinder-context.xml");
		venueFinder = (VenueFinderServiceImpl) context
				.getBean("venueFinderServiceImpl");

	}

	@RequestMapping("/home")
	public String showHome() {
		return "Home";
	}

	@RequestMapping("/results")
	public String findVenuesInLoacation(Model model,
			@RequestParam("searchTerms") String searchTerm,
			@RequestParam("searchPlace") String searchPlace) {
		try {
			model.addAttribute("results",
					venueFinder.venueSearchResults(searchTerm, searchPlace));
		} catch (VenueFinderServiceException e) {
			// TODO log errors
			System.out.println("findVenuesInLoacation - Error occured: "
					+ e.getLocalizedMessage());
		}
		return "venueResults";
	}

}
