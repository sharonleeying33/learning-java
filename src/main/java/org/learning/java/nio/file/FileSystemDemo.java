
package org.learning.java.nio.file;

import java.io.IOException;
import static java.lang.System.out;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

/**
 *
 * 
 */
public class FileSystemDemo {
    
    public static void main(String args[]) {
        getPathMatcher();
    }
    
    /**
     * 取得jar, class files
     */
    public static void getPathMatcher() {
        System.out.println("getPathMatcher ...");
        
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*{class,jar}");
        try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("/Desktop/tmp"))) {
            directoryStream.forEach(path -> {
                if(matcher.matches(path.getFileName())) {
                     out.println("matches:" + path.getFileName());
                }
            });
        } catch(IOException exp) {
        
        }
        
    }
    
}
