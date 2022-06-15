package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity

public class Event {
    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Name is required")
    @Size(min= 3, max = 50, message = "Name must be between 3 and 50 characters.")
    private String name;

    @Size(max = 500, message = "Description too long!")
    private String description;
    @NotBlank
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    @NotNull(message = "Location is required")
    @NotBlank(message = "Location is required")
    private String location;
//    @NotEmpty(message = "Must be selected")
//    private Boolean isRegistrationRequired;
    @Positive(message="Number of attendees must be one or more.")
//    @NotBlank(message = "Number of Attendees is required!")
    private Integer numAttendees;

    public Event(String name, String description, String contactEmail, String location, Integer numAttendees) {

        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
//        this.isRegistrationRequired = isRegistrationRequired;
        this.numAttendees = numAttendees;

    }

    public Event() {
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getNumAttendees() {
        return numAttendees;
    }

    public void setNumAttendees(int numAttendees) {
        this.numAttendees = numAttendees;
    }

//    public Boolean getIsRegistrationRequired() {
//        return isRegistrationRequired;
//    }
//
//    public void setIsRegistrationRequired(Boolean registrationRequired) {
//        isRegistrationRequired = registrationRequired;
//    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
