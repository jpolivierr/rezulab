package com.appvenir.rezulab.admin.system;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class IO {

    public static String getFileContent(String path)
    {
        Path filePath = Paths.get(path);

        try (BufferedReader bufferedReader = Files.newBufferedReader(filePath)) {
            String line;
            StringBuilder content = new StringBuilder();
            while((line = bufferedReader.readLine()) != null)
            {
                content.append(line).append("\n");
            }
            return content.toString();

        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    }
    
}
