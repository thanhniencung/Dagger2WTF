package thenextapp.dagger2wtf.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Sandy on 11/4/15.
 */
public class Repository {

    @SerializedName("id")
    public String id;

    @SerializedName("name")
    public String name;

    @SerializedName("url")
    public String url;

    @SerializedName("forks_count")
    public String forks_count;

    @SerializedName("watchers")
    public String watchers;

    @SerializedName("open_issues")
    public String open_issues;
}
