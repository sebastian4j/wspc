package com.sebastian.boot2;

import java.util.stream.Stream;

public class GeneradorNombresDesarrollo implements GeneradorNombres {
    public Stream<String> generarNombres() {
        return Stream.of("DESA-Felix", "DESA-Garfield", "DESA-Whizkers"); 
    }
}
