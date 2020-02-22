# Git Commands and Errors

## 'pathspec (x) did not match any file error' while committing via git command line?

### Error 

```C:\rags\TechNotes\vimNotes (master)
λ git commit -m 'vimCommands updated'
error: pathspec 'updated'' did not match any file(s) known to git.
```

### Reason
The reason being the actual commit message was surrounded by a single quote and
it was not recognized in the  Windows OS. Hence the error message was thrown.

### Fix
Use a double quotes, which is the only other way in Windows. 

### Output
```
C:\rags\TechNotes\vimNotes (master)
λ git commit -m "vimcommands updated with a TODO element for the pending items"
[master warning: LF will be replaced by CRLF in vimNotes/vimEditorCommands.md.
The file will have its original line endings in your working directory.
2d96107] vimcommands updated with a TODO element for the pending items
warning: LF will be replaced by CRLF in vimNotes/vimEditorCommands.md.
The file will have its original line endings in your working directory.
 1 file changed, 8 insertions(+), 7 deletions(-)
```

