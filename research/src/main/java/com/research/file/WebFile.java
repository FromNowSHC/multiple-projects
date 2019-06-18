package com.research.file;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/**
 * web测试
 *
 * @author shc
 * @date 2018-06-18
 **/
@RestController
public class WebFile {

    /**
     * 请求url为/push?userName=小明
     *
     */
    @RequestMapping("/push")
    public void makePdf(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String userName) throws Exception {

        String url = httpServletRequest.getScheme() + "://" + httpServletRequest.getServerName() + ":" + httpServletRequest.getServerPort()
                + httpServletRequest.getContextPath() + "/";
        // 这里可根据你自己的逻辑生成html并转换成字符串，注意html中的标签要闭合
        String html = "";
        if (StringUtils.isEmpty(userName)) {
            html = "<img src=\"" + url + "images/IMG41.jpg\"/><p style=\"color:red;font-size:12px;\">小明。。。 男|4 岁 (2015-09-03)|现居住北京|0年工作经验 </p>";
        } else {
            html = "<img src=\"" + url + "images/IMG41.jpg\"/><p style=\"color:red;font-size:12px;\">" + userName + " 男|4 岁 (2015-09-03)|现居住北京|0年工作经验 </p>";
        }
        String fileName = System.currentTimeMillis() + ".pdf";

        httpServletRequest.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("application/pdf");
        httpServletResponse.addHeader("Content-Disposition", "attachment;filename=" + new String((fileName).getBytes(), "iso-8859-1"));

        OutputStream outputStream = httpServletResponse.getOutputStream();
        HtmlToPdf.htmlToPdf(html, outputStream);
        outputStream.close();
    }



    /**
     * 请求url为/push/{xiaoming}
     *
     */
    @RequestMapping("/push/{userName}")
    public void makeWorld(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable String userName) throws Exception {

        String url = httpServletRequest.getScheme() + "://" + httpServletRequest.getServerName() + ":" + httpServletRequest.getServerPort()
                + httpServletRequest.getContextPath() + "/";
        // 这里可根据你自己的逻辑生成html并转换成字符串，注意html中的标签要闭合
        String html = "";
        if (StringUtils.isEmpty(userName)) {
            html = "<img src=\"" + url + "images/IMG41.jpg\"/><p style=\"color:red;font-size:12px;\">小明。。。 男|4 岁 (2015-09-03)|现居住北京|0年工作经验 </p>";
        } else {
            html = "<img src=\"" + url + "images/IMG41.jpg\"/><p style=\"color:red;font-size:12px;\">" + userName + " 男|4 岁 (2015-09-03)|现居住北京|0年工作经验 </p>";
        }
        String fileName = System.currentTimeMillis() + ".doc";

        httpServletRequest.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("application/msword");
        httpServletResponse.addHeader("Content-Disposition", "attachment;filename=" + new String((fileName).getBytes(), "iso-8859-1"));

        OutputStream outputStream = httpServletResponse.getOutputStream();
        HtmlToWorld.htmlToWorld(html, outputStream);
        outputStream.close();
    }


}
