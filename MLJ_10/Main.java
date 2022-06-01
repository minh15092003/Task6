import java.io.*;
import java.util.*;
import org.json.simple.*;

public class Main {
    public static void main(String[] args){
        Main parser = new Main();
        try {
            Object obj = parser.parse(new FileReader("course.json"));
            JSONObject jsonObject = (JSONObject);
            String name = (String)jsonObject.get("Name");
            String course = (String)jsonObject.get("Course");
            JSONArray subjects = (JSONArray)jsonObject.get("Subjects");
            System.out.println("Name: " + name );
            System.out.println("Course: " + course);
            System.out.println("Subjects:");
            Iterator iterator = subjects.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
