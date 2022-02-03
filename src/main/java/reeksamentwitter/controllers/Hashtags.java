package reeksamentwitter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reeksamentwitter.models.Hashtag;
import reeksamentwitter.repositories.HashtagRepository;

@RestController
public class Hashtags {

    @Autowired
    HashtagRepository hashtags;

    @GetMapping("/hashtags")
    public Iterable<Hashtag> getHashtags(){
        return hashtags.findAll();
    }

    @GetMapping("/hashtags/{id}")
    public Hashtag getHashtag(@PathVariable Long id) {
        return hashtags.findById(id).get();
    }

    @PostMapping("/hashtags")
    public Hashtag addHashtag(@RequestBody Hashtag newHashtag) {
        newHashtag.setId(null);
        return hashtags.save(newHashtag);
    }

    @PatchMapping("/hashtags/{id}")
    public String patchHashtagById(@PathVariable Long id, @RequestBody Hashtag hashtagToUpdate) {
        return hashtags.findById(id).map( foundHashtag -> {
            if(hashtagToUpdate.getHashtagName() != null) foundHashtag.setHashtagName(hashtagToUpdate.getHashtagName());
            hashtags.save(foundHashtag);
            return "Hashtag updated";
        }).orElse("Hashtag not found");
    }

    @DeleteMapping("/hashtags/{id}")
    public void deleteHashtagsById(@PathVariable Long id) {
        hashtags.deleteById(id);
    }
}

