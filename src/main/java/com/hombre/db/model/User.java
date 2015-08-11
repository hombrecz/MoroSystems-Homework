package com.hombre.db.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = { "userid", "username" }))
public class User {

    private Integer userid;
    private String username;
    private String password;
    private boolean enabled;
    private List<Book> books;
    private List<Account> accounts;
    private List<Role> role;
    private Integer favorite_book_id;
    private Integer favorite_account_id;
    private String birthdate;

    public User() {}

    public User(Integer userid, String username, String password, boolean enabled) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public User(Integer userid, String username, String password, boolean enabled, List<Role> role) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.role = role;
    }

    public User(Integer userid, String username, String password, boolean enabled, List<Role> role, String birthdate) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.role = role;
        this.birthdate = birthdate;
    }

    @Id
    @NotNull
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "userid", unique = true)
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 50)
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 50)
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull
    @Column(name = "enabled")
    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @Cascade({ CascadeType.REMOVE })
    @OnDelete(action = OnDeleteAction.CASCADE)
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @Cascade({ CascadeType.REMOVE })
    @OnDelete(action = OnDeleteAction.CASCADE)
    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @Cascade({ CascadeType.REMOVE })
    @OnDelete(action = OnDeleteAction.CASCADE)
    public List<Role> getRole() {
        return this.role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    @Column(name = "favorite_book_id")
    public Integer getFavorite_book_id() {
        return favorite_book_id;
    }

    public void setFavorite_book_id(Integer favorite_book_id) {
        this.favorite_book_id = favorite_book_id;
    }

    @Column(name = "favorite_account_id")
    public Integer getFavorite_account_id() {
        return favorite_account_id;
    }

    public void setFavorite_account_id(Integer favorite_account_id) {
        this.favorite_account_id = favorite_account_id;
    }

    @Column(name = "birthdate")
    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

}
