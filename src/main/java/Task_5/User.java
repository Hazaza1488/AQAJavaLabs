package Task_5;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class User implements Serializable, Comparable<User> {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("fruits")
    private List<String> fruits;

    @JsonIgnore
    private String uuid;

    public User() {
        setUuid(UUID.randomUUID().toString());
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getFruits() {
        return fruits;
    }

    public void setFruits(List<String> fruits) {
        this.fruits = fruits;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fruits=" + fruits +
                ", uuid='" + uuid + '\'' +
                '}';
    }

    @Override
    public int compareTo(User otherUser) {
        return this.name.compareTo(otherUser.getName());
    }
}
