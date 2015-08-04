package com.suresearch.api;

import fi.foyt.foursquare.api.FoursquareApi;

public class VenueFinderAPIProvider {

	public static String clientId;
	public static String clientSecret;
	public static String callbakcURL;


	public static void setClientId(String clientId) {
		VenueFinderAPIProvider.clientId = clientId;
	}


	public static void setClientSecret(String clientSecret) {
		VenueFinderAPIProvider.clientSecret = clientSecret;
	}


	public static void setCallbakcURL(String callbakcURL) {
		VenueFinderAPIProvider.callbakcURL = callbakcURL;
	}

	public static FoursquareApi getFoursquareApi() {
		return new FoursquareApi(clientId, clientSecret, callbakcURL);
	}

}
