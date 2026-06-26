package com.epa.empAuthlogin;

public class RegularEmployee extends User {

    public RegularEmployee(String username, String password) {
        // Calls the abstract parent (User) constructor and assigns the "EMPLOYEE" role
        super(username, password, "EMPLOYEE");
    }


    @Override
    public boolean authenticate(String username, String password) {
        // Checks if username matches and the hashed input password matches the stored password hash
        return this.username.equals(username) &&
                PasswordUtil.hash(password).equals(this.passwordHash);
    }
}
