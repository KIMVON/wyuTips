package util;

import java.util.Map;

public class FormatUtil {
    @SuppressWarnings("all")
    public static String buildUrl(String url , Map<String,Object> params){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(url);
        if (!params.isEmpty()){
            stringBuilder.append("?");
        }
        for (Map.Entry<String,Object> entry: params.entrySet()){
            stringBuilder.append(entry.getKey());
            stringBuilder.append("=");
            stringBuilder.append(entry.getValue());
            stringBuilder.append("&");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);

        return stringBuilder.toString();
    }

    @SuppressWarnings("all")
    public static String buildPostData(Map<String,Object> data){
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String,Object> entry : data.entrySet()){
            stringBuilder.append(entry.getKey());
            stringBuilder.append("=");
            stringBuilder.append(entry.getValue());
            stringBuilder.append("&");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);

        return stringBuilder.toString();
    }
}
