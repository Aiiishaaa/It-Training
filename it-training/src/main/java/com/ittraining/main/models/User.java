package com.ittraining.main.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NaturalId;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String firstname;
    private String username;
    @NaturalId
    @Size(max = 50)
    @Email
    private String email;
    @Size(min = 6, max = 100)
    @JsonIgnore
    private String password;
    private String phone;
    @Transient
    private Collection<? extends GrantedAuthority> authorities;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_num"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    
    @JsonIgnore
	@ManyToMany(mappedBy = "users")
	private List<Session> sessions = new ArrayList<Session>();
    
    @JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Formation> formations = new ArrayList<Formation>();

    public User() {
    }

    public User(String name, String username, String email, String password) {

        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;

    }

    public User(String name, String firstname, String username, String email, String password, Collection<? extends GrantedAuthority> authorities, String phone) {
        this.name = name;
        this.firstname = firstname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.phone = phone;
    }

    public User(@NotBlank @Size(min = 3, max = 50) String username,
                @NotBlank @Size(min = 6, max = 100) String password, Collection<? extends GrantedAuthority> authorities) {
        super();
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
    
	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", firstname=" + firstname + ", username=" + username + ", email="
				+ email + ", password=" + password + ", phone=" + phone + ", authorities=" + authorities + ", roles="
				+ roles + ", sessions=" + sessions + ", formations=" + formations + "]";
	}
    
    
}