package com.example;

import sun.nio.ch.FileChannelImpl;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;
import java.util.Set;

public class ModuleTest {
    public static void demonstrateInternalApiAccess() throws Exception {
        // Demonstrate access to internal sun.nio.ch API
        File tempFile = File.createTempFile("test", ".tmp");
        FileChannel channel = FileChannel.open(tempFile.toPath(), StandardOpenOption.READ);
        FileChannelImpl impl = (FileChannelImpl) channel;
        
        // Demonstrate reflection access
        Field field = String.class.getDeclaredField("value");
        field.setAccessible(true);
        
        // Clean up
        channel.close();
        tempFile.delete();
    }
    
    public static void demonstrateReflection() throws Exception {
        Method method = String.class.getDeclaredMethod("indexOf", String.class, int.class);
        method.setAccessible(true);
        Integer result = (Integer) method.invoke("test string", "string", 0);
        System.out.println("Found at index: " + result);
    }
}

