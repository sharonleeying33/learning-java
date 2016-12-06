
package org.learning.java.nio.file;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * 
 */
public class PathDemo {
    
    public static void main(String[] args) {
        
       
        System.out.print(relativize());  // ../Project/learning-java
        relativize();
        
    }
    
    /**
     * 路徑切換
     * @return 
     */
    public static Path relativize() {
    
        Path path1 = Paths.get(System.getProperty("user.home"), "Downloads");
        Path path2 = Paths.get(System.getProperty("user.home"), "Project", "learning-java");
        return path1.relativize(path2);
    }
    
}
