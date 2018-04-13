package dto;

public class PostDto {

    private String title;
    private String author;
    private String photo;
    private String post;

    public PostDto(){

    }

    public PostDto(String title, String author, String post) {
        this.title = title;
        this.author = author;
        this.post = post;
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
