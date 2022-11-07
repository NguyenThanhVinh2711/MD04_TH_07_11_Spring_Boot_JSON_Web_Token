package com.codegym.thspringbootjsonwebtokenjwt.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"roles","authorities"})
//@Constructor
@Getter
@Setter
public class User {
    private int id;
    private String username;
    private String password;

    public User() {
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(int id, String username, String password, String[] roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    private String[] roles;
    public List<GrantedAuthority> getAuthorities(){
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles){
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
