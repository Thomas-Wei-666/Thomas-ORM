package com.example.simpleorm.annotation;

public @interface Default {
    String defaultString() default "";
    int defaultInt() default -1;
}
