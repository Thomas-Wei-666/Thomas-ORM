package com.example.simpleorm.annotation;

public @interface Default {
    String defaultString() default "";
    int defaultInt() default -1;
    short defaultShort() default -1;
    long defaultLong() default -1;
    boolean defaultBoolean() default false;
    float defaultFloat() default -1.0f;
    double defaultDouble() default -1.0;
}
