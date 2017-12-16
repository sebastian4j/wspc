package com.sebastian.boot2;

import java.util.stream.Stream;

public class GeneradorNombresProduccion implements GeneradorNombres {
    public Stream<String> generarNombres() {
        return Stream.of("PROD-Felix", "PROD-Garfield", "PROD-Whizkers"); 
    }
}
