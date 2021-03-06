package com.simongirard.innso.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String clientName;
    private String content;

    /**
     * Adapted in a simple case, where we dont modify Enum values.
     */
    @Enumerated(EnumType.STRING)
    private Channel channel;

    @ManyToOne
    @JoinColumn(name = "customer_file_id")
    private CustomerFile customerFile;

    public Message(){

    }

    public Message(String clientName, String content, Channel channel) {
        this.clientName = clientName;
        this.content = content;
        this.channel = channel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public CustomerFile getCustomerFile() {
        return customerFile;
    }

    public void setCustomerFile(CustomerFile customerFile) {
        this.customerFile = customerFile;
    }
}
