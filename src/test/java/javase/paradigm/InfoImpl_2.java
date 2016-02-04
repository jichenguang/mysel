package javase.paradigm;


/**
 * 直接在接口中指定具体类型
 * @author 700sfriend
 *
 */
public class InfoImpl_2 implements Info<String> {
    private String var;
     
    public InfoImpl_2(String var) {
        this.var = var;
    }
 
    public String getVar() {
        return this.var;
    }
 
    public void setVar(String var) {
        this.var = var;
    }
     
}