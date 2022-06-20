package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Micah Young
 */
@Entity
public class EventCategory extends AbstractEntity{

    @NotBlank (message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @OneToMany(mappedBy = "eventCategory")
    private final List<Event> events  = new ArrayList<>();

    public EventCategory(String name) {
        this.name = name;
    }

    public EventCategory() {

    }

    public List<Event> getEvents() {
        return events;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "EventCategory{" +
                ", name='" + name + '\'' +
                '}';
    }
}

