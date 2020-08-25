package JavaExercise;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONPath;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jayway.jsonpath.JsonPath;

import java.io.IOException;


public class two {

    static String url = "http://192.168.1.18:8088/bankApi/queryCustSubaccountBalance";

    public static void main(String[] args) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("custAcctId", "3294000000037057");

        String string = jsonObject.toString();
        StringEntity stringEntity = new StringEntity(string);
        httpPost.setEntity(stringEntity);

        httpPost.setHeader("Content-Type", "application/json");

        CloseableHttpResponse response = client.execute(httpPost);

        System.out.println(response.getStatusLine().getStatusCode());

        HttpEntity httpEntity = response.getEntity();
        String content = EntityUtils.toString(httpEntity);

        //JSONObject jsoncontent = JSON.parseObject(content);

        String jsonpath = "$.payload.BodyMsg";
        String bodymsg = JSONPath.read(content, jsonpath).toString();
        System.out.println(bodymsg);
        System.out.println(content);
    }
}
