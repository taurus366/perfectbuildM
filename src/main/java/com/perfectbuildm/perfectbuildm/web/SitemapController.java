package com.perfectbuildm.perfectbuildm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Controller
public class SitemapController {

    @GetMapping(value = "/sitemap.xml")
    public void serveSiteMapFile(HttpServletResponse response) throws IOException {

        response.setContentType("application/xml");
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(new File("src/main/resources/sitemap.xml")))) {
            String line;
            StringBuilder siteMapBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                siteMapBuilder.append(line);
            }
            ServletOutputStream outStream = response.getOutputStream();
            outStream.println(siteMapBuilder.toString());
            outStream.flush();
            outStream.close();
        }
    }

}
