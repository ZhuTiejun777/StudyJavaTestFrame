package InterviewBible;

import java.text.SimpleDateFormat;
import java.util.*;

public class CommonAPI {

    public static void main(String[] args) {
        System.out.println(Math.round(11.5));
        System.out.println(Math.round(-11.5));

        int[] testlength = {1,5,4,6};
        System.out.println(testlength.length);

        System.out.println(System.currentTimeMillis());

        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        System.out.println(dateFormat.format(date));

        List<String> list = new ArrayList<String>();
        list.add("test");
        list.add("test");
        System.out.println(list);
        System.out.println(list.get(1));

        Set<String> hashSet = new HashSet<String>(list);
        System.out.println(hashSet);

    }
}
