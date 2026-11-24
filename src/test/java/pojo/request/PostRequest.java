package pojo.request;


public class PostRequest {

    private String title;
    private String body;
    private int userId;

    // Default constructor
    public PostRequest() {
    }

    // Parameterized constructor
    public PostRequest(
            String title,
            String body,
            int userId) {

        this.title = title;
        this.body = body;
        this.userId = userId;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public int getUserId() {
        return userId;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}


