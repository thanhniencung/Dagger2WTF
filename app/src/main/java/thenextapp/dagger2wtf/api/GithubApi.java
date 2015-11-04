package thenextapp.dagger2wtf.api;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Headers;
import rx.Observable;
import thenextapp.dagger2wtf.models.Repository;

/**
 * Created by Sandy on 11/4/15.
 */
public interface GithubApi {
    @GET("/users/google/repos")
    @Headers("User-Agent: ThanhNienCung")
    Observable<List<Repository>> getAllRepositories();
}
