package org.launchcode.codingevents.models;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Event extends AbstractEntity{

    @NotBlank(message = "Name is required")
    @Size(min= 3, max = 50, message = "Name must be between 3 and 50 characters.")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private EventDetails eventDetails;

    @NotNull(message = "Location is required")
    @NotBlank(message = "Location is required")
    private String location;
//    @NotEmpty(message = "Must be selected")
//    private Boolean isRegistrationRequired;
    @Positive(message="Number of attendees must be one or more.")
//    @NotBlank(message = "Number of Attendees is required!")
    private Integer numAttendees;


    @ManyToOne
    @NotNull(message = "Category is required.")
    private EventCategory eventCategory;

    @ManyToMany
    private final List<Tag> tags = new ArrayList<>();
    public Event(String name, String location, Integer numAttendees, EventCategory eventCategory) {

        this.name = name;
        this.location = location;
//        this.isRegistrationRequired = isRegistrationRequired;
        this.numAttendees = numAttendees;
        this.eventCategory = eventCategory;


    }

    public Event() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EventDetails getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
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

    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    public List<Tag> getTags(){
        return tags;
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
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


}
