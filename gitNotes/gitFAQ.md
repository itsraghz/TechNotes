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

        
When you do want to insert a &lt;br/&gt; break tag using Markdown, you end a line with two or more spaces, then type return.

Link : https://stackoverflow.com/questions/33191744/how-to-add-new-line-in-markdown-presentation/33191810


