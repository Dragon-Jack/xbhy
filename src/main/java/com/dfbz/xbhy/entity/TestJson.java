package com.dfbz.xbhy.entity;

public class TestJson {

    private String a;
    private String s;
    private String d;


    @Override
    public String toString() {
        return "TestJson{" +
                "a='" + a + '\'' +
                ", s='" + s + '\'' +
                ", d='" + d + '\'' +
                '}';
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }
}
