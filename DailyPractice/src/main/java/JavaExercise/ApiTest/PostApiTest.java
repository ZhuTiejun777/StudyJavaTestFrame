package JavaExercise.ApiTest;

import com.alibaba.fastjson.JSONObject;
import com.jayway.jsonpath.JsonPath;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class PostApiTest {

    static  String url = "https://reqres.in/api/users";
    public static void main(String[] args) throws IOException {

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "morpheus");
        jsonObject.put("job", "leader");
        StringEntity stringEntity = new StringEntity(jsonObject.toString());
        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
        CloseableHttpResponse response = client.execute(httpPost);
        String content = EntityUtils.toString(response.getEntity(), "UTF-8");
        String path = "$.name";
        System.out.println(JsonPath.read(content, path));

    }
}
