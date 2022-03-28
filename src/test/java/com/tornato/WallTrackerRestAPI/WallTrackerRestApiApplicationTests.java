package com.tornato.WallTrackerRestAPI;


import com.tornato.WallTrackerRestAPI.entity.*;
import com.tornato.WallTrackerRestAPI.repository.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class WallTrackerRestApiApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BoulderRepository boulderRepository;

	@Autowired
	private RatingRepository ratingRepository;

	@Autowired
	private RouteSetterRepository routeSetterRepository;

	@Autowired
	private LocationRepository locationRepository;

	private static final String userFirstName = "robert";
	private static final String userLastName = "müller";
	private static final String userEmailId = "robert.müller@test.de";

	private static final String locationName = "mannheim";


	private static final String routeSetterFirstName = "max";
	private static final String routeSetterLastName = "mustermann";
	private static final String routeSetterEmailId = "max.mustermann@test.de";

	private static final String ratingReview = "War geil";


	@BeforeEach
	public void addDatasetToDb(){

		User user = new User();
		user.setFirstName(userFirstName);
		user.setLastName(userLastName);
		user.setEmailId(userEmailId);
		userRepository.save(user);

		Location location = new Location();
		location.setLocationName(locationName);
		locationRepository.save(location);

		RouteSetter routeSetter = new RouteSetter();
		routeSetter.setFirstName(routeSetterFirstName);
		routeSetter.setLastName(routeSetterLastName);
		routeSetter.setEmailId(routeSetterEmailId);
		routeSetterRepository.save(routeSetter);

		Boulder boulder = new Boulder();
		boulder.setDifficulty(3);
		boulder.setRouteSetter(routeSetter);
		boulder.setLocation(location);
		boulderRepository.save(boulder);

		Rating rating = new Rating();
		rating.setRating(3);
		rating.setReview(ratingReview);
		rating.setUser(user);
		rating.setBoulder(boulder);
		ratingRepository.save(rating);

	}

	@AfterEach
	public void deleteDatasetDb(){
		ratingRepository.deleteAll();
		boulderRepository.deleteAll();//
		routeSetterRepository.deleteAll();
		locationRepository.deleteAll();
		userRepository.deleteAll();
	}

	@Test
	void testGetRequest() {
		TestRestTemplate restTemplate = new TestRestTemplate();

		ResponseEntity<Rating> ratingResponseEntity
				= restTemplate.getForEntity("http://localhost:8080/rating/id/5",Rating.class);


		Assertions.assertEquals(ratingResponseEntity.getStatusCode(), HttpStatus.OK);
		Assertions.assertNotNull(ratingResponseEntity.getBody());
		Assertions.assertEquals(ratingResponseEntity.getBody().getRating(),3);
		Assertions.assertEquals(ratingResponseEntity.getBody().getReview(), ratingReview);

	}

}
