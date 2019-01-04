import java.text.SimpleDateFormat;
import java.util.Date;

import org.objects.StandardForm;

public class ForTest{

    public static void main(String[] args) {
        StandardForm form = new StandardForm();
        form.setAge(1);
        form.setDob("10-NOV-2018");
        //System.out.println(form.toString());
String date  = "10-NOV-2018";
SimpleDateFormat sdf = new SimpleDateFormat("dd-mmm-yyyy");
System.out.println(sdf.format(new Date()));


    }
}
