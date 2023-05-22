package com.fifetoyi.nuban.controller;

import com.fifetoyi.nuban.model.Nuban;
import com.fifetoyi.nuban.service.NubanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nuban")
public class NubanController {

    private final NubanService nubanService;

    @Autowired
    public NubanController(NubanService nubanService) {
        this.nubanService = nubanService;
    }

    @PostMapping
    public Nuban createdNuban(@RequestParam("bankCode") String bankCode, @RequestParam("serial") int serial) {
        return nubanService.generateNuban(bankCode, serial);
    }

}
