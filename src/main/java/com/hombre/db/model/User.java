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
    private List<Role> roles;
    private Integer favoriteBookId;
    private Integer favoriteAccountId;
    private String birthdate;
    private String mailFrequency;

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
        this.roles = role;
    }

    public User(Integer userid, String username, String password, boolean enabled, List<Role> role, String birthdate) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.roles = role;
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", orphanRemoval=true)
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", orphanRemoval=true)
    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @Cascade({ CascadeType.REMOVE })
    @OnDelete(action = OnDeleteAction.CASCADE)
    public List<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Column(name = "favorite_book_id")
    public Integer getFavoriteBookId() {
        return favoriteBookId;
    }

    public void setFavoriteBookId(Integer favorite_book_id) {
        this.favoriteBookId = favorite_book_id;
    }

    @Column(name = "favorite_account_id")
    public Integer getFavoriteAccountId() {
        return favoriteAccountId;
    }

    public void setFavoriteAccountId(Integer favorite_account_id) {
        this.favoriteAccountId = favorite_account_id;
    }

    @Column(name = "birthdate")
    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    
    @Column(name = "mail_frequency")
    public String getMailFrequency() {
        return mailFrequency;
    }

    public void setMailFrequency(String mailFrequency) {
        this.mailFrequency = mailFrequency;
    }

}
