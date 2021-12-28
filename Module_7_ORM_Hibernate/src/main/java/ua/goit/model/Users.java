/**
 * Module 7. ORM.Hibernate
 *
 * @autor Valentin Mozul
 * @version of 16.12.2021
 */

package ua.goit.model;

import org.hibernate.annotations.NamedNativeQueries;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "getAll", query = "from Users"),
        @NamedQuery(name = "getByName", query = "from Users where name = :name")
})
public class Users {

    @Id
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "password")
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
