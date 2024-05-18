package NewsFeed;

import java.time.Instant;

public class NewsfeedEntity {
//    HashMap<String, String> =
    String id;
    String postTimeISO;
    Instant postDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPostTimeISO() {
        return postTimeISO;
    }

    public void setPostTimeISO(String postTimeISO) {
        this.postTimeISO = postTimeISO;
    }

    public Instant getPostDate() {
        return postDate;
    }

    public void setPostDate(Instant postDate) {
        this.postDate = postDate;
    }

    public NewsfeedEntity(String id, String postTimeISO) {
        this.postTimeISO = postTimeISO;
        this.id = id;
        this.postDate = Instant.parse(postTimeISO);
    }

}
