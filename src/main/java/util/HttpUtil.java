package util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpUtil {
    public static HttpURLConnection getUrlConnection(String urlString, String cookie, String method) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            // 设置通用的请求属性
            urlConnection.setRequestProperty("accept", "*/*");
            urlConnection.setRequestProperty("connection", "Keep-Alive");
            urlConnection.setRequestProperty("user-agent",
                    "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.119 Safari/537.36");
            if (cookie != null && cookie.equals("")) {
                urlConnection.setRequestProperty("Cookie", cookie);
            }
            urlConnection.setConnectTimeout(3000);
            urlConnection.setReadTimeout(3000);

            if (method.equals("GET")) {
                urlConnection.setRequestMethod("get");
            } else {
                urlConnection.setRequestMethod("post");
                urlConnection.setDoInput(true);
                urlConnection.setDoOutput(true);
            }
            urlConnection.connect();

            return urlConnection;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static HttpURLConnection getUrlConnection(String url, String cookie) {
        return getUrlConnection(url, cookie, "GET");
    }

    public static HttpURLConnection getUrlConnection(String url) throws IOException {
        return getUrlConnection(url, null);
    }

    public static HttpURLConnection postUrlConnection(String url, String cookie) {
        return getUrlConnection(url, cookie, "POST");
    }

    public static HttpURLConnection postUrlConnection(String url) throws IOException {
        return postUrlConnection(url, null);
    }

    public static String getCookie(URLConnection urlConnection, String cookieKey) {
        //获取cookie
        Map<String, List<String>> map = urlConnection.getHeaderFields();
        Set<String> set = map.keySet();
        for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
            String key = (String) iterator.next();
            if (key != null && key.equals(cookieKey)) {
                List<String> list = map.get(key);
                StringBuilder builder = new StringBuilder();
                for (String str : list) {
                    builder.append(str);
                }
                String cookieValue = builder.toString();
                return cookieValue;
            }
        }
        return null;
    }

//    public static

    public static InputStream post(String url, String cookie, Map<String, Object> params) throws IOException {
        URLConnection urlConnection = getUrlConnection(url, cookie, "POST");
        PrintWriter out = new PrintWriter(urlConnection.getOutputStream());
        String data = convertMapToParasUrl();
        out.print(data);
        out.flush();
        // 定义BufferedReader输入流来读取URL的响应
        return urlConnection.getInputStream();
    }

    private static String convertMapToParasUrl() {
        return null;
    }
}
