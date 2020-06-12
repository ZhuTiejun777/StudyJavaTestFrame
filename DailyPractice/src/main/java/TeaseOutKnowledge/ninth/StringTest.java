package TeaseOutKnowledge.ninth;

/**
 * 统计一个字符串中大写字母字符，小写字母字符，数字字符出现的次数。(不考虑其他字符)
 */

public class StringTest {

    public static void main(String[] args) {
        //定义一个字符串
        String s = "Hello123World";

        //定义三个统计变量
        int bigCount = 0;//大写字母
        int smallCount = 0;//小写字母
        int numberCount = 0;//数字

        //遍历字符串，得到每一个字符。
        for(int x=0; x<s.length(); x++){
            char ch = s.charAt(x);

            //判断该字符到底是属于那种类型的
            if(ch>='a' && ch<='z'){
                smallCount++;
            }else if(ch>='A' && ch<='Z'){
                bigCount++;
            }else if(ch>='0' && ch<='9'){
                numberCount++;
            }
        }

        //输出结果。
        System.out.println("大写字母"+bigCount+"个");
        System.out.println("小写字母"+smallCount+"个");
        System.out.println("数字"+numberCount+"个");
    }

}
