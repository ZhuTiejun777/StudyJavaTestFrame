package TeaseOutKnowledge.nineteenth;

/**
 * 多异常的处理
 *      每一个写一个try…catch（这样有点过于麻烦）
 *      写一个try，多个catch
 *
 * try{
 *             ...
 *         }catch(异常类名 变量名) {
 *             ...
 *         }
 *         catch(异常类名 变量名) {
 *             ...
 *         }
 *         ...
 *
 * 注意事项：
 *      1:能明确的尽量明确，不要用大的来处理。
 *      2:平级关系的异常谁前谁后无所谓，如果出现了子父关系，父必须在后面。
 */
public class ExceptionDemo3 {

    public static void main(String[] args) {
        method();
        System.out.println("---------------");
        methods();
    }

    public static void method() {

        int a = 10;
        int b = 0;
        int[] arr = {1, 2, 3};

        try {
            System.out.println(arr[3]);
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            System.out.println("除数不能为0");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("你访问了不该访问的索引");
        }

        System.out.println("over");
    }

    //多个异常的处理
    public static void methods() {
        int a = 10;
        int b = 0;
        int[] arr = { 1, 2, 3 };

        try {
            System.out.println(a / b);
            System.out.println(arr[3]);
            System.out.println("这里出现了一个异常");
        } catch (ArithmeticException e) {
            System.out.println("除数不能为0");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("你访问了不该的访问的索引");
        } catch (Exception e) {
            System.out.println("出问题了");
        }

        System.out.println("over");
    }
}
