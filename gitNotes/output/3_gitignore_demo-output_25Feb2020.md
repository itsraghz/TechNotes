# .gitignore file added, terminal output to see the .class file not being added

## contents of the .gitignore file 

```
C:\rags\TechNotes (master)
¿ cat .gitignore
# git ignore file

# Ignore the compiled .class files from being tracked
**/*.class
```

## git staged actions to verify that the contents of .gitignore in action

### `git pull` to verify the repo sync status, to avoid any conflicts
```
C:\rags\TechNotes (master)
¿ git pull
Already up-to-date.
```

### `git status` to see the latest changes in files/repo
```
C:\rags\TechNotes (master)
¿ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Untracked files:
  (use "git add <file>..." to include in what will be committed)

        .gitignore
        javaNotes/javaPrograms/basics/enum/

nothing added to commit but untracked files present (use "git add" to track)
```

### `git add` to get them added - only then can see how the traction goes
```
C:\rags\TechNotes (master)
¿ git add .
warning: LF will be replaced by CRLF in .gitignore.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in javaNotes/javaPrograms/basics/enum/JavaEnumDemo.java.
The file will have its original line endings in your working directory.
```

### `git status` now will show only the .java file being added, ignoring the .class files present in the same folder
```
C:\rags\TechNotes (master)
¿ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

        new file:   .gitignore
        new file:   javaNotes/javaPrograms/basics/enum/JavaEnumDemo.java

```

### Usual process further to commit and push
```
C:\rags\TechNotes (master)
¿ git commit -m ".gitignore added to exclude .class files, JavaEnumDemo added"
[master cd19573] .gitignore added to exclude .class files, JavaEnumDemo added
warning: LF will be replaced by CRLF in .gitignore.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in javaNotes/javaPrograms/basics/enum/JavaEnumDemo.java.
The file will have its original line endings in your working directory.
 2 files changed, 52 insertions(+)
 create mode 100644 .gitignore
 create mode 100644 javaNotes/javaPrograms/basics/enum/JavaEnumDemo.java

C:\rags\TechNotes (master)
¿ git push
Username for 'https://github.com': itsraghz
Password for 'https://itsraghz@github.com':
Counting objects: 8, done.
Delta compression using up to 4 threads.
Compressing objects: 100% (7/7), done.
Writing objects: 100% (8/8), 1.18 KiB | 0 bytes/s, done.
Total 8 (delta 2), reused 0 (delta 0)
remote: Resolving deltas: 100% (2/2), completed with 2 local objects.
To https://github.com/itsraghz/TechNotes.git
   357ec4e..cd19573  master -> master

C:\rags\TechNotes (master)
¿
```
