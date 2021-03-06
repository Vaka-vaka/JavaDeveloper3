package ua.goit.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "developers")
public class Developers {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name_")
    private String name_;
    @Column(name = "age")
    private long age;
    @Column(name = "gender")
    private String gender;
    @Column(name = "salary")
    private int salary;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.ALL, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(
            name = "developers_skills",
            joinColumns = { @JoinColumn(name = "dev_id") },
            inverseJoinColumns = { @JoinColumn(name = "skills_id") }
    )
    private List<Skills> skills = new ArrayList<>();

//    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.ALL, CascadeType.PERSIST, CascadeType.REFRESH},
//            fetch = FetchType.EAGER)
//    @Fetch(value = FetchMode.SUBSELECT)
//    @JoinTable(
//            name = "developers_projects",
//            joinColumns = { @JoinColumn(name = "dev_id") },
//            inverseJoinColumns = { @JoinColumn(name = "projects_id") }
//    )
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private transient List<Projects> projects = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Developers{" +
                "id=" + id +
                ", name_='" + name_ + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", skills=" + skills +
                '}';
    }
}
