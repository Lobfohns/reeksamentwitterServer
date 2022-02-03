package reeksamentwitter.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Table(name="posts")
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String text;

    @Column
    private Date date;

    @ManyToOne
    @JoinColumn(name = "username_id")
    @Nullable
    private User user;

    @ManyToOne
    @JoinColumn(name = "hashtag_id")
    @Nullable
    private Hashtag hashtag;

    /*
    @JsonIgnore
    @ManyToMany
    @JoinColumn(name = "hashtag_id")
    private Set<Hashtag> hashtagsset;

    */
}
