package JavaExercise.ApiTest;

import com.jayway.jsonpath.JsonPath;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;

public class GetApiTest {

    static String url = "https://reqres.in";

    public static void main(String[] args) throws IOException {

        CloseableHttpClient client = HttpClients.createDefault();
        //String string = (new StringBuffer(url)).append("/api/users?page=2").toString();
        String string = url + "/api/users?page=2";
        HttpGet httpGet = new HttpGet(string);

        CloseableHttpResponse response = client.execute(httpGet);

        String content = EntityUtils.toString(response.getEntity(), "UTF-8");

        String path = "$.data[*].id";
        String str = JsonPath.read(content, path).toString();
        System.out.println(str);
    }
}
