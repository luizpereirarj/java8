package java8.features;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;

public class LambdaExpression {
    public static void main(String[] args) {

        //SIMPLE LAMBDA FUNCTION
        List<Integer> values = Arrays.asList(1,2,3,4,5,6);
        ArrayList<Integer> doublee = new ArrayList<Integer>();
        ArrayList<Integer> even = new ArrayList<Integer>();
        ArrayList<Integer> odd = new ArrayList<Integer>();

        values.forEach((v)->{
            doublee.add(v*2);
            if(v%2==0){
                even.add(v);
            }else{
                odd.add(v);
            }
        });
        System.out.println(values);
        System.out.println(doublee);
        System.out.println(even);
        System.out.println(odd);

        //USING CONSUMER
        doublee.clear();
        Consumer<Integer> doubleConsumer=(v) -> { doublee.add(v*2); };
        values.forEach(doubleConsumer);

        System.out.println(doublee);


        new Thread(() -> System.out.println("Olá Mundo")).run();

        //SAM - Single Abstract Method - Any interface which has at least one abastract method

    }



}