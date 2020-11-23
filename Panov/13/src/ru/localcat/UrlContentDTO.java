package ru.localcat;

public class UrlContentDTO {
    private Integer contentSize = 0;
    private String content;

    public UrlContentDTO(Integer contentSize, String content) {
        this.contentSize = contentSize;
        this.content = content;
    }

    public Integer getContentSize() {
        return contentSize;
    }

    public String getContent() {
        return content;
    }
}
