package com.test.retailsystem.model;
import com.test.retailsystem.enums.UserType;

import java.time.LocalDate;
import java.util.List;
public class User {
    private UserType userType;
    private LocalDate joiningDate;
    protected List<Item> items;

    public User(UserType userType, LocalDate joiningDate, List<Item> items) {
        this.userType = userType;
        this.joiningDate = joiningDate;
        this.items = items;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }


    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
