package com.dev.producer.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "users")
public class Users {
	
	//name, email, password, confirm password
	
	 @Id
	 @Column
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	
	    private  String name;
	   
	    private  String password;
	    
	    private  String email;
	    
	    private  String confirmPassword;
	    
	    private  boolean loggedIn;
	    
	    private String token;
	    
	    @Column(columnDefinition = "TIMESTAMP")
	    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
		private LocalDateTime tokenCreationDate;
	    
	    public Users() {
	    }
	    public Users(String name, 
	                 String password) {
	        this.name = name;
	        this.password = password;
	        this.loggedIn = false;
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
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getConfirmPassword() {
			return confirmPassword;
		}
		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}
		public boolean isLoggedIn() {
			return loggedIn;
		}
		public void setLoggedIn(boolean loggedIn) {
			this.loggedIn = loggedIn;
		}
		public String getToken() {
			return token;
		}
		public void setToken(String token) {
			this.token = token;
		}
		public LocalDateTime getTokenCreationDate() {
			return tokenCreationDate;
		}
		public void setTokenCreationDate(LocalDateTime tokenCreationDate) {
			this.tokenCreationDate = tokenCreationDate;
		}
		
		@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof Users)) return false;
	        Users user = (Users) o;
	        return Objects.equals(name, user.name) &&
	                Objects.equals(password, user.password);
	    }
		
	    @Override
	    public int hashCode() {
	        return Objects.hash(id, name, password, 
	                            loggedIn);
	    }
		@Override
		public String toString() {
			return "User [id=" + id + ", username=" + name + ", password=" + password + ", email=" + email
					+ ", mobileNum=" + confirmPassword + ", loggedIn=" + loggedIn + ", token=" + token
					+ ", tokenCreationDate=" + tokenCreationDate + "]";
		}
	    

}
