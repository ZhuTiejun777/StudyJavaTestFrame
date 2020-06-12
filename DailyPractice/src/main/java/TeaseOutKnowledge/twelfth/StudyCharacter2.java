package TeaseOutKnowledge.twelfth;

/**
 * 做一个统计一个字符串中大写字母字符，小写字母字符，数字字符出现的次数。（比如"Adu123Messi"这个字符串）
 */

public class StudyCharacter2 {
    public static void main(String[] args) {
        //首先定义一个字符串
        String str = "Adu123Messi";
        //然后让我们定义三个统计变量
        int bigCount = 0;//大写字母
        int smallCount = 0;//小写字母
        int numberCount = 0;//数字
        // 把字符串转换为字符数组。
        char[] chs = str.toCharArray();

        // 遍历字符数组获取到每一个字符
        for (int x = 0; x < chs.length; x++) {
            char ch = chs[x];

            // 判断该字符
            if (Character.isUpperCase(ch)) {
                bigCount++;
            } else if (Character.isLowerCase(ch)) {
                smallCount++;
            } else if (Character.isDigit(ch)) {
                numberCount++;
            }
        }
        // 输出结果
        System.out.println("大写字母：" + bigCount + "个");
        System.out.println("小写字母：" + smallCount + "个");
        System.out.println("数字字符：" + numberCount + "个");
    }
}
