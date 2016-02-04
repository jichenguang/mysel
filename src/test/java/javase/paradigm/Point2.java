package javase.paradigm;

public class Point2<T> {
	private T var;
    
    public T getVar() {
        return var;
    }
 
    public void setVar(T var) {
        this.var = var;
    }
 
    public static void main(String[] args) {
        //1 整数
        Point2<Integer> point2_1 = new Point2<Integer>();
        point2_1.setVar(20);
        System.out.println("整数测试：" + point2_1.getVar());
 
        System.out.println("******************我是华丽的分割线**********************");
         
        //字符串
        Point2<String> point2_2 = new Point2<String>();
        point2_2.setVar("zifangsky的个人博客");
        System.out.println("字符串测试：" + point2_2.getVar());
    }
 
}

