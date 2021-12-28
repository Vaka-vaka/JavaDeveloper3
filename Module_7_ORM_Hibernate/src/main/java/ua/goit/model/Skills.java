package ua.goit.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "skills")
public class Skills {

    @Id
    private  Long id;
    @Column(name = "industry")
    private  String name;
    @Column(name = "level_skills")
    private String level_skills;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "group_to_user",
            joinColumns = {@JoinColumn(name = "group_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private List<Users> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel_skills() {
        return level_skills;
    }

    public void setLevel_skills(String level_skills) {
        this.level_skills = level_skills;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Skills{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level_skills='" + level_skills + '\'' +
                ", users=" + users +
                '}';
    }
}
