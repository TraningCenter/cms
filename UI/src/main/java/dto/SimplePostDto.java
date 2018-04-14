package dto;

public class SimplePostDto {

    public Long postId;

    public String author;

    public SimplePostDto(){

    }

    public SimplePostDto(Long postId, String author) {
        this.postId = postId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
