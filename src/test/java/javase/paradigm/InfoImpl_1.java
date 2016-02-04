package javase.paradigm;

/**
 * 在子类的定义上申明泛型类型
 * @author 700sfriend
 *
 * @param <T>
 */
public class InfoImpl_1<T> implements Info<T> {
    private T var;
     
    public InfoImpl_1(T var) {
        this.var = var;
    }
 
    public T getVar() {
        return this.var;
    }
 
    public void setVar(T var) {
        this.var = var;
    }
 
}

