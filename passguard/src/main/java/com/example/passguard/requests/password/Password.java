package com.example.passguard.requests.password;

import java.util.Objects;

public class Password {
    private final String password;
    private final String login;

    public Password(String password, String login) {
        this.password = password;
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password password1 = (Password) o;
        return Objects.equals(password, password1.password) && Objects.equals(login, password1.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password, login);
    }
}
