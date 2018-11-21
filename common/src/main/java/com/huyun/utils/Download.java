package com.huyun.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class Download {
    public void download(String path, String Filename, HttpServletRequest request, HttpServletResponse response) {
        String fileName = Filename;
        try {
            request.setCharacterEncoding("utf-8");
            fileName = new String(fileName.getBytes("iso-8859-1"), "utf-8");
            //获取文件路径
            String filePath = path+ fileName;
            filePath = filePath == null ? "" : filePath;
            //设置向浏览器端传送的文件格式
            response.setContentType("application/x-msword");

            fileName = URLEncoder.encode(fileName, "UTF-8");
            response.addHeader("Content-Disposition", "attachment;filename="
                    + fileName);
            FileInputStream fis = null;
            OutputStream os = null;
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(filePath);
                byte[] b = new byte[1024 * 10];
                int i = 0;
                while ((i = fis.read(b)) > 0) {
                    os.write(b, 0, i);
                }
                os.flush();
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (os != null) {
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
