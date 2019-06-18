package com.research.file;

import com.itextpdf.text.Font;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;

import java.net.URL;

/**
 * 转pdf时需要使用的类，用来进行中文字符的显示
 *
 * @author shc
 * @date 2018-06-18
 **/
public class AsianFontProvider extends XMLWorkerFontProvider {

    @Override
    public Font getFont(final String fontName, String encoding, float size, final int style) {
        String fontUrl = fontName;
        if (fontUrl == null) {
            // SpringBoot中将simsun.ttf作为资源文件引入或直接放在类路径下引入
            URL resource = AsianFontProvider.class.getResource("/simsun.ttf");
            fontUrl = resource.toString();
        }
        if (size == 0) {
            size = 4;
        }
        return super.getFont(fontUrl, encoding, size, style);
    }
}

