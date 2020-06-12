package TeaseOutKnowledge.tenth;

/**
 * StringBuffer类的成员方法
 *      添加功能
 *          public StringBuffer append(String str)：
 *          可以把任意类型数据添加到字符串缓冲区里面,并返回字符串缓冲区本身
 *          public StringBuffer insert(int offset,String str)：
 *          在指定位置把任意类型的数据插入到字符串缓冲区里面,并返回字符串缓冲区本身
 *      删除功能
 *          public StringBuffer deleteCharAt(int index)：
 *          删除指定位置的字符，并返回本身
 *          public StringBuffer delete(int start,int end)：
 *          删除从指定位置开始指定位置结束的内容，并返回本身
 *      替换功能
 *          public StringBuffer replace(int start,int end,String str)：
 *          从start开始到end用str替换
 *      反转功能
 *          public StringBuffer reverse()
 *      截取功能
 *          public String substring(int start)
 *          public String substring(int start,int end)
 *
 */
public class StringBufferDemo2 {

    public static void main(String[] args) {

        System.out.println("StringBuffer 添加功能");

        // 创建字符串缓冲区对象
        StringBuffer sb = new StringBuffer();

        // 添加数据
        sb.append("hello");
        sb.append(true);
        sb.append(12);
        sb.append(34.56);

        // 上面的添加数据我们可以用链式编程开表示。你会发现结果是相同的
        //sb.append("hello").append(true).append(12).append(34.56);
        System.out.println("sb:" + sb);

        //在指定位置把任意类型的数据插入到字符串缓冲区里面,并返回字符串缓冲区本身
        sb.insert(5, "world");
        System.out.println("sb:" + sb);

        System.out.println("--------------------");
        System.out.println("StringBuffer 删除功能");

        // 创建对象
        StringBuffer stringbuffer2 = new StringBuffer();
        // 添加功能
        stringbuffer2.append("hello").append("world").append("java");
        System.out.println("stringbuffer2:" + stringbuffer2);//stringbuffer2:helloworldjava

        // 我们要删除e这个字符
        //stringbuffer2.deleteCharAt(1);
        //System.out.println("stringbuffer2:" + stringbuffer2);//stringbuffer2:hlloworldjava
        // 我们要删除world这个字符串，肿么办?
        stringbuffer2.delete(5, 10);
        System.out.println("stringbuffer3:" + stringbuffer2);//stringbuffer3:hellojava
        // 需求:我要删除所有的数据
        // stringbuffer2.delete(0, sb1.length());
        System.out.println("stringbuffer4:" + stringbuffer2);//stringbuffer4:

        System.out.println("--------------------");
        System.out.println("StringBuffer 替换功能");

        // 创建字符串缓冲区对象
        StringBuffer sb3 = new StringBuffer();

        // 添加数据
        sb3.append("hello");
        sb3.append("world");
        sb3.append("java");
        System.out.println("sb3:" + sb3);

        // 需求：我要把world这个数据替换为"洪荒之力"
        sb3.replace(5, 10, "洪荒之力");
        System.out.println("sb3:" + sb3);

        System.out.println("--------------------");
        System.out.println("StringBuffer 反转功能");

        // 创建字符串缓冲区对象
        StringBuffer sb4 = new StringBuffer();

        // 添加数据
        sb4.append("妈妈爱我");
        System.out.println(sb4);

        sb4.reverse();
        System.out.println(sb4);

        System.out.println("--------------------");
        System.out.println("StringBuffer 截取功能");

        // 创建字符串缓冲区对象
        StringBuffer sb5 = new StringBuffer();

        // 添加元素
        sb5.append("hello").append("world").append("java");
        System.out.println("sb5:" + sb5);

        // 截取功能
        // public String substring(int start)
        String s = sb5.substring(5);
        System.out.println("s:" + s);
        System.out.println("sb5:" + sb5);

        // public String substring(int start,int end)
        String ss = sb5.substring(5, 10);
        System.out.println("ss:" + sb5);
        System.out.println("sb5:" + sb5);

    }

}
