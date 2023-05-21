package com.fifetoyi.NubanApplication.controller;

import com.fifetoyi.NubanApplication.model.Nuban;
import com.fifetoyi.NubanApplication.repository.NubanRepository;
import com.fifetoyi.NubanApplication.service.NubanService;
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

        NubanService nubanService = new NubanService(nubanRepository);
        return nubanService.generateNuban(bankCode, serial);
    }

}
