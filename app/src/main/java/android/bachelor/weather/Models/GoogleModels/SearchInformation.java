package android.bachelor.weather.Models.GoogleModels;

public class SearchInformation {
    private double searchTime;
    private String formattedSearchTime;
    private String totalResults;
    private String formattedTotalResults;

    public double getSearchTime() { return searchTime; }
    public void setSearchTime(double value) { this.searchTime = value; }
    public String getFormattedSearchTime() { return formattedSearchTime; }
    public void setFormattedSearchTime(String value) { this.formattedSearchTime = value; }
    public String getTotalResults() { return totalResults; }
    public void setTotalResults(String value) { this.totalResults = value; }
    public String getFormattedTotalResults() { return formattedTotalResults; }
    public void setFormattedTotalResults(String value) { this.formattedTotalResults = value; }
}
