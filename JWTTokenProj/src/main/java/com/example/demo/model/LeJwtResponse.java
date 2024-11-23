package com.example.demo.model;

import org.springframework.context.annotation.Configuration;

import lombok.Builder;

@Configuration
public class LeJwtResponse {
	
	private String jwtToken;
    private String username;

    // Private constructor to prevent direct instantiation
    private LeJwtResponse(LeJwtResponseBuilder builder) {
        this.jwtToken = builder.jwtToken;
        this.username = builder.username;
    }

    // Static nested Builder class
    public static class LeJwtResponseBuilder {
        private String jwtToken;
        private String username;

        public LeJwtResponseBuilder setJwtToken(String jwtToken) {
            this.jwtToken = jwtToken;
            return this;
        }

        public LeJwtResponseBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public LeJwtResponse build() {
            return new LeJwtResponse(this);
        }
    }

    // Getters and setters
    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Default constructor
    public LeJwtResponse() {
        super();
    }

    // Parameterized constructor
    public LeJwtResponse(String jwtToken, String username) {
        super();
        this.jwtToken = jwtToken;
        this.username = username;
    }

    @Override
    public String toString() {
        return "LeJwtResponse [jwtToken=" + jwtToken + ", username=" + username + "]";
    }

	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}

}
