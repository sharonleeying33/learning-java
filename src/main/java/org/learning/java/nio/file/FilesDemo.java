
package org.learning.java.nio.file;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Map;
import static java.lang.System.out;
import java.nio.file.DirectoryStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * 
 */
public class FilesDemo {
    
    public static void main(String[] args) {

        newDirectoryStream2();
    }
    
    public static void readAttributes() {
        
        Path path = Paths.get("/home/ubuntu/.profile");
        try {
            Map<String, Object> atts = Files.readAttributes(path, "size,lastModifiedTime");
            System.out.println(path.toString() + " size = " + atts.get("size"));
            
        } catch (IOException ex) {
            
        }
    }
    
    
    public static void getFileStore() {
        FileSystem fs = FileSystems.getDefault();
        for(FileStore store : fs.getFileStores()) {
            try {
                long total = store.getTotalSpace();
                long used = store.getTotalSpace() - store.getUnallocatedSpace();
                DecimalFormat formatter = new DecimalFormat("#,###,###");
                System.out.println(store.toString());
                out.printf("\t~total\t%s\t位元組%n", formatter.format(total));
                out.printf("\t~used\t%s\t位元組%n", formatter.format(used));
            } catch (IOException ex) {
                
            }
        }
    }
    
    public static void readAllBytes() {
        System.out.println("readAllBytes ... ");
        try {
            String content = new String(Files.readAllBytes(Paths.get("/Desktop/test")));
            System.out.println(content);
        } catch (IOException e) {
           
        }
    }
    
    public static void readAllLines() {
        System.out.println("readAllLines ... ");
        try (Stream<String> lines = Files.lines(Paths.get("/Desktop/test"))) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
           
        }
    }
    
    public static void newDirectoryStream() {
        System.out.println("newDirectoryStream ... ");
        Path path = Paths.get("/Desktop");
        try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
            List<String> files = new ArrayList<>();
            for(Path path2 : directoryStream) {
                if(Files.isDirectory(path2)) {
                    out.printf("[%s]%n", path.getFileName());
                } else {
                    files.add(path.getFileName().toString());
                }
            }
            System.out.println("Files ... ");
            files.forEach(out::println);
        } catch (IOException exp) {
        
        }
    }
    
    /**
     * 取得jar, class files
     */
    public static void newDirectoryStream2() {
        System.out.println("newDirectoryStream2 ... ");
        try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("/Desktop/tmp"), "*.{class,jar}")) {
           
            directoryStream.forEach(path -> out.println(path.getFileName()));
        } catch(IOException exp) {
        
        }
       
    
    }
    
}
