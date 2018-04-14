package dto;

import java.util.List;

public class PostDto {

    private String id;
    private String title;
    private String author;
    private String photo;
    private List<String> post;

    public PostDto(){

    }

    public PostDto(String title, String author, List<String> post) {
        this.title = title;
        this.author = author;
        this.post = post;
    }

    public PostDto(String id, String title, String author, List<String> post) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.post = post;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<String> getPost() {
        return post;
    }

    public void setPost(List<String> post) {
        this.post = post;
    }
}
