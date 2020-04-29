package android.bachelor.weather.Models.GoogleModels;

public class ImageSearch {
    private String kind;
    private URL url;
    private Queries queries;
    private Context context;
    private SearchInformation searchInformation;
    private Item[] items;

    public String getKind() { return kind; }
    public void setKind(String value) { this.kind = value; }
    public URL getURL() { return url; }
    public void setURL(URL value) { this.url = value; }
    public Queries getQueries() { return queries; }
    public void setQueries(Queries value) { this.queries = value; }
    public Context getContext() { return context; }
    public void setContext(Context value) { this.context = value; }
    public SearchInformation getSearchInformation() { return searchInformation; }
    public void setSearchInformation(SearchInformation value) { this.searchInformation = value; }
    public Item[] getItems() { return items; }
    public void setItems(Item[] value) { this.items = value; }
}
