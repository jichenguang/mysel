package javase.paradigm;

/**
 * 格式：[访问权限]<泛型标志> 泛型标志 方法名称([泛型标志 参数名称])
 * @author 700sfriend
 * 笔记：方法名前的泛型标志，表示这个方法要返回的类型。那么这个类型的决定就是要看方法的参数来决定。
 */
public class MethodDemo {
    public <T> T getData(T t){
        return t;
    }
     
    public void print(){
        System.out.println("zifangsky");   
    }
     
    public static void main(String[] args) {
        MethodDemo methodDemo = new MethodDemo();
        methodDemo.print();
         
        int i = methodDemo.getData(10);
        System.out.println("int: " + i);
         
        String str = methodDemo.getData("hello world");
        System.out.println("String: " + str);
    }
 
}
