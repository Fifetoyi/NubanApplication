package com.fifetoyi.NubanApplication.service;

import com.fifetoyi.NubanApplication.model.Nuban;
import com.fifetoyi.NubanApplication.repository.NubanRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class NubanService {

    private final NubanRepository nubanRepository;

    public NubanService(NubanRepository nubanRepository) {
        this.nubanRepository = nubanRepository;
    }

    public Nuban generateNuban(String bankCode, int serial) {
        // Generate NUBAN logic here
        String generatedNuban = generateNubanLogic(bankCode, serial);

        // Save Nuban to the database
        Nuban nuban = new Nuban();
        nuban.setBankCode(bankCode);
        nuban.setSerial(serial);
        nuban.setNuban(generatedNuban);
        nubanRepository.save(nuban);

        return nuban;
    }

    public String generateNubanLogic(String bankCode, int serial) {
        Random random = new Random();
        int randomNumber = random.nextInt(900000000) + 1000000000;
        return String.valueOf(randomNumber);
    }

}
