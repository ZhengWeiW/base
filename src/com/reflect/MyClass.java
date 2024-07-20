package com.reflect;

public class MyClass {
    private String myField = "initial value";

    private String testField = "testField testField";

    // Getter 和 Setter（可选，但通常建议提供）
    public String getMyField() {
        return myField;
    }

    public void setMyField(String myField) {
        this.myField = myField;
    }

    public String getTestField() {
        return testField;
    }

    public void setTestField(String testField) {
        this.testField = testField;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "myField='" + myField + '\'' +
                '}';
    }
}