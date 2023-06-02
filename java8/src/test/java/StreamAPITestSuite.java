import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StreamAPITestSuite extends DevTest{

    @Test
    public void skipTest(){
        final List<Integer> listaDeNumeros = Arrays.asList(1,2,3,4,5,6);
        assertNotNull(listaDeNumeros, TESTE_QUEBRADO);
        assertEquals(Arrays.asList(1,2,3,4,5,6), listaDeNumeros, TESTE_QUEBRADO);

        listaDeNumeros.stream().skip(3).forEach(e->System.out.print(e));

        assertConsoleContains("456");
    }

    @Test
    public void limitTest(){
        final List<Integer> listaDeNumeros = Arrays.asList(1,2,3,4,5,6);
        assertNotNull(listaDeNumeros, TESTE_QUEBRADO);
        assertEquals(Arrays.asList(1,2,3,4,5,6), listaDeNumeros, TESTE_QUEBRADO);

        listaDeNumeros.stream().limit(3).forEach(e->System.out.print(e));

        assertConsoleContains("123");
    }

    @Test
    public void distinctTest(){
        final List<Integer> listaDeNumeros = Arrays.asList(1,2,3,1,2,3);
        assertNotNull(listaDeNumeros, TESTE_QUEBRADO);
        assertEquals(Arrays.asList(1,2,3,1,2,3), listaDeNumeros, TESTE_QUEBRADO);

        listaDeNumeros.stream().distinct().forEach(e->System.out.print(e));

        assertConsoleContains("123");
    }

    @Test
    public void filterTest(){
        final List<Integer> listaDeNumeros = Arrays.asList(1,2,3,4,5,6,7,8);
        assertNotNull(listaDeNumeros, TESTE_QUEBRADO);
        assertEquals(Arrays.asList(1,2,3,4,5,6,7,8), listaDeNumeros, TESTE_QUEBRADO);

        listaDeNumeros.stream().filter(n->n%2!=0).forEach(e->System.out.print(e));

        assertConsoleContains("1357");
    }

    @Test
    public void mapTest(){
        final List<Integer> listaDeNumeros = Arrays.asList(1,2,3,4,5,6);
        assertNotNull(listaDeNumeros, TESTE_QUEBRADO);
        assertEquals(Arrays.asList(1,2,3,4,5,6), listaDeNumeros, TESTE_QUEBRADO);

        listaDeNumeros.stream().map(n->n*3).forEach(e->System.out.print(e));

        assertConsoleContains("369121518");
    }

    @Test
    public void skipLimitMapTest(){
        final List<Integer> listaDeNumeros = Arrays.asList(1,2,3,4,5,6);
        assertNotNull(listaDeNumeros, TESTE_QUEBRADO);
        assertEquals(Arrays.asList(1,2,3,4,5,6), listaDeNumeros, TESTE_QUEBRADO);

        listaDeNumeros.stream()
                .skip(2)
                .limit(2)
                .map(n->n*2).forEach(e->System.out.print(e));

        assertConsoleContains("68");
    }

    @Test
    public void countTest(){
        final List<Integer> listaDeNumeros = Arrays.asList(1,2,3,4,5,6);
        assertNotNull(listaDeNumeros, TESTE_QUEBRADO);
        assertEquals(Arrays.asList(1,2,3,4,5,6), listaDeNumeros, TESTE_QUEBRADO);

        long size=listaDeNumeros.stream().count();

       assertEquals(listaDeNumeros.size(),size,TESTE_QUEBRADO);
    }

    @Test
    public void minTest(){
        final List<Integer> listaDeNumeros = Arrays.asList(1,2,3,4,5,6);
        assertNotNull(listaDeNumeros, TESTE_QUEBRADO);
        assertEquals(Arrays.asList(1,2,3,4,5,6), listaDeNumeros, TESTE_QUEBRADO);

        Integer min=listaDeNumeros.stream().min(Comparator.naturalOrder()).get();

        assertEquals(1,min,TESTE_QUEBRADO);
    }

    @Test
    public void maxTest(){
        final List<Integer> listaDeNumeros = Arrays.asList(1,2,3,4,5,6);
        assertNotNull(listaDeNumeros, TESTE_QUEBRADO);
        assertEquals(Arrays.asList(1,2,3,4,5,6), listaDeNumeros, TESTE_QUEBRADO);

        Integer min=listaDeNumeros.stream().max(Comparator.naturalOrder()).get();

        assertEquals(6,min,TESTE_QUEBRADO);
    }

    @Test
    public void collectorTest(){
        final List<Integer> listaDeNumeros = Arrays.asList(1,2,3,4,5,6);
        assertNotNull(listaDeNumeros, TESTE_QUEBRADO);
        assertEquals(Arrays.asList(1,2,3,4,5,6), listaDeNumeros, TESTE_QUEBRADO);

        List<Integer> newList=listaDeNumeros.stream()
                .skip(2)
                .limit(2)
                .map(n->n*2).collect(Collectors.toList());

        System.out.println(newList);
        assertConsoleContains("[6, 8]");
    }

    @Test
    public void collectorGroupingByTest(){
        final List<Integer> listaDeNumeros = Arrays.asList(1,2,3,4,5,6);
        assertNotNull(listaDeNumeros, TESTE_QUEBRADO);
        assertEquals(Arrays.asList(1,2,3,4,5,6), listaDeNumeros, TESTE_QUEBRADO);

        Map<Boolean,List<Integer>> newList=listaDeNumeros.stream()
                .collect(Collectors.groupingBy(n->n%2==0));

        System.out.println(newList);
        assertConsoleContains("{false=[1, 3, 5], true=[2, 4, 6]}");

        CONSOLE.reset();

        Map<Integer,List<Integer>> newList2=listaDeNumeros.stream()
                .collect(Collectors.groupingBy(n->n%3));

        System.out.println(newList2);
        assertConsoleContains("{0=[3, 6], 1=[1, 4], 2=[2, 5]}");

    }

    @Test
    public void collectorJoiningTest(){
        final List<Integer> listaDeNumeros = Arrays.asList(1,2,3,4,5,6);
        assertNotNull(listaDeNumeros, TESTE_QUEBRADO);
        assertEquals(Arrays.asList(1,2,3,4,5,6), listaDeNumeros, TESTE_QUEBRADO);

        String joining=listaDeNumeros.stream()
                .map(e->String.valueOf(e))
                .collect(Collectors.joining());

        System.out.println(joining);
        assertConsoleContains("123456");

        CONSOLE.reset();

        joining=listaDeNumeros.stream()
                .map(e->String.valueOf(e))
                .collect(Collectors.joining(";"));

        System.out.println(joining);
        assertConsoleContains("1;2;3;4;5;6");
    }

    @Test
    public void paralelStreamTest(){
        final List<Integer> listaDeNumeros = Arrays.asList(1,2,3,4,5,6);
        assertNotNull(listaDeNumeros, TESTE_QUEBRADO);
        assertEquals(Arrays.asList(1,2,3,4,5,6), listaDeNumeros, TESTE_QUEBRADO);

        List<Integer> listaDeNumeros2=listaDeNumeros.parallelStream().skip(3).collect(Collectors.toList());

        assertEquals(listaDeNumeros2.size(),3,TESTE_QUEBRADO);
    }
}
