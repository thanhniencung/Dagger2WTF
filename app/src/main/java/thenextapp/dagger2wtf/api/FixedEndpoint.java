package thenextapp.dagger2wtf.api;

import thenextapp.dagger2wtf.interfaces.Endpoint;

/**
 * Created by Sandy on 11/4/15.
 */
public class FixedEndpoint implements Endpoint {

    private String url;
    private String apiName;

    public FixedEndpoint(String url, String apiName) {
        this.url = url;
        this.apiName = apiName;
    }

    @Override
    public String getUrl() {
        return this.url;
    }

    @Override
    public String getName() {
        return this.apiName;
    }
}
