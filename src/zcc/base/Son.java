package zcc.base;

public class Son extends Father {
	private int i = test();
	private static int a = 10;
	private static int j = method();
	private String b = "13";
	static{
		System.out.print("(6)");
	}
	Son(){
		System.out.print("(7)");
	}
	{
		System.out.print("(8)");
	}
	public int test(){
		System.out.print("(9)");
		return 1;
	}
	public static int method(){
		System.out.print("(10)");
		return 1;
	}

	public static int method2(){
		System.out.print("(11)");
		return 1;
	}
	public static void main(String[] args) {
		Son s1 = new Son();  // (5)(1)(10)(6)(9)(3)(2)(9)(8)(7)
		System.out.println();
		Son s2 = new Son();
        try {
            s1.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
