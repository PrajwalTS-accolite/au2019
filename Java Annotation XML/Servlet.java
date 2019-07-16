package com.accolite.au.java;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Servlet{
	String name();
	String url();
}

