package br.com.sergiowink.scale_generator.exceptions;

public class ScaleNotFoundException extends RuntimeException {
    public ScaleNotFoundException(){
        super("Essa escala não existe!");
    }
}
