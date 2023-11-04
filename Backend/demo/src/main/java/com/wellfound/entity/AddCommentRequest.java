package com.wellfound.entity;

public class AddCommentRequest {
    private Long postId;  // The ID of the post to which the comment will be added
    private String text;  // The text of the comment
    private String username;

    // Getters and setters for postId and text

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
