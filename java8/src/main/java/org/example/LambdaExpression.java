package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;

public class LambdaExpression {
    public static void main(String[] args) {
        List<Integer> valores = Arrays.asList(1,2,3,4,5,6);
        ArrayList<Integer> dobro = new ArrayList<Integer>();
        ArrayList<Integer> par = new ArrayList<Integer>();
        ArrayList<Integer> impar = new ArrayList<Integer>();

        valores.forEach((v)->{
            dobro.add(v*2);
            if(v%2==0){
                par.add(v);
            }else{
                impar.add(v);
            }
        });

        //Consumer<Integer> dobrar=(v) -> { dobro.add(v*2); };
        //valores.forEach(dobrar);

        System.out.println(valores);
        System.out.println(dobro);
        System.out.println(par);
        System.out.println(impar);
    }


}