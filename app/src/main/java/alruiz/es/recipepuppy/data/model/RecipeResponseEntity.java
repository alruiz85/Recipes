package alruiz.es.recipepuppy.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Entity data class for a recipe response.
 */
public class RecipeResponseEntity {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("version")
    @Expose
    private float version;
    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("results")
    @Expose
    private List<RecipeEntity> results = null;

    public RecipeResponseEntity(String title, float version, String href, List<RecipeEntity> results) {
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

    public List<RecipeEntity> getResults() {
        return results;
    }

    public void setResults(List<RecipeEntity> results) {
        this.results = results;
    }

}
