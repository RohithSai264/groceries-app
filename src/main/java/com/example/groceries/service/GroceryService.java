package com.example.groceries.service;

import com.example.groceries.model.GroceryGroup;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

@Service
public class GroceryService {

    private final List<GroceryGroup> groups;
    private final List<String> updateRequests;

    public GroceryService() {
        groups = new ArrayList<>();
        updateRequests = new ArrayList<>();
        clearUpdateRequests();
        LocalDate today = LocalDate.now();

        // Initialize groups with LocalDate
        groups.add(new GroceryGroup("Basement Boys", today.with(TemporalAdjusters.next(DayOfWeek.SUNDAY))));
        groups.add(new GroceryGroup("Rohith Kancheti", today.plusWeeks(1).with(TemporalAdjusters.next(DayOfWeek.SUNDAY))));
        groups.add(new GroceryGroup("Kansas Boys", today.plusWeeks(2).with(TemporalAdjusters.next(DayOfWeek.SUNDAY))));
        groups.add(new GroceryGroup("Katepalli Group", today.plusWeeks(3).with(TemporalAdjusters.next(DayOfWeek.SUNDAY))));
    }

    public boolean addUpdateRequest(String request) {
        if (updateRequests.size() < 3) {
            updateRequests.add(request);
            return true;
        }
        return false;
    }

    public void clearUpdateRequests() {
        updateRequests.clear(); // Manually clear the list of update requests
    }

    public List<String> getUpdateRequests() {
        return updateRequests;
    }

    public List<GroceryGroup> getGrocerySchedule() {
        return groups;
    }
}
