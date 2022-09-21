package com.rabbitmq.test;

import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        ClacInterface  myClac = new MyClac();
        ClacInterface proxyBean = (ClacInterface) Proxy.newProxyInstance(
          //第一个参数被代理类的类加载器
           MyClac.class.getClassLoader(),
          //第二个参数myClac的所有实现接口
           MyClac.class.getInterfaces(),
          //第三个参数是InvocationHandler这里用lambda简化
           (a,b,c)->{
              return b.invoke(myClac,c);
                }
        );
        System.out.println( proxyBean.add(3,5));

    }

    public static interface ClacInterface{
        int add(int a, int b);
    }

    public static class MyClac implements ClacInterface{
        @Override
        public int add(int a, int b) {
            return a+b;
        }
    }
}

