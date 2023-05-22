package com.fifetoyi.NubanApplication;

import com.fifetoyi.NubanApplication.model.Nuban;
import com.fifetoyi.NubanApplication.repository.NubanRepository;
import com.fifetoyi.NubanApplication.service.NubanService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NubanApplicationTests {

	@Autowired
	private NubanRepository nubanRepository;

	@Test
	public void givenGeneratedNuban_return_validParametersAndSaveToDatabase() {

		NubanService nubanService = new NubanService(nubanRepository);
		String bankCode = "ABC";
		int serial = 123;
		Nuban resultNuban = nubanService.generateNuban(bankCode, serial);

		Nuban savedNuban = nubanRepository.save(resultNuban);

		Nuban retrievedNuban = nubanRepository.findById(savedNuban.getId()).orElse(null);

		assertEquals(savedNuban.getBankCode(), retrievedNuban.getBankCode());
		assertEquals(savedNuban.getSerial(), retrievedNuban.getSerial());
		assertEquals(savedNuban.getNuban(), retrievedNuban.getNuban());
	}

	@Test
	public void givenValidParameters_return_random10DigitNuban() {
		NubanService nubanService = new NubanService(nubanRepository);
		String bankCode = "ABC";
		int serial = 123;
		String resultNuban = nubanService.generateNubanLogic(bankCode, serial);

		assertNotNull(resultNuban);
		assertEquals(10, resultNuban.length());
		assertTrue(resultNuban.matches("\\d{10}"));
	}

	@Test
	public void givenValidParameters_return_differentRandomNumbersOnEachCall() {
		NubanService nubanService = new NubanService(nubanRepository);
		String bankCode = "ABC";
		int serial = 123;

		String resultNuban1 = nubanService.generateNubanLogic(bankCode, serial);
		String resultNuban2 = nubanService.generateNubanLogic(bankCode, serial);
		String resultNuban3 = nubanService.generateNubanLogic(bankCode, serial);

		// Verify that each result is different
		assertNotEquals(resultNuban1, resultNuban2);
		assertNotEquals(resultNuban1, resultNuban3);
		assertNotEquals(resultNuban2, resultNuban3);
	}

}

