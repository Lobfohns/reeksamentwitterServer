package reeksamentwitter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reeksamentwitter.models.User;
import reeksamentwitter.repositories.UserRepository;

@RestController
public class Users {

    @Autowired
    UserRepository users;


    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return users.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        return users.findById(id).get();
    }


    @PostMapping("/users")
    public User addUser(@RequestBody User newUser) {
        newUser.setId(null);
        return users.save(newUser);
    }

    @PatchMapping("/users/{id}")
    public String patchUsersById(@PathVariable Long id, @RequestBody User userToUpdate) {
        return users.findById(id).map( foundUser -> {
            if(userToUpdate.getUsername() != null) foundUser.setUsername(userToUpdate.getUsername());
            if(userToUpdate.getUserDescription() != null) foundUser.setUserDescription(userToUpdate.getUserDescription());
            users.save(foundUser);
            return "Post updated";
        }).orElse("Post not found");
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {users.deleteById(id);
    }
}
