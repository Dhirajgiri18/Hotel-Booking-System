package com.hotel.booking.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

@Service
public class PricingService {

    private static final String PRICING_ENGINE_PATH = "./pricing_engine.exe";

    public int getUpdatedPrice(int roomId, int demandFactor) {
        try {
            // Run the C++ executable with roomId and demandFactor as arguments
            ProcessBuilder processBuilder = new ProcessBuilder(PRICING_ENGINE_PATH,
                    String.valueOf(roomId),
                    String.valueOf(demandFactor));
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            // Read output from C++ program
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String output = reader.readLine();
            process.waitFor();

            return Integer.parseInt(output); // Return the new price
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Return an error code
        }
    }
}
