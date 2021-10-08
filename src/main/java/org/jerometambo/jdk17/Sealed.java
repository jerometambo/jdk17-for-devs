package org.jerometambo.jdk17;

import java.util.List;
import java.util.stream.Stream;

public class Sealed {
    
    public static void main(String... args) {
        Ordinateur ordinateur = new Ordinateur();
        Tablette tablette = new Tablette();
        
        System.out.println(String.join(" sealed : ", ordinateur.getClass().getSimpleName(), String.valueOf(ordinateur.getClass().isSealed())));
        System.out.println(String.join(" sealed : ", ordinateur.getClass().getSuperclass().getSimpleName(), String.valueOf(ordinateur.getClass().getSuperclass().isSealed())));
        System.out.println(String.join(" sealed : ", tablette.getClass().getSimpleName(), String.valueOf(tablette.getClass().isSealed())));
        
        List<String> permittedSubClasses = Stream.of(ordinateur.getClass().getSuperclass().getPermittedSubclasses())
                .map(Class::toString)
                .toList();
        System.out.println(ordinateur.getClass().getSuperclass().getSimpleName() + " sous classes autorisées : " + permittedSubClasses);
        
    }
}
