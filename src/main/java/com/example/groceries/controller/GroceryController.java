package com.example.groceries.controller;

import com.example.groceries.model.GroceryGroup;
import com.example.groceries.service.GroceryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class GroceryController {

    private final GroceryService groceryService;

    public GroceryController(GroceryService groceryService) {
        this.groceryService = groceryService;
    }

    @GetMapping("/")
    public String showGroceriesPage(Model model) {
        List<GroceryGroup> grocerySchedule = groceryService.getGrocerySchedule();
        List<String> updateRequests = groceryService.getUpdateRequests();

        model.addAttribute("grocerySchedule", grocerySchedule);
        model.addAttribute("updateRequests", updateRequests);
        return "index"; // Update to match the new file name
    }

    @PostMapping("/groceries/update")
    public String addUpdateRequest(@RequestParam("group") String group,
                                   @RequestParam("date") String date,
                                   Model model) {
        // Parse the date string to LocalDate
        LocalDate localDate = LocalDate.parse(date);

        // Format the date to "Month Date, Year"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        String formattedDate = localDate.format(formatter);

        String request = "Update request for " + group + " on " + formattedDate;
        boolean isAdded = groceryService.addUpdateRequest(request);

        // Check if the request was added successfully
        if (!isAdded) {
            model.addAttribute("errorMessage", "Maximum of 3 update requests allowed.");
        }

        // Populate the model with current data
        model.addAttribute("grocerySchedule", groceryService.getGrocerySchedule());
        model.addAttribute("updateRequests", groceryService.getUpdateRequests());

        // Return the updated model and renamed template
        return "index"; // Update to match the new file name
    }
}
