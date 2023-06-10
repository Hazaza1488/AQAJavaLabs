package Task_6.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "device")
@NoArgsConstructor
//Install MySQL server
//        Make at least two tables (Entities from previous task or any additional if need)
//        Make models for those Entities (from Task_5)
//        Setup Hibernate for those Entities and local DB
//        Check basic CRUD (create, read, update, delete the BD records using Hibernate)
//        Generate few rows into all tabled

public class Device implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Device(String name) {
        this.name = name;
    }
}
