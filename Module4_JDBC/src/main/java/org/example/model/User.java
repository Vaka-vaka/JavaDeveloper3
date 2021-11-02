/**
 * JavaDeveloper3. Module 4. JDBC
 *
 *  @autor Valentin Mozul
 *  @version of 02.11.2021
 */

package org.example.model;

public class User {
    private long id;
    private String name;
    private String description;

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
}
