package com.foolish.gitdemo;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * HttpUtil
 *
 * @author Rex
 * @date 2016/8/1
 */
public class HttpUtil {
    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url   发送请求的URL
     * @param param 请求参数，请求参数应该是name1=value1&name2=value2的形式。
     * @return URL所代表远程资源的响应
     */

    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlName = url + "?" + param;
            URL realUrl = new URL(urlName);
            //打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            //设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            //建立实际的连接
            conn.connect();
            //获取所有响应头字段
            Map<String, List<String>> map = conn.getHeaderFields();
            //遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            //定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        //使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url   发送请求的URL
     * @param param 请求参数，请求参数应该是name1=value1&name2=value2的形式。
     * @param heardMap 请求头参数
     * @return URL所代表远程资源的响应
     */

    public static String sendGet(String url, String param, Map<String,String> heardMap) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlName = url + "?" + param;
            URL realUrl = new URL(urlName);
            //打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            //设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            conn.setRequestProperty("contentType", "UTF-8");
            for (Map.Entry<String, String> entry : heardMap.entrySet()) {
                conn.setRequestProperty(entry.getKey(),entry.getValue());
            }
            //建立实际的连接
            conn.connect();
            //获取所有响应头字段
            Map<String, List<String>> map = conn.getHeaderFields();
            //遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            //定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        //使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定URL发送POST方法的请求
     *
     * @param url   发送请求的URL
     * @param param 请求参数，请求参数应该是name1=value1&name2=value2的形式。
     * @return URL所代表远程资源的响应
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            //打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            //设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            //发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            //获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            //发送请求参数
            out.print(param);
            //flush输出流的缓冲
            out.flush();
            //定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送POST请求出现异常！" + e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    //提供主方法，测试发送GET请求和POST请求
    public static void main(String args[]) {

        String s1 = HttpUtil.sendGet("http://localhost:8082/cjobs/jobStart",
                "triggerName=opp2gjjlTrigger");
        System.out.println(s1);

    }


    /**
     * post请求
     *
     * @param url       url地址
     * @param jsonParam 参数
     * @return
     */
    public static String httpPost(String url, JSONObject jsonParam, Map<String, String> header) {
        //post请求返回结果
        DefaultHttpClient httpClient = new DefaultHttpClient();
        String str = "";
        HttpPost method = new HttpPost(url);

        try {
            if (null != jsonParam) {
                //解决中文乱码问题
                StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                method.setEntity(entity);
            }

            if (header != null) {
                for (String key : header.keySet()) {
                    method.setHeader(key, header.get(key));
                }
            }

            HttpResponse result = httpClient.execute(method);
            System.out.println(result);

            /**请求发送成功，并得到响应**/
            if (result.getStatusLine().getStatusCode() == 200) {

                try {
                    /**读取服务器返回过来的json字符串数据**/
                    str = EntityUtils.toString(result.getEntity(), "utf-8");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                str = result.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * post请求
     *
     * @param url       url地址
     * @param jsonParam 参数
     * @return
     */
    public static String httpPost(String url, String jsonParam, Map<String, String> header) throws Exception {
        //post请求返回结果
        DefaultHttpClient httpClient = new DefaultHttpClient();
        String str = "";
        HttpPost method = new HttpPost(url);

        if (null != jsonParam) {
            //解决中文乱码问题
            StringEntity entity = new StringEntity(jsonParam, "utf-8");
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            method.setEntity(entity);
        }

        if (header != null) {
            for (String key : header.keySet()) {
                method.setHeader(key, header.get(key));
            }
        }

        HttpResponse result = httpClient.execute(method);
        System.out.println(result);

        /**请求发送成功，并得到响应**/
        if (result.getStatusLine().getStatusCode() == 200) {

            try {
                /**读取服务器返回过来的json字符串数据**/
                str = EntityUtils.toString(result.getEntity(), "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            str = result.toString();
        }
        return str;
    }

    /**
     * post请求
     *
     * @param url       url地址
     * @param jsonParam 参数
     * @return
     */
    public static String httpPut(String url, String jsonParam, Map<String, String> header) throws Exception {
        //post请求返回结果
        DefaultHttpClient httpClient = new DefaultHttpClient();
        String str = "";
        HttpPut method = new HttpPut(url);

        if (null != jsonParam) {
            //解决中文乱码问题
            StringEntity entity = new StringEntity(jsonParam, "utf-8");
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            method.setEntity(entity);
        }

        if (header != null) {
            for (String key : header.keySet()) {
                method.setHeader(key, header.get(key));
            }
        }

        HttpResponse result = httpClient.execute(method);
        System.out.println(result);

        /**请求发送成功，并得到响应**/
        if (result.getStatusLine().getStatusCode() == 200) {

            try {
                /**读取服务器返回过来的json字符串数据**/
                str = EntityUtils.toString(result.getEntity(), "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            str = result.toString();
        }
        return str;
    }

}
