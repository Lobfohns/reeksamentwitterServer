package reeksamentwitter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reeksamentwitter.models.Post;
import reeksamentwitter.repositories.PostRepository;
import java.util.List;

@RestController
public class Posts {
    @Autowired
    PostRepository posts;

    @GetMapping("/posts")
    public Iterable<Post> getPosts(){
        return posts.findAll();
    }

    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable Long id) {
        return posts.findById(id).get();
    }

    /* Something I tried to get to work with ManyToMany and never ended up using. Not sure if I should include it?
    @GetMapping("/posts/hashtag/{hashtagId}")
    public List<Post> getPostsByHashtagId(@PathVariable Long hashtagId) {
        return posts.findPostsByHashtag(hashtagId);
    }
     */

    @PostMapping("/posts")
    public Post addPost(@RequestBody Post newPost) {
        newPost.setId(null);
        return posts.save(newPost);
    }

    @PatchMapping("/posts/{id}")
    public String patchPostById(@PathVariable Long id, @RequestBody Post postToUpdate) {
        return posts.findById(id).map( foundPost -> {
            if(postToUpdate.getText() != null) foundPost.setText(postToUpdate.getText());
            if(postToUpdate.getDate() != null) foundPost.setDate(postToUpdate.getDate());
            if(postToUpdate.getUser() != null) foundPost.setUser(postToUpdate.getUser());
            if(postToUpdate.getHashtag() != null) foundPost.setHashtag(postToUpdate.getHashtag());
            posts.save(foundPost);
            return "Post updated";
        }).orElse("Post not found");
    }

    @DeleteMapping("/posts/{id}")
    public void deletePostsById(@PathVariable Long id) {
        posts.deleteById(id);
    }
}
