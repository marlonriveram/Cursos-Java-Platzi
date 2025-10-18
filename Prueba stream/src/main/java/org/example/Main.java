package org.example;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<String> nombres = Arrays.asList("Ana", "Pedro", "Juan", "Ana");

        // Aquí uso filter (intermedio), distinct (intermedio) y count (terminal)
        long cantidad = nombres.stream()
                .filter(n -> n.length() > 3) // intermedio
                .distinct()                  // intermedio
                .count();                    // terminal

        System.out.println("Cantidad de nombres únicos con más de 3 letras: " + cantidad);
    }
}