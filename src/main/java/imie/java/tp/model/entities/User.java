package imie.java.tp.model.entities;

import imie.java.tp.model.Identifiable;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Identifiable<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "hashpass", nullable = false)
    private String hashpass;

    @Column(name = "hashsalt", nullable = false)
    private String hashsalt;

    @Column(name = "active", nullable = false)
    private boolean active;

    @ManyToMany
    @JoinTable(name = "dashboard", joinColumns = {
            @JoinColumn(name = "user_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "chart_id", nullable = false, updatable = false) })
    private Set<Chart> charts;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashpass() {
        return hashpass;
    }

    public void setHashpass(String hashpass) {
        this.hashpass = hashpass;
    }

    public String getHashsalt() {
        return hashsalt;
    }

    public void setHashsalt(String hashsalt) {
        this.hashsalt = hashsalt;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
