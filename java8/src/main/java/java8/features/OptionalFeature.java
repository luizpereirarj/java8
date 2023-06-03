package java8.features;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class OptionalFeature {

    public static void main(String[] args) {
        String s = "1";
        Optional<Integer> numero = converterEmNumero(s);
        if(numero.isPresent()){
            System.out.println(numero.get());
        }
        converterEmNumero(s)
                .ifPresent(n->System.out.println(numero.get()));

        s = "error";
        System.out.println(converterEmNumero(s).orElse(2));

        System.out.println(converterEmNumero(s).orElseGet(()->5));

        Stream.of(1,2,3)
                .findFirst()
                .ifPresent(n->System.out.println(n));

        s="1";
        converterEmNumeroPrimitivo(s).ifPresent(System.out::println);

        System.out.println(converterEmNumero(s).orElseThrow(()-> new NullPointerException("valor vazio")));

    }

    public static Optional<Integer> converterEmNumero (String numeroStr){
        try{
            return Optional.of(Integer.valueOf(numeroStr));
        }catch(Exception e){
            return Optional.empty();
            //return Optional.ofNullable();
        }
    }

    public static OptionalInt converterEmNumeroPrimitivo (String numeroStr){
        try{
            return OptionalInt.of(Integer.parseInt(numeroStr));
        }catch(Exception e){
            return OptionalInt.empty();
        }
    }
}
