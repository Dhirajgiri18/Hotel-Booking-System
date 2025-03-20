package com.hotel.booking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.booking.service.PricingService;

@RestController
@RequestMapping("/pricing")
public class PricingController {

    @Autowired
    private PricingService pricingService;

    @GetMapping("/update")
    public ResponseEntity<Integer> getUpdatedPrice(
            @RequestParam int roomId,
            @RequestParam int demandFactor) {

        int newPrice = pricingService.getUpdatedPrice(roomId, demandFactor);
        return ResponseEntity.ok(newPrice);
    }
}
