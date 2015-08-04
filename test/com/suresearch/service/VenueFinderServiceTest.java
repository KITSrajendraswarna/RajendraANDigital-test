package com.suresearch.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.suresearch.api.VenueFinderAPIProvider;

import fi.foyt.foursquare.api.FoursquareApi;

@RunWith(PowerMockRunner.class)
@PrepareForTest(VenueFinderAPIProvider.class)
public class VenueFinderServiceTest {


	VenueFinderServiceImpl classUnderTest;

	@Before
	public void setUp() throws Exception {
		classUnderTest = new VenueFinderServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	 @Test
	 public void testVenueSearchResults() throws VenueFinderServiceException {
			String category = "Aquarium";
			String near = "London, UK";

			PowerMockito.mockStatic(VenueFinderAPIProvider.class);
			PowerMockito
					.when(VenueFinderAPIProvider.getFoursquareApi())
					.thenReturn(
							new FoursquareApi(
									"13Z01ON0L32HP5PMNM5XE2LAWBUY4FBJXJJW2TXUB4SGIBHG",
									"4ZI1SXIUYHAC3KYFGAOE4P3VFFRP0XGCTJ4CZCZ3QB4JRTHO",
									null));

			List<String> results = classUnderTest.venueSearchResults(category, near);

			assertEquals(results.size(), 13);
			assertEquals(results.contains("Sea Life London Aquarium"), true);

			PowerMockito.verifyStatic();
	 }

	@Test
	public void testGetCategoryId() {
		String category = "Aquarium";

		PowerMockito.mockStatic(VenueFinderAPIProvider.class);
		PowerMockito
				.when(VenueFinderAPIProvider.getFoursquareApi())
				.thenReturn(
						new FoursquareApi(
								"13Z01ON0L32HP5PMNM5XE2LAWBUY4FBJXJJW2TXUB4SGIBHG",
								"4ZI1SXIUYHAC3KYFGAOE4P3VFFRP0XGCTJ4CZCZ3QB4JRTHO",
								null));

		String categoryId = classUnderTest.getCategoryId(category);
		assertEquals(categoryId, "4fceea171983d5d06c3e9823");
		PowerMockito.verifyStatic();
	}
}
