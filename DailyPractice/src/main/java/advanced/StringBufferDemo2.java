package advanced;

public class StringBufferDemo2 {

    public static void main(String[] args) {
        // 初始化StringBuffer
        StringBuffer stringBuffer = new StringBuffer("stringbuffer");
        System.out.println("初始化StringBuffer" + stringBuffer);
        // StringBuffer转化为String
        String string = stringBuffer.toString();
        System.out.println("StringBuffer转化为String" + string);
        // String转化为StringBuffer
        StringBuffer stringBuffer1 = new StringBuffer(string);
        System.out.println("String转化为StringBuffer" + stringBuffer1);

        // 在末尾追加
        stringBuffer.append("append");
        System.out.println("在末尾追加" + stringBuffer);
        // 删除指定位置的字符
        stringBuffer.deleteCharAt(2);
        System.out.println("删除指定位置的字符" + stringBuffer);
        // 删除指定区域的字段
        stringBuffer.delete(1,2);
        System.out.println("删除指定区域的字段" + stringBuffer);
        // 在指定索引位置插入字符串
        stringBuffer.insert(3, "insert");
        System.out.println("在指定索引位置插入字符串" + stringBuffer);
        // 将字符串反转
        stringBuffer.reverse();
        System.out.println("将字符串反转" + stringBuffer);
        // 修改对象中索引位置的字符,char类型用单引号''
        stringBuffer.setCharAt(0, 'S');
        System.out.println("修改对象中索引位置的字符" + stringBuffer);
        // 缩短StringBuffer字符串存储空间
        System.out.println(stringBuffer.length());
        stringBuffer.trimToSize();
        System.out.println(stringBuffer.length());
    }
}
