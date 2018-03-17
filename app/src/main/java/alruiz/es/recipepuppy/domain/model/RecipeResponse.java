package alruiz.es.recipepuppy.domain.model;

import java.util.List;

/**
 * Model class por RecipeResponse.
 */
public class RecipeResponse {

    private String title;
    private float version;
    private String href;
    private List<Recipe> results = null;

    public RecipeResponse(String title, float version, String href, List<Recipe> results) {
        this.title = title;
        this.version = version;
        this.href = href;
        this.results = results;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getVersion() {
        return version;
    }

    public void setVersion(float version) {
        this.version = version;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<Recipe> getResults() {
        return results;
    }

    public void setResults(List<Recipe> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "RecipeResponse{" +
                "title='" + title + '\'' +
                ", version=" + version +
                ", href='" + href + '\'' +
                ", results=" + results +
                '}';
    }
}
