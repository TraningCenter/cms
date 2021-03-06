package util;

import javax.ejb.Stateful;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;
import dto.ContentDto;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;

@Stateful
public class PMConnector {

    //public static final String PMUrl = RequestPathFinder.getPath() + "/pm/";

    public String addUser(String username) throws IOException {
        String url = RequestPathFinder.getPath() + "/pm/" + "addUser";
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        StringEntity stringEntity = new StringEntity(username);
        post.setEntity(stringEntity);
        post.setHeader("Content-type", "application/json");
        httpClient.execute(post);

        String getUrl = RequestPathFinder.getPath() + "/pm/" + "get/" + username;
        HttpGet get = new HttpGet(getUrl);
        HttpResponse response = httpClient.execute(get);
        ResponseHandler<String> handler = new BasicResponseHandler();
        String body = handler.handleResponse(response);
        return body;
    }

    public String addPostToUser(String userId) throws IOException {
        String url = RequestPathFinder.getPath() + "/pm/" + "addPostToUser/" + userId;
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        StringEntity stringEntity = new StringEntity(userId);
        post.setEntity(stringEntity);
        post.setHeader("Content-type", "application/json");
        HttpResponse response = httpClient.execute(post);
        ResponseHandler<String> handler = new BasicResponseHandler();
        return handler.handleResponse(response);
    }

    public String getUserByUsername(String username) throws IOException{
        HttpClient httpClient = HttpClientBuilder.create().build();
        String getUrl = RequestPathFinder.getPath() + "/pm/" + "get/" + username;
        HttpGet get = new HttpGet(getUrl);
        HttpResponse response = httpClient.execute(get);
        ResponseHandler<String> handler = new BasicResponseHandler();
        return handler.handleResponse(response);
    }

    public String getUserPostsByUserId(String userId) throws IOException{
        HttpClient httpClient = HttpClientBuilder.create().build();
        String getUrl = RequestPathFinder.getPath() + "/pm/" + userId;
        HttpGet get = new HttpGet(getUrl);
        HttpResponse response = httpClient.execute(get);
        ResponseHandler<String> handler = new BasicResponseHandler();
        String body = handler.handleResponse(response);
        return body;
    }

    public String getAllPosts() throws IOException{
        HttpClient httpClient = HttpClientBuilder.create().build();
        String getUrl = RequestPathFinder.getPath() + "/pm/"+ "getAll";
        HttpGet get = new HttpGet(getUrl);
        HttpResponse response = httpClient.execute(get);
        ResponseHandler<String> handler = new BasicResponseHandler();
        String body = handler.handleResponse(response);
        return body;
    }

    public String getPostByPostId(String postId) throws IOException{
        HttpClient httpClient = HttpClientBuilder.create().build();
        String getUrl = RequestPathFinder.getPath() + "/pm/"+ "/getPost/"+ postId;
        HttpGet get = new HttpGet(getUrl);
        HttpResponse response = httpClient.execute(get);
        ResponseHandler<String> handler = new BasicResponseHandler();
        String body = handler.handleResponse(response);
        return body;
    }
}
