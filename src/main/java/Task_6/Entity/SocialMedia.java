package Task_6.Entity;



import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "social_media")
@NoArgsConstructor
public class SocialMedia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;



    @ManyToMany(mappedBy =  "socialMedia", fetch = FetchType.LAZY)
    private List<User> users;

    public SocialMedia(String name) {
        this.name = name;
    }
}
