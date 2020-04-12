# Essential Unix Commands

 We may need to have a few basic Unix commands to help us with the manipulation of C Programs in the *WLS* (Windows for Linux SubSystem).

## Operating System Commands

| Command  |  Purpose  | Remarks |
| ------ | ------- | ----- |
| `ls`     | * To list the files in a directory. | * Similar to the `dir` command in Windows. * The output will just contain only the file names. |
| `ls -l`  | * to have a long listing of files in a directory | The output will have all the files and the other attributes such as the user, group, file size, modified date etc., |
| `ls -ltr`| * To have a long listing (`l`) of files, arranged in the reverse order (`r`) based on the modification time (`t`) of each file.  | * Useful to see the files in their modification order. |
| `pwd`    | To get to know the current working directory. | `pwd` stands for `present working directory`. |
| `cp`     | To copy one file to another file. | *Usage*: `cp file1 file2` will copy the contents of `file1` to `file2`. * You can also specify the diretory if you wish to copy it to a different directory. |
| `mv`     | To rename a file to a new name. | *Usage*: `mv file1 file2` - will modify the name of the file `file1` to `file2`. * Here again you can specify the directory name if you wish to move the file to a different directory. |
| `rm`     | To delete a file from the directory. | *Usage:* `rm fileName` - will remove/delete the file `fileName`. |
| `mkdir`  | To make/create a new directory.  | *Usage:* `mkdir cPrograms` - will create a new directory called `cPrograms`. |
| `gcc`    | To invoke the GNU C Compiler to compile a C Program. | *Usage:* `gcc HelloWorld.c` - will compile the program written inside a file called `HelloWorld.c` and produce an intermediate file called `a.out` in the same directory. |
| `gcc with -o flag` | To invoke the GNU C Compiler with an output file name flag. | *Usage:* `gcc HelloWorld.c -o HelloWorld.out` - will compile the program written in a file called `HelloWorld.c` and generate the compiled version of the file (intermediate file) in `HelloWorld.out`.| 

## Editor Commands

### Vi/Vim Editor 

 * Vi Editor has 3 modes. 
   * Command Mode (default) - that takes the commands to operate upon the file and the contents inside the file.
   * Insert Mode - the mode that allows the user to type in the contents. To activate this mode, the user has to press the `i` key. To come back to the command mode, weneed to press the `Esc` key.
   * Visual mode - to select a block of text and manipulate them - copy, cut, paste etc., To enable this we need to press `v` key and to come back to the command mode, we need to press the `Esc` key.

#### Step by Step commands 

 * To open a file, use `vi fileName`. For example, to open a file named `HelloWorld.c`, use the command `vi HelloWorld.c`. The Vi editor will open the file `HelloWorld.c` if already exists, else it will create a new file in that name. 
 * Press `i` to go to Insert mode.
 * Once we are in the *Insert* mode in Vi, the follwing keys are to be pressed.
  * Arrow Keys for navigation - left, right, up and down to move the cursor to the different portion of the file.
  * `:w` is to save the contents of the file, similar to *Ctrl+S* in Windows.
  * `:q' is to quit the editor, similar to *Ctrl+X* in Windows.
  * `:wq` is to invoke both the commands together *write and quit*.

### Nano Editor

 Nano editor is very easy like Notepad in Windows.

 * To save a file, press `Ctrl+S` together.
 * To exit from a file, press `Ctrl+X` together.
 * Arrow keys will work for the navigation across the file for moving the cursor to up, down, left and right.
