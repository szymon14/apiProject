package pl.b2bnet.api.controller;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.b2bnet.api.Model.AudioTag;
import pl.b2bnet.api.service.ApiService;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class ApiControllerTest {
    @Autowired
    private ApiController apiController;

    @Test
    public void allTags() throws IOException {
        String uri = ApiService.uri;
        HttpUriRequest request = new HttpGet(uri);
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        assertThat(
                httpResponse.getStatusLine().getStatusCode(),
                equalTo(HttpStatus.SC_OK));
    }
}