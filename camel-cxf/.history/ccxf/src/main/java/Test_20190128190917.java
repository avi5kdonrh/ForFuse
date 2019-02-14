import org.apache.camel.spring.Main;

public class Test{
    public static void main(String[] args) {
        Main main = new Main();
        main.setApplicationContextUri("/META-INF/spring/camel-context.xml");
    }
}