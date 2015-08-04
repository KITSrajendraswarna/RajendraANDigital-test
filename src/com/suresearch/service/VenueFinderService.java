package com.suresearch.service;

import java.util.List;


public interface VenueFinderService {

     List<String> venueSearchResults(String category, String near) throws VenueFinderServiceException;

}
