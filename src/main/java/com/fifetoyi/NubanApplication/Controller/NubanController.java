package com.fifetoyi.NubanApplication.Controller;

import com.fifetoyi.NubanApplication.Model.Nuban;
import com.fifetoyi.NubanApplication.Repository.NubanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nuban")
public class NubanController {

    private final NubanRepository nubanRepository;

    @Autowired
    public NubanController(NubanRepository nubanRepository) {
        this.nubanRepository = nubanRepository;
    }

    @PostMapping
    public Nuban createdNuban(@RequestParam("bankCode") String bankCode, @RequestParam("serial") int serial) {
        // Generate NUBAN logic
        String nuban = generateNuban(bankCode, serial);

        // Create a new Nuban object
        Nuban newNuban = new Nuban();
        newNuban.setBankCode(bankCode);
        newNuban.setSerial(serial);
        newNuban.setNuban(nuban);

        // Save the new Nuban object to the database
        Nuban savedNuban = nubanRepository.save(newNuban);

        return savedNuban;
    }

    private String generateNuban(String bankCode, int serial) {
        // Generate NUBAN logic here
        // ...

        // Just a dummy implementation to concatenate the bank code and serial
        return bankCode + String.format("%09d", serial);
    }

    @GetMapping
    public String sayHello() {
        return "Hello";
    }

}
