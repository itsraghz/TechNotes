# Git FAQ

#TODO for the pending questions.

## What is the difference between commit -a and commit -m in git?

   Using the '-a' flag automaticaly adds the tracked files to the staging area (in other words, it performs a `git add` on all files which you already tracked before).  And, the '-m' flag simply lets you apply the commit message.  So, for the first commit on the project, you can't use '-a' flag as no files have been `add`ed yet.
  
   > *Need to verify this*.

## Git keeps asking me to enter credentials for everytime I issue `git push` for the repo. How do I stop?

  Have been reading on the Internet for the resolution. They suggest to use either SSH or a different approach. #TBD to complete this. 

### Command Output (Sample) for entering the credentials during the `git push`
```
C:\rags\TechNotes\gitNotes (master)
λ git push
Username for 'https://github.com': itsraghz
Password for 'https://itsraghz@github.com':
Counting objects: 5, done.
Delta compression using up to 4 threads.
Compressing objects: 100% (5/5), done.
Writing objects: 100% (5/5), 1.14 KiB | 0 bytes/s, done.
Total 5 (delta 2), reused 0 (delta 0)
remote: Resolving deltas: 100% (2/2), completed with 2 local objects.
To https://github.com/itsraghz/TechNotes.git
   2d96107..6b1bcf3  master -> master
```

## How do I add a hash (#) as part of my markdown/github markdown text?
Ideally you should escape it as like any other syntax oriented language. However, in the markdown you can simply use it with a single hash (#) without any
space before or after - depending on where the hash is supposed to be present. 

> The beginning character like a hashtag (#github) , or a ending character like a Programming Language `C#`.  
> If it is prefixed with a # and a space, (# #github) &rarr; will render the content (#github) as a H1 tag tag, for example.

## How do I add a line break in the markdown - like &lt;br/&gt; tag? 

A comment from the original Markdown Syntax says,

> The implication of the "one or more consecutive lines of text" rule is that Markdown supports "hard-wrapped" text paragraphs. This differs significantly from most other text-to-HTML formatters (including Movable Type's "Convert Line Breaks" option) which translate every line break character in a paragraph into a <br /> tag.

#### Possible Suggestions and options

  * When you do want to insert a &lt;br/&gt; break tag using Markdown, you end a line with two or more spaces, then type return.
  * To force a line return, place two empty spaces at the end of a line.
  * Add `&amp;nbsp;` a few times (2 or more) to  have a line space issues while rendering
  * Just add a backslash `\` at the end of the line where you need a line break, and it is much better than the whitespaces as it would be visible


Link : https://stackoverflow.com/questions/33191744/how-to-add-new-line-in-markdown-presentation/33191810

## How does the `git add` command work OR does the `git add` command works depending on the directory from which it is invoked? 

Yes, the git add works in such a way that it adds all the files (recursively) in all the folders, with respect to the current folder from where
it is invoked. In case, there are files modified but present outside this particular directory from where `git add` was invoked, this command
will *NOT* any effects on those files. 

### Example - Issue 

See now the `git add` command is issued from a particular sub directory but the subsequent `git status` command still says that a file is being left out and waiting to be added further. 

> Always ensure you issue/invoke the `git add` command from the root/parent directory of the repository so as to get all the files being added/modified
in a recursive manner for that repository. 

```
C:\rags\TechNotes\javaNotes\javaPrograms\basics (master)
λ git add .

C:\rags\TechNotes\javaNotes\javaPrograms\basics (master)
λ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Untracked files:
  (use "git add <file>..." to include in what will be committed)

        ../output/basics/3_Output_JavaPgmWithIfAndElseIf.md

nothing added to commit but untracked files present (use "git add" to track)
```

### Example - Fix (change the directory on shell before you issue the `git add`)
```
C:\rags\TechNotes\javaNotes\javaPrograms\basics (master)
λ cd ..\..

C:\rags\TechNotes\javaNotes (master)
λ git add .
warning: LF will be replaced by CRLF in javaNotes/javaPrograms/output/basics/3_Output_JavaPgmWithIfAndElseIf.md.
The file will have its original line endings in your working directory.

C:\rags\TechNotes\javaNotes (master)
λ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes to be committed:
  (use "git reset HEAD <file>..." to unstage)

        new file:   javaPrograms/output/basics/3_Output_JavaPgmWithIfAndElseIf.md


C:\rags\TechNotes\javaNotes (master)
λ
```

Now you see the file left out earlier being considered while adding for staging, and the subsequent invocation of `git status` reflects the same by showing the file newly being added. 

