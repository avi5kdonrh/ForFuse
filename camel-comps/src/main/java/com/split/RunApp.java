package com.split;

import org.apache.camel.spring.Main;

public class RunApp {
public static void main(String[] args) throws Exception{
	System.setProperty("FILE_LOCATION", "/home/adongre/Desktop/Shell/Xamel/input/");
	Main main = new  Main();
	main.setApplicationContextUri("META-INF/spring/camel-context.xml");
	main.run();
}
}
