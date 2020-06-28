package TeaseOutKnowledge.sixteenth;

public class ObjectToolDemo {

    public static void main(String[] args) {
        // 定义泛型类，可以传入任意类型的数据
        ObjectTool<String> objectTool1 = new ObjectTool<String>();
        objectTool1.setObj(new String("caocao"));
        objectTool1.setObj(new String("liubei"));
        System.out.println(objectTool1.getObj());

        ObjectTool<Integer> objectTool2 = new ObjectTool<Integer>();
        objectTool2.setObj(50);
        System.out.println(objectTool2.getObj());

        // 定义泛型方法后,可以传入任意类型数据
        ObjectTool objectTool3 = new ObjectTool();
        objectTool3.show("sunquan");
        objectTool3.show(10);
        objectTool3.show(true);


    }
}
