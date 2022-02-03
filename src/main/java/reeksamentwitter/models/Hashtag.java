package reeksamentwitter.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Table(name="hashtags")
@Entity
public class Hashtag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String hashtagName;

    @JsonIgnore
    @OneToMany(mappedBy = "hashtag", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Post> posts;

    /*
    @JsonIgnore
    @ManyToMany(mappedBy = "hashtagsset",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Post> posts;

     */

}
