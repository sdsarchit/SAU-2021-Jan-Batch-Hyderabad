package com.asr.restApi.Entity;


import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String emailId;

    @Column
    private String password;

    @OneToMany(mappedBy = "userId", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<PrivateMessage> privateMessages;

    public User(String emailId, String password){
        this.emailId = emailId;
        this.password = password;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<PrivateMessage> getPrivateMessages() {
		return privateMessages;
	}

	public void setPrivateMessages(Set<PrivateMessage> privateMessages) {
		this.privateMessages = privateMessages;
	}
    
}
