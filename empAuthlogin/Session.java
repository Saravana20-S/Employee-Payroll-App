package com.epa.empAuthlogin;

public class Session {

    private String username;
    private long loginTime;
    private long timeoutMillis;

    public Session(String username) {
        this.username = username;
        // Record the current time in milliseconds when the session is created
        this.loginTime = System.currentTimeMillis();
        // Set a default timeout duration (e.g., 5 minutes = 300,000 milliseconds)
        this.timeoutMillis = 5 * 60 * 1000;
    }


    public boolean isExpired() {
        long currentTime = System.currentTimeMillis();
        // The session is expired if the elapsed time exceeds our timeout threshold
        return (currentTime - loginTime) > timeoutMillis;
    }

    @Override
    public String toString() {
        return "Session active for user: " + username;
    }
}