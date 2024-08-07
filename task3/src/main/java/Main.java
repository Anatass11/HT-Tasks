import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void deep(JSONObject temp, Map<Long, String> map){
        JSONArray t = (JSONArray) temp.get("values");
        JSONObject j;
        Long id;
        for(Object i: t){
            j = (JSONObject) i;
            id = (Long) j.get("id");
            j.put("value", map.get(id));
            System.out.println(j);
            if (j.get("values") != null) deep(j, map);
        }
    }

    public static void main(String[] args) {
        Map<Long, String> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите путь к values.json: ");
        String path = sc.nextLine();
        try {
            Object o = new JSONParser().parse(new FileReader(path));
            JSONObject j = (JSONObject) o;
            JSONArray t = (JSONArray) j.get("values");
            for (Object value : t) {
                j = (JSONObject) value;
                map.put((Long) j.get("id"), (String) j.get("value"));
            }
            System.out.println(map);
            System.out.println("Введите путь к tests.json: ");
            path = sc.nextLine();
            o = new JSONParser().parse(new FileReader(path));
            JSONObject res = (JSONObject) o;
            j = res;
            t = (JSONArray) j.get("tests");
            Long id;
            for(Object i: t){
                j = (JSONObject) i;
                id = (Long) j.get("id");
                j.put("value", map.get(id));
                System.out.println(j);
                if (j.get("values") != null) deep(j, map);
            }
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("res.json"), res);

        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}