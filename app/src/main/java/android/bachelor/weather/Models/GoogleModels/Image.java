package android.bachelor.weather.Models.GoogleModels;

import java.io.Serializable;

public class Image implements Serializable {
    private String contextLink;
    private long height;
    private long width;
    private long byteSize;
    private String thumbnailLink;
    private long thumbnailHeight;
    private long thumbnailWidth;

    public String getContextLink() { return contextLink; }
    public void setContextLink(String value) { this.contextLink = value; }
    public long getHeight() { return height; }
    public void setHeight(long value) { this.height = value; }
    public long getWidth() { return width; }
    public void setWidth(long value) { this.width = value; }
    public long getByteSize() { return byteSize; }
    public void setByteSize(long value) { this.byteSize = value; }
    public String getThumbnailLink() { return thumbnailLink; }
    public void setThumbnailLink(String value) { this.thumbnailLink = value; }
    public long getThumbnailHeight() { return thumbnailHeight; }
    public void setThumbnailHeight(long value) { this.thumbnailHeight = value; }
    public long getThumbnailWidth() { return thumbnailWidth; }
    public void setThumbnailWidth(long value) { this.thumbnailWidth = value; }
}
