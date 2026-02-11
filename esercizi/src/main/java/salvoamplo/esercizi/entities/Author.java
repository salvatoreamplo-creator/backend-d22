package salvoamplo.esercizi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String surname;
    private String email;

    public Author() {
    }

    public Author(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}