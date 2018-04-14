package util;

import com.google.gson.Gson;
import dto.ContentDto;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.ejb.Stateful;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Stateful
public class CMConnector {

    //public static final String CMUrl = RequestPathFinder.getPath() + "/cm/";

    public void addContentToPost(ContentDto contentDto) throws IOException {
        try {

            Gson gson = new Gson();
            String url = RequestPathFinder.getPath() + "/cm/" + "addContent";
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost(url);
            String content = gson.toJson(contentDto);
            StringEntity stringEntity = new StringEntity(content);
            post.setEntity(stringEntity);
            post.setHeader("Content-type", "application/json");
            HttpResponse response = httpClient.execute(post);
            ResponseHandler<String> handler = new BasicResponseHandler();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public String getContentByPostId(String postId) throws IOException {

        String url = RequestPathFinder.getPath() + "/cm/" + postId;
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(url);
        StringEntity stringEntity = new StringEntity(postId);
        get.setHeader("Content-type", "application/json");
        HttpResponse response = httpClient.execute(get);
        ResponseHandler<String> handler = new BasicResponseHandler();
        return handler.handleResponse(response);
    }
}
