package util;

import javax.ejb.Stateful;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
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

    public static final String PMUrl = "http://localhost:8080/pm/";

    public String sentGet(String val) throws IOException {
        String url = PMUrl + val;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    public String addUser(String username) throws IOException {
        String url = "http://localhost:8080/pm/addUser";
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        StringEntity stringEntity = new StringEntity(username);
        post.setEntity(stringEntity);
        post.setHeader("Content-type", "application/json");
        httpClient.execute(post);

        String getUrl = "http://localhost:8080/pm/get/" + username;
        HttpGet get = new HttpGet(getUrl);
        HttpResponse response = httpClient.execute(get);
        ResponseHandler<String> handler = new BasicResponseHandler();
        String body = handler.handleResponse(response);
        return body;
    }

    public String addPostToUser(String userId) throws IOException {
        String url = "http://localhost:8080/pm/addPostToUser/" + userId;
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        StringEntity stringEntity = new StringEntity(userId);
        post.setEntity(stringEntity);
        post.setHeader("Content-type", "application/json");
        HttpResponse response = httpClient.execute(post);
        ResponseHandler<String> handler = new BasicResponseHandler();
        return handler.handleResponse(response);
    }

    public void sendPost() throws IOException {
        /*
        String url = "http://localhost:8080/pm/";
        Gson gson = new Gson();
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        StringEntity postingString = new StringEntity(gson.toJson());
        post.setEntity(postingString);
        post.setHeader("Content-type", "application/json");
        HttpResponse response = httpClient.execute(post);
        */
    }
}
