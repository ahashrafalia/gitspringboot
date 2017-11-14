package com.gitspringboot.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;
    
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "username")
    private String username;
    
    
    @OneToMany(mappedBy="users",targetEntity=UserRole.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserRole> roles;

    public Users() {
    }

    public Users(Users users) {
        this.roles = users.getRoles();
        this.username = users.getUsername();
        this.id = users.getId();
        this.password = users.getPassword();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }
}
