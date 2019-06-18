package com.research.file;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;

/**
 *
 *
 * @author shc
 * @date 2018-06-18
 **/
public class HtmlToWorld {

    public static void htmlToWorld(String html, OutputStream outputStream) throws Exception{

        // 这里是必须要设置编码的，不然导出中文就会乱码。
        byte b[] = html.getBytes("utf-8");
        // 将字节数组包装到流中
        ByteArrayInputStream inputStream = new ByteArrayInputStream(b);

        // 关键地方 生成word格式
        POIFSFileSystem poifsFileSystem = new POIFSFileSystem();
        DirectoryEntry directory = poifsFileSystem.getRoot();
        DocumentEntry documentEntry = directory.createDocument("WordDocument", inputStream);

        poifsFileSystem.writeFilesystem(outputStream);

        inputStream.close();
    }

}
