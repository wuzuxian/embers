package wzx.utils;

import com.google.gson.Gson;

public class GsonUtil {
    private static Gson gson = new Gson();

    public static String getJsonString(Object data){
        return gson.toJson(data);
    }

    public static <T> T from(String json,Class<T> clazz){
        return gson.fromJson(json,clazz);
    }

}
