package zcc.base;

public class AssertTest{
    public static void main(String[] args) {
        int number = 10;

        // 这是一个有效的断言
        assert number > 0 : "number 必须是正数";

        System.out.println("断言通过，number 是正数");

        // 尝试更改number的值以触发断言失败
        number = -5;

        // 这是一个会失败的断言
        assert number > 0 : "number 必须是正数，但实际上它是 " + number;

        // 注意：如果断言失败，以下代码不会被执行
        // 除非JVM以启用断言的模式运行   在启动参数中添加  -ea即可
        System.out.println("这条信息在断言失败时不会打印");




        int a = 1;
        int b = 1;
        assert a == b;
        System.out.println("公众号：Hollis");
        assert a == b : "Hollis";
        System.out.println("博客：www.hollischuang.com");
    }
}
