package br.com.sergiowink.scale_generator.utils;

public class QuantityNames {
    public static int getQuantityNames(String type) {
        switch (type) {
            case "dupla":
                return 2;
            case "trio":
                return 3;
            default:
                return 1; 
        }
    }
}
