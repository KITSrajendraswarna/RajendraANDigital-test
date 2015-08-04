/**
 *
 */
package com.suresearch.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.suresearch.api.VenueFinderAPIProvider;

import fi.foyt.foursquare.api.FoursquareApi;
import fi.foyt.foursquare.api.FoursquareApiException;
import fi.foyt.foursquare.api.Result;
import fi.foyt.foursquare.api.entities.Category;
import fi.foyt.foursquare.api.entities.CompactVenue;
import fi.foyt.foursquare.api.entities.VenuesSearchResult;

/**
 * @author rswarna
 *
 */
public class VenueFinderServiceImpl implements VenueFinderService {

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.suresearch.service.VenueFinderService#venueSearchResults(java.lang
	 * .String, java.lang.String)
	 */
	@Override
	public List<String> venueSearchResults(String category, String near)
			throws VenueFinderServiceException {

		List<String> results = new ArrayList<String>();

		// initialize FoursquareApi.
		FoursquareApi foursquareApi = VenueFinderAPIProvider.getFoursquareApi();

		Result<VenuesSearchResult> result;
		try {
			result = foursquareApi.venuesSearch(null, null, null, null, null,
					null, null, getCategoryId(category), null, null, null,
					null, near);

			if (result.getMeta().getCode() == 200) {
				for (CompactVenue venue : result.getResult().getVenues()) {
					results.add((venue.getName()).toString());
				}

			} else {
				System.out.println("Error occured: ");
				System.out.println("  code: " + result.getMeta().getCode());
				System.out
						.println("  type: " + result.getMeta().getErrorType());
				System.out.println("  detail: "
						+ result.getMeta().getErrorDetail());

			}
		} catch (FoursquareApiException e) {
			e.printStackTrace();
		}
		return results;
	}

	/*
	 * Returns foursquare categoryId from search term
	 *
	 */
	public String getCategoryId(String category) {

		String catId = null;
		try {
			// initialize FoursquareApi.
			FoursquareApi foursquareApi = VenueFinderAPIProvider.getFoursquareApi();

			List<Category> cats = new ArrayList<Category>();
			Result<Category[]> res = foursquareApi.venuesCategories();
			Category[] catss = res.getResult();
			cats.addAll(Arrays.asList(catss));
			for (Category cat : cats) {
				Category[] subCat = cat.getCategories();
				if (subCat != null && subCat.length > 0) {
					for (int i = 0; i < subCat.length; i++) {
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
			e.printStackTrace();
		}

		return catId;
	}

}
