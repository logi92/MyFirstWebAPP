package app.entities;

import java.util.Objects;

public class User {
    int id, age;
    String name, language;

    public User() {
    }

    public User(int age, String name, String language) {
        this.age = age;
        this.name = name;
        this.language = language;
    }

    public User(int id, int age, String name, String language) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId() == user.getId() &&
                getAge() == user.getAge() &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getLanguage(), user.getLanguage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAge(), getName(), getLanguage());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
