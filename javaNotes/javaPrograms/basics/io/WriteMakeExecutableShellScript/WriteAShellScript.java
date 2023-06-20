import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class WriteAShellScript
{
    public static void main(String... args)
    throws IOException
    {
        //First, let us keep the content of the script file ready
        //We use var construct introduced in Java 10, 
        // and the text blocks which was introduced in Java 13.
        var script = """
        #!/bin/bash
        echo "hello, world - via Java Program"
        """;

        //Let's write the content into a file, and store it 
        // in the FileSystem by specifying the file name.
        // As no directory is mentioned, it would be stored in
        // the current directory where this Program is executed.
        var path = Files.writeString(Path.of("hello.sh"), script);

        // A confirmation message to the user
        System.out.println("File [hello.sh] has been written");
    }
}
