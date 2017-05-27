package io.automation.data.hibernate;

import javax.persistence.*;

@Entity
@Table(name = "process_instance")
public class ProcessInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Transient
    private User initiator;

    public ProcessInstance() {
    }

    public ProcessInstance(String name, String description, User initiator) {
        this.initiator = initiator;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public User getInitiator() {
        return initiator;
    }


    public void setInitiator(User user) {
        this.initiator = user;
    }

    @Column(name = "initiator")
    public Integer getInitiatorId(){
        return this.initiator.getId();
    }

    @Override
    public String toString() {
        return "ProcessInstance: " + this.id + ", " + this.name + ", " + this.description;
    }

}
