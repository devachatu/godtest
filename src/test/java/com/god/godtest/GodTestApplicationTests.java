package com.god.godtest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.god.godtest.controller.VerificationController;
import com.god.godtest.model.Status;
import com.god.godtest.model.Verification;
import com.god.godtest.service.VerificationService;

@SpringBootTest
class GodTestApplicationTests {

	@Spy
	private VerificationService verificationService;

	@InjectMocks
	private VerificationController controller;

	ObjectMapper mapper = new ObjectMapper();

	@BeforeAll
	public static void initMocks() {
		MockitoAnnotations.openMocks(GodTestApplicationTests.class);
	}

	@Test
	void validAnalysisRequest() {
		String json = "{" +
				"	\"type\":\"ANALYSIS\"," +
				"	\"department\":\"GOoD analysis department\"," +
				"	\"start_date\":\"2020-08-13\"," +
				"	\"end_date\":\"2020-08-15\"," +
				"	\"currency\":\"USD\"," +
				"	\"cost\":123.12," +
				"	\"parts\":[" +
				"	  {" +
				"		\"inventory_number\":\"InventoryNumber1\"," +
				"		\"name\":\"PartNumber1\"," +
				"		\"count\":1" +
				"	  }," +
				"	  {" +
				"		\"inventory_number\":\"InventoryNumber2\"," +
				"		\"name\":\"PartNumber2\"," +
				"		\"count\":2" +
				"	  }" +
				"	]" +
				"  }";
		JsonNode jsonNode;
		try {
			jsonNode = mapper.readTree(json);
			Verification response = controller.verifyRequest(jsonNode).getBody();
			assertNull(response.getErrors());
			assertEquals(Status.VALID.toString(), response.getStatus());

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	@Test
	void inValidAnalysisRequest() {
		String json = "{" +
				"	\"type\":\"ANALYSIS\"," +
				"	\"department\":\"Bad analysis department\"," +
				"	\"start_date\":\"2021-08-13\"," +
				"	\"end_date\":\"2020-08-15\"," +
				"	\"currency\":\"USD\"," +
				"	\"cost\":0," +
				"	\"parts\":[" +
				"	  {" +
				"		\"inventory_number\":\"InventoryNumber1\"," +
				"		\"name\":\"PartNumber1\"," +
				"		\"count\":1" +
				"	  }," +
				"	  {" +
				"		\"inventory_number\":\"InventoryNumber2\"," +
				"		\"name\":\"PartNumber2\"," +
				"		\"count\":2" +
				"	  }" +
				"	]" +
				"  }";
		JsonNode jsonNode;
		try {
			jsonNode = mapper.readTree(json);
			Verification response = controller.verifyRequest(jsonNode).getBody();
			assertEquals(response.getErrors().size(), 3);
			assertEquals(Status.NOT_VALID.toString(), response.getStatus());

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	@Test
	void validRepairRequest() {
		String json = "{" +
				"	\"type\":\"REPAIR\"," +
				"	\"department\":\"GOoD repair department\"," +
				"	\"start_date\":\"2020-08-13\"," +
				"	\"end_date\":\"2020-08-16\"," +
				"	\"analysis_date\":\"2020-08-14\"," +
				"	\"test_date\":\"2020-08-15\"," +
				"	\"responsible_person\":\"GOoD repair master\"," +
				"	\"currency\":\"USD\"," +
				"	\"cost\":123.12," +
				"	\"parts\":[" +
				"	   {" +
				"		  \"inventory_number\":\"InventoryNumber3\"," +
				"		  \"name\":\"PartNumber3\"," +
				"		  \"count\":3" +
				"	   }," +
				"	   {" +
				"		  \"inventory_number\":\"InventoryNumber4\"," +
				"		  \"name\":\"PartNumber4\"," +
				"		  \"count\":4" +
				"	   }" +
				"	]" +
				" }";
		JsonNode jsonNode;
		try {
			jsonNode = mapper.readTree(json);
			Verification response = controller.verifyRequest(jsonNode).getBody();
			assertNull(response.getErrors());
			assertEquals(Status.VALID.toString(), response.getStatus());

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	@Test
	void inValidRepairRequest() {
		String json = "{" +
				"	\"type\":\"REPAIR\"," +
				"	\"department\":\"GOoD repair department\"," +
				"	\"start_date\":\"2020-08-13\"," +
				"	\"end_date\":\"2020-08-16\"," +
				"	\"analysis_date\":\"2021-08-14\"," +
				"	\"test_date\":\"2020-08-15\"," +
				"	\"currency\":\"USD\"," +
				"	\"cost\":123.12," +
				"	\"parts\":[" +
				"	   {" +
				"		  \"inventory_number\":\"InventoryNumber3\"," +
				"		  \"name\":\"PartNumber3\"," +
				"		  \"count\":0" +
				"	   }," +
				"	   {" +
				"		  \"inventory_number\":\"InventoryNumber4\"," +
				"		  \"name\":\"PartNumber4\"," +
				"		  \"count\":0" +
				"	   }" +
				"	]" +
				" }";
		JsonNode jsonNode;
		try {
			jsonNode = mapper.readTree(json);
			Verification response = controller.verifyRequest(jsonNode).getBody();
			assertEquals(response.getErrors().size(), 3);
			assertEquals(Status.NOT_VALID.toString(), response.getStatus());

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	@Test
	void validReplacementRequest() {
		String json = "{" +
				"	\"type\":\"REPLACEMENT\"," +
				"	\"department\":\"GOoD replacement department\"," +
				"	\"start_date\":\"2020-08-13\"," +
				"	\"end_date\":\"2020-08-16\"," +
				"	\"factory_name\":\"GOoD factory\"," +
				"	\"factory_order_number\":\"DE12345678\"," +
				"	\"currency\":\"USD\"," +
				"	\"cost\":123.12," +
				"	\"parts\":[" +
				"	   {" +
				"		  \"inventory_number\":\"InventoryNumber5\"," +
				"		  \"name\":\"PartNumber5\"," +
				"		  \"count\":5" +
				"	   }," +
				"	   {" +
				"		  \"inventory_number\":\"InventoryNumber6\"," +
				"		  \"name\":\"PartNumber6\"," +
				"		  \"count\":6" +
				"	   }" +
				"	]" +
				" }";
		JsonNode jsonNode;
		try {
			jsonNode = mapper.readTree(json);
			Verification response = controller.verifyRequest(jsonNode).getBody();
			assertNull(response.getErrors());
			assertEquals(Status.VALID.toString(), response.getStatus());

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	@Test
	void inValidReplacementRequest() {
		String json = "{" +
				"	\"type\":\"REPLACEMENT\"," +
				"	\"department\":\"GOoD replacement department\"," +
				"	\"start_date\":\"2020-08-13\"," +
				"	\"end_date\":\"2020-08-16\"," +
				"	\"factory_name\":\"GOoD factory\"," +
				"	\"factory_order_number\":\"ERROR\"," +
				"	\"currency\":\"INR\"," +
				"	\"cost\":123.12," +
				"	\"parts\":[" +
				"	   {" +
				"		  \"name\":\"PartNumber5\"," +
				"		  \"count\":5" +
				"	   }," +
				"	   {" +
				"		  \"inventory_number\":\"InventoryNumber6\"," +
				"		  \"name\":\"PartNumber6\"," +
				"		  \"count\":6" +
				"	   }" +
				"	]" +
				" }";
		JsonNode jsonNode;
		try {
			jsonNode = mapper.readTree(json);
			Verification response = controller.verifyRequest(jsonNode).getBody();
			assertEquals(response.getErrors().size(), 2);
			assertEquals(Status.NOT_VALID.toString(), response.getStatus());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}
