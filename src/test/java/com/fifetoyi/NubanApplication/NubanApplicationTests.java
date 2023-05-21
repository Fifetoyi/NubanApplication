package com.fifetoyi.NubanApplication;

import com.fifetoyi.NubanApplication.Model.Nuban;
import com.fifetoyi.NubanApplication.Repository.NubanRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class NubanApplicationTests {

	@Autowired
	private NubanRepository nubanRepository;

	@Test
	public void givenGeneratedNuban_return_validParametersAndSaveToDatabase() {
		// Create a new Nuban object
		Nuban newNuban = new Nuban();
		newNuban.setBankCode("ABC");
		newNuban.setSerial(123);
		newNuban.setNuban("ABC123");

		// Save the Nuban to the database
		Nuban savedNuban = nubanRepository.save(newNuban);

		// Retrieve the Nuban from the database
		Nuban retrievedNuban = nubanRepository.findById(savedNuban.getId()).orElse(null);

		// Verify that the Nuban is saved to the database
		assertEquals(savedNuban.getBankCode(), retrievedNuban.getBankCode());
		assertEquals(savedNuban.getSerial(), retrievedNuban.getSerial());
		assertEquals(savedNuban.getNuban(), retrievedNuban.getNuban());
	}

}

