package android.bachelor.weather.Models.GoogleModels;

import java.io.Serializable;

public class Item implements Serializable {
    private String kind;
    private String title;
    private String htmlTitle;
    private String link;
    private String displayLink;
    private String snippet;
    private String htmlSnippet;
    private String mime;
    private String fileFormat;
    private Image image;

    public String getKind() { return kind; }
    public void setKind(String value) { this.kind = value; }
    public String getTitle() { return title; }
    public void setTitle(String value) { this.title = value; }
    public String getHTMLTitle() { return htmlTitle; }
    public void setHTMLTitle(String value) { this.htmlTitle = value; }
    public String getLink() { return link; }
    public void setLink(String value) { this.link = value; }
    public String getDisplayLink() { return displayLink; }
    public void setDisplayLink(String value) { this.displayLink = value; }
    public String getSnippet() { return snippet; }
    public void setSnippet(String value) { this.snippet = value; }
    public String getHTMLSnippet() { return htmlSnippet; }
    public void setHTMLSnippet(String value) { this.htmlSnippet = value; }
    public String getMIME() { return mime; }
    public void setMIME(String value) { this.mime = value; }
    public String getFileFormat() { return fileFormat; }
    public void setFileFormat(String value) { this.fileFormat = value; }
    public Image getImage() { return image; }
    public void setImage(Image value) { this.image = value; }
}
