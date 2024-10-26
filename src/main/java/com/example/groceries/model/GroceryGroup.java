package com.example.groceries.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GroceryGroup {
    private String name;
    private LocalDate date; // Change from String to LocalDate
    private int visitCount;

    public GroceryGroup(String name, LocalDate date) { // Constructor updated
        this.name = name;
        this.date = date;
        this.visitCount = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) { // Setter updated
        this.date = date;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void incrementVisitCount() {
        this.visitCount++;
    }

    // Method to get formatted date as a string
    public String getFormattedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        return date.format(formatter);
    }
}
