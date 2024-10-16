package fr.charly.mampuyaExam.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.charly.mampuyaExam.json_views.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.JSONArray;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class User implements UserDetails  {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonView(JsonViews.UserShow.class)
    private String id;

    @Column(nullable = false)
    @JsonView(JsonViews.UserShow.class)
    private String username;

    @Column(nullable = false)
    @JsonView(JsonViews.UserShow.class)
    private String email;

    @Column(nullable = false)
    private String password;

    @JsonView(JsonViews.UserShow.class)
    private String avatar = null;

    @JsonView(JsonViews.UserShow.class)
    private LocalDate birthedAt;

    @JsonView(JsonViews.UserShow.class)
    private LocalDateTime createdAt;

    @JsonView(JsonViews.UserShow.class)
    private Integer level = 1;

    private String roles;

    @OneToMany(mappedBy = "user")
    private List<Game> games = new ArrayList<>();



    @JsonView(JsonViews.UserShow.class)
    public boolean isAdmin() {
        return roles.contains("ROLE_ADMIN");
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        JSONArray roles = new JSONArray(this.roles);
        roles.forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.toString()));
        });
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}