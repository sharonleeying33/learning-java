
package org.learning.java.nio.file.attribute;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class BasicFileAttributesDemo {
    
    public static void main(String[] args) {
        filesReadAttribute();
    }
    
    
    public static void filesReadAttribute() {
        
        Path file = Paths.get("/Downloads");
        try {
            BasicFileAttributes basicFileAttribute = Files.readAttributes(file, BasicFileAttributes.class);
            System.out.println("isRegular = " + basicFileAttribute.isRegularFile());
            System.out.println("isOther = " + basicFileAttribute.isOther());
            
            
        } catch (IOException ex) {
            
        }
    }
    
}
