package advanced;

import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class JsonDemo1 {

    public static void main(String[] args){
        createJsonByMap();

    }

    public static void createJsonByMap(){

        Map<String, Object> zhangsan = new HashMap<String, Object>();
        zhangsan.put("name", "张三");
        zhangsan.put("age", 25.2);
        zhangsan.put("birthday", "1991-06-08");
        zhangsan.put("school", "蓝翔技校");
        zhangsan.put("major", new String []{"理发师", "挖掘机"});
        zhangsan.put("car", false);
        zhangsan.put("has_girlfriend", false);
        zhangsan.put("hourse", null);

        System.out.println(new JSONObject(zhangsan).toString());

    }

}
