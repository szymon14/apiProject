package pl.b2bnet.api.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;
import pl.b2bnet.api.Model.AudioTag;

import java.io.IOException;

import static org.junit.Assert.*;

public class AudioControllerTest {

    @Test
    public void sumAllMetal() throws IOException {
        String uri = "http://localhost:8080/metals";
        HttpUriRequest request = new HttpGet(uri);

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        String jsonFromResponse = EntityUtils.toString(httpResponse.getEntity());

        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        AudioTag response = mapper.readValue(jsonFromResponse, AudioTag.class);

        Assert.assertTrue(response.getName().equals("metal"));

    }

    @Test
    public void aboveValue() throws IOException {
        String uri = "http://localhost:8080/aboveValue/1000000";
        HttpUriRequest request = new HttpGet(uri);
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        String jsonFromResponse = EntityUtils.toString(httpResponse.getEntity());
        Assert.assertNotNull(jsonFromResponse);
    }

    @Test
    public void compareTags() throws IOException {
        String uri = "http://localhost:8080/tagsCompare/electronic/Hip-Hop";
        HttpUriRequest request = new HttpGet(uri);
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        String response = EntityUtils.toString(httpResponse.getEntity());
        Assert.assertEquals(response,"electronic 2347989 > Hip-Hop 848104");
    }

    @Test
    public void names() throws IOException {
        String uri = "http://localhost:8080/names";
        HttpUriRequest request = new HttpGet(uri);
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        String jsonFromResponse = EntityUtils.toString(httpResponse.getEntity());
        Assert.assertNotNull(jsonFromResponse);
    }
}