import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.Set;
import java.nio.file.attribute.PosixFilePermission;

public class WriteAndMakeExecutableShellScript
{
    public static void main(String... args)
    throws IOException
    {
        var script = """
         #!/bin/bash
         echo "hello, world - via Java Program"
        """;

	/* This time, we will write to a different file for a quick comparsion */
        var path = Files.writeString(Path.of("hello.sh"), script);

        System.out.println("File [hello.sh] has been written");
    
        /* Set the File permission with the meaningful methods.
        setPosixFilePermission method takes two arguments:
         1. The path to the target file
         2. A `java.util.Set` that takes the list of permissions,
            each denoted by a predefinex constant defined 
            in the `PosixFilePermission` class. 
            `OWNER_XXX` for Owners, 
            `GROUP_XXX` for the Group, 
            and `OTHERS_XXX` for Others, 
            where the XXX can be of any `READ`, `WRITE`, `EXECUTE`.
        */
        Files.setPosixFilePermissions(path, 
            Set.of(PosixFilePermission.OWNER_READ, PosixFilePermission.OWNER_EXECUTE));

        System.out.println("The file permissions are set to be executed by the User!");
    }
}
