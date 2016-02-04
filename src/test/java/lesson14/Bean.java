package lesson14;

public class Bean {
	private String val;
    private int i;
    private int q;
    public Bean(String val, int i,int q){
        this.val=val;
        this.i=i;
        this.q=q;
    }
    public String getVal() {
	return val;
    }
    public void setVal(String val) {
	this.val = val;
    }
    public int getI() {
	return i;
    }
    public void setI(int i) {
	this.i = i;
    }
    
    public int getQ() {
	return q;
    }
    public void setQ(int q) {
	this.q = q;
    }
}
