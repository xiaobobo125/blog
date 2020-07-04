package com.bolife.test;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/7/4 09:23
 * @Description:
 */
public class Type{
    public int pubIntField;
    public String pubStringField;
    private int prvIntField;

    public Type(){
        Log("Default Constructor");
    }

    Type(int arg1, String arg2){
        pubIntField = arg1;
        pubStringField = arg2;

        Log("Constructor with parameters");
    }

    public void setIntField(int val) {
        this.prvIntField = val;
    }
    public int getIntField() {
        return prvIntField;
    }

    private void Log(String msg){
        System.out.println("Type:" + msg);
    }
}

class ExtendType extends Type{
    public int pubIntExtendField;
    public String pubStringExtendField;
    private int prvIntExtendField;

    public ExtendType(){
        Log("Default Constructor");
    }

    ExtendType(int arg1, String arg2){
        pubIntExtendField = arg1;
        pubStringExtendField = arg2;

        Log("Constructor with parameters");
    }

    public void setIntExtendField(int field7) {
        this.prvIntExtendField = field7;
    }
    public int getIntExtendField() {
        return prvIntExtendField;
    }

    private void Log(String msg){
        System.out.println("ExtendType:" + msg);
    }
}