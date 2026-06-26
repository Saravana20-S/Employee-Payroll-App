package com.epa.empAuthlogin;

public abstract class User {

    protected String username;
    protected String passwordHash;
    protected String role;

    public User(String username, String password, String role) {
        this.username = username;
        // Password is automatically hashed using your PasswordUtil class upon creation
        this.passwordHash = PasswordUtil.hash(password);
        this.role = role;
    }

    public abstract boolean authenticate(String username, String password);

    public String getRole() {
        return role;
    }
}
