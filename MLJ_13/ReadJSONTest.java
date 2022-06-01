package MLJ_13;

import com.mysql.cj.xdevapi.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.imageio.IIOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;

public class ReadJSONTest {
    public static void main(String[] args) {
        JsonParser jsonParser = new JsonParser();

        try (FileReader reader = new FileReader("employees.json")) {
            Object obj = jsonParser.parse(reader);

            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);

            employeeList.forEach(emp -> parseEmployeeOject(JSONObject)emp);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IIOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseEmployeeOject(JSONObject employee) {
        JSONObject employeeObject = (JSONObject) employee.get("employee");

        String firstName = (String) employeeObject.get("firstName");
        System.out.println(firstName);

        String lastName = (String) employeeObject.get("lastName");
        System.out.println(lastName);

        String website = (String) employeeObject.get("website");
        System.out.println(website);
    }
}