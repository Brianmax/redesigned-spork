package com.example.spring_2.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReniecResponse {
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("first_last_name")
    private String firstLastName;
    @JsonProperty("second_last_name")
    private String secondLastName;
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("document_number")
    private String documentNumber;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }
}
