package com.rh;

import org.apache.camel.spring.Main;

public class StartRoute {
public static void main(String[] args) {
    Main miin = new Main();
    miin.setApplicationContextUri("/META-INF/spring/camel-context.xml");
    miin.run(args);
}
}