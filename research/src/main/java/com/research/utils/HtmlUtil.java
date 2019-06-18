package com.research.utils;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author shc
 * @date 2018-06-18
 **/
public class HtmlUtil {


    /**
     * 根据路径获取相应的html，如urlPath = http:localhost:8080/company/resume.htm?id=1234567
     */
    public static String getHtml(String urlPath, HttpServletRequest httpServletRequest) {
        StringBuilder htmlData = new StringBuilder();

        String realUrl = httpServletRequest.getScheme() + "://" + httpServletRequest.getServerName() + ":" + httpServletRequest.getServerPort()
                + httpServletRequest.getContextPath() + "/";

        try {
            // 创建一个URL实例
            URL url;
            if (StringUtils.isEmpty(urlPath)) {
                url = new URL(realUrl + "static/error.html");
            } else {
                url = new URL(urlPath);
            }
            try {
                // 通过URL的openStream方法获取URL对象所表示的字节输入流
                InputStream is = url.openStream();
                InputStreamReader inputStreamReader = new InputStreamReader(is, "utf-8");
                // 为字符输入流添加缓冲
                BufferedReader br = new BufferedReader(inputStreamReader);
                // 读取数据
                String data = br.readLine();
                while (data != null) {
                    // 循环读取数据
                    htmlData.append(data);
                    // 输出数据
                    data = br.readLine();
                }
                br.close();
                inputStreamReader.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return htmlData.toString();
    }

}
