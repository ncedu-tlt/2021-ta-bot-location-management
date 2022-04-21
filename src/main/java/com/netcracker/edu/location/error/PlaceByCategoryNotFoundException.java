package com.netcracker.edu.location.error;

public class PlaceByCategoryNotFoundException extends RuntimeException {
    public PlaceByCategoryNotFoundException() {
        super(String.format("No place(s) in this category"));
    }
}
