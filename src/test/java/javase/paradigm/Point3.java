package javase.paradigm;
 
public class Point3<T> {
    private T x;
    private T y;
     
    public T getX() {
        return x;
    }
 
    public void setX(T x) {
        this.x = x;
    }
 
    public T getY() {
        return y;
    }
 
    public void setY(T y) {
        this.y = y;
    }
 
    public static void main(String[] args) {
        //1 整数表示
        Point3<Integer> point3_1 = new Point3<Integer>();
        point3_1.setX(10);
        point3_1.setY(20);
         
        int x1 = point3_1.getX();
        int y1 = point3_1.getY();
        System.out.println("整数表示，X坐标是：" + x1 + "，Y坐标是：" + y1);
         
        System.out.println("******************我是华丽的分割线**********************");
         
        //2 字符串表示
        Point3<String> point3_2 = new Point3<String>();
        point3_2.setX("东经 50度");
        point3_2.setY("北纬 79度");
         
        String x2 = point3_2.getX();
        String y2 = point3_2.getY();
        System.out.println("字符串表示，X坐标是：" + x2 + "，Y坐标是：" + y2);
         
    }
 
}

