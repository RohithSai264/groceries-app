package com.example.groceries.model;

public class GroceryUpdateRequest {
    private String groupName;
    private String visitDate;

    public GroceryUpdateRequest(String groupName, String visitDate) {
        this.groupName = groupName;
        this.visitDate = visitDate;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }
}
