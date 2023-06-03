import java8.features.OptionalFeature;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class OptionalTestSuite extends DevTest{

    @Test
    public void isPresentTest(){
        String s = "1";
        Optional<Integer> numero = OptionalFeature.converterEmNumero(s);
        if(numero.isPresent()){
            System.out.println(numero.get());
        }
        assertConsoleContains("1");
    }

    @Test
    public void ifPresentTest(){
        String s = "1";
        OptionalFeature.converterEmNumero(s)
                .ifPresent(n->System.out.println(n));
        assertConsoleContains("1");
        CONSOLE.reset();
        Stream.of(1,2,3)
                .findFirst()
                .ifPresent(n->System.out.println(n));
        assertConsoleContains("1");
    }

    @Test
    public void getTest(){
        String s = "1";
        Integer numero=OptionalFeature.converterEmNumero(s).get();
        System.out.println(numero);
        assertConsoleContains("1");
    }

    @Test
    public void orElseTest(){
        String s = "error";
        System.out.println(OptionalFeature.converterEmNumero(s).orElse(2));
        assertConsoleContains("2");
    }

    @Test
    public void orElseGetTest(){
        String s = "error";
        System.out.println(OptionalFeature.converterEmNumero(s).orElseGet(()->5));
        assertConsoleContains("5");
    }

    @Test
    public void primitiveTest(){
        String s = "1";
        OptionalFeature.converterEmNumeroPrimitivo(s).ifPresent(System.out::println);
        assertConsoleContains("1");
    }

    @Test
    public void withExceptionTest(){
        String s = "error";

        Exception exception = assertThrows(NullPointerException.class, () -> {
            OptionalFeature.converterEmNumero(s).orElseThrow(()-> new NullPointerException("valor vazio"));
        });

        String expectedMessage = "valor vazio";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

}
