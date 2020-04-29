package android.bachelor.weather.Models.GoogleModels;

public class NextPage {
    private String title;
    private String totalResults;
    private String searchTerms;
    private long count;
    private long startIndex;
    private String inputEncoding;
    private String outputEncoding;
    private String safe;
    private String cx;
    private String searchType;

    public String getTitle() { return title; }
    public void setTitle(String value) { this.title = value; }
    public String getTotalResults() { return totalResults; }
    public void setTotalResults(String value) { this.totalResults = value; }
    public String getSearchTerms() { return searchTerms; }
    public void setSearchTerms(String value) { this.searchTerms = value; }
    public long getCount() { return count; }
    public void setCount(long value) { this.count = value; }
    public long getStartIndex() { return startIndex; }
    public void setStartIndex(long value) { this.startIndex = value; }
    public String getInputEncoding() { return inputEncoding; }
    public void setInputEncoding(String value) { this.inputEncoding = value; }
    public String getOutputEncoding() { return outputEncoding; }
    public void setOutputEncoding(String value) { this.outputEncoding = value; }
    public String getSafe() { return safe; }
    public void setSafe(String value) { this.safe = value; }
    public String getCx() { return cx; }
    public void setCx(String value) { this.cx = value; }
    public String getSearchType() { return searchType; }
    public void setSearchType(String value) { this.searchType = value; }
}
