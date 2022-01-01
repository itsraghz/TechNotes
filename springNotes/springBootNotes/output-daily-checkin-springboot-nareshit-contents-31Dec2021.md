# Daily Check in of contents of SpringBoot MicroServices Class Notes 

## Commands (OS, Git)

```
```

## Console Output with Commands 

```
C:\Users\Raghavan Muthu
? cd \raghs\prfsnl\github-repos\TechNotes\springNotes\springBootNotes\

C:\raghs\prfsnl\github-repos\TechNotes\springNotes\springBootNotes (master -> origin)
? git status
On branch master
Your branch is ahead of 'origin/master' by 1 commit.
  (use "git push" to publish your local commits)

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   NareshiTechnologies-SpringBootMicroServiceCourse/000_ReadMe.md

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        NareshiTechnologies-SpringBootMicroServiceCourse/63_Session63_31Dec2021_Fri_SpringCloud-Maven-Project.md
        NareshiTechnologies-SpringBootMicroServiceCourse/Screenshot Images/Session63-31Dec2021 Fri/

no changes added to commit (use "git add" and/or "git commit -a")

C:\raghs\prfsnl\github-repos\TechNotes\springNotes\springBootNotes (master -> origin)
? git add .
warning: LF will be replaced by CRLF in springNotes/springBootNotes/NareshiTechnologies-SpringBootMicroServiceCourse/000_ReadMe.md.
The file will have its original line endings in your working directory

C:\raghs\prfsnl\github-repos\TechNotes\springNotes\springBootNotes (master -> origin)
? git status
On branch master
Your branch is ahead of 'origin/master' by 1 commit.
  (use "git push" to publish your local commits)

Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        modified:   NareshiTechnologies-SpringBootMicroServiceCourse/000_ReadMe.md
        new file:   NareshiTechnologies-SpringBootMicroServiceCourse/63_Session63_31Dec2021_Fri_SpringCloud-Maven-Project.md
        new file:   NareshiTechnologies-SpringBootMicroServiceCourse/Screenshot Images/Session63-31Dec2021 Fri/SB730AM_31122021_1.png


C:\raghs\prfsnl\github-repos\TechNotes\springNotes\springBootNotes (master -> origin)
? git commit -m "Added | SpringBoot MicroServices - Naresh i Technologies - Session63-31Dec2021-Fri (Initial contents) + screenshots, ReadMe.md updated"
[master 1dbea66] Added | SpringBoot MicroServices - Naresh i Technologies - Session63-31Dec2021-Fri (Initial contents) + screenshots, ReadMe.md updated
 3 files changed, 45 insertions(+)
 create mode 100644 springNotes/springBootNotes/NareshiTechnologies-SpringBootMicroServiceCourse/63_Session63_31Dec2021_Fri_SpringCloud-Maven-Project.md
 create mode 100644 springNotes/springBootNotes/NareshiTechnologies-SpringBootMicroServiceCourse/Screenshot Images/Session63-31Dec2021 Fri/SB730AM_31122021_1.png

C:\raghs\prfsnl\github-repos\TechNotes\springNotes\springBootNotes (master -> origin)
? git push
Enter passphrase for key '/c/Users/Raghavan Muthu/.ssh/id_rsa':
Enumerating objects: 26, done.
Counting objects: 100% (26/26), done.
Delta compression using up to 8 threads
Compressing objects: 100% (20/20), done.
Writing objects: 100% (20/20), 280.48 KiB | 2.65 MiB/s, done.
Total 20 (delta 13), reused 0 (delta 0), pack-reused 0
remote: Resolving deltas: 100% (13/13), completed with 6 local objects.
remote:
remote: GitHub found 11 vulnerabilities on itsraghz/TechNotes's default branch (3 critical, 4 high, 4 moderate). To find out more, visit:
remote:      https://github.com/itsraghz/TechNotes/security/dependabot
remote:
To github.com:itsraghz/TechNotes.git
   8b875c0..1dbea66  master -> master

C:\raghs\prfsnl\github-repos\TechNotes\springNotes\springBootNotes (master -> origin)
? git log --oneline -n 20
1dbea66 (HEAD -> master, origin/master, origin/HEAD) Added | SpringBoot MicroServices - Naresh i Technologies - Session63-31Dec2021-Fri (Initial contents) + screenshots, ReadMe.md updated
2cb78f0 Added | SpringBoot MicroServices - Naresh i Technologies - Session62-29Dec2021-Wed (Initial contents) + screenshots, ReadMe.md updated
8b875c0 Added | SpringBoot MicroServices - Naresh i Technologies - Session61-28Dec2021-Tue (Initial contents) + screenshots, ReadMe.md updated
ba232d4 Added | SpringBoot MicroServices - Naresh i Technologies - Session59-27Dec2021-Mon (Initial contents) + screenshots, ReadMe.md updated
902bf54 Added | SpringBoot MicroServices - Naresh i Technologies - Session59-24Dec2021-Fri (Initial contents) + screenshots, ReadMe.md updated
d53a0e0 Updated | Session57 and Session58 - 21 and 23 Dec 2021
d18ef43 Added | SpringBoot MicroServices - Naresh i Technologies - Session58-23Dec2021-Thu (Initial contents) + screenshots, ReadMe.md updated
e2596ab Added | SpringBoot MicroServices - Naresh i Technologies - Session57-21Dec2021-Tue (Initial contents) + screenshots, ReadMe.md updated
7f4a55a Added | SpringBoot MicroServices - Naresh i Technologies - Session56-20Dec2021-Mon (Initial contents) + screenshots, ReadMe.md updated
d130063 Added | SpringBoot MicroServices - Naresh i Technologies - Session55-18Dec2021-Sat (Initial contents) + screenshots, ReadMe.md updated
f7e957a Added | SpringBoot MicroServices - Naresh i Technologies - Session54-17Dec2021-Fri (Initial contents) + screenshots, ReadMe.md updated
1b344d8 Added | SpringBoot MicroServices - Naresh i Technologies - Session53-16Dec2021-Thu (Initial contents) + screenshots, ReadMe.md updated
0e6d059 Added | SpringBoot MicroServices - Naresh i Technologies - Session53-16Dec2021-Thu (Initial contents) + screenshots, ReadMe.md updated
4e3db4a Added | SpringBoot MicroServices - Naresh i Technologies - Session52-14Dec2021-Tue (Initial contents) + screenshots, ReadMe.md updated
e36e3e2 Added | SpringBoot MicroServices - Naresh i Technologies - Session51-13Dec2021-Mon (Initial contents) + screenshots, ReadMe.md updated
e5c23a5 Added | SpringBoot MicroServices - Naresh i Technologies - Session50-11Dec2021-Sat (Initial contents) + screenshots, ReadMe.md updated
bb55941 Added | SpringBoot MicroServices - Naresh i Technologies - Session49-10Dec2021-Fri (Initial contents) + screenshots, ReadMe.md updated
02f9a09 Added | SpringBoot MicroServices - Naresh i Technologies - Screenshot Images added - for Session42 to Session 48
2b10e3b Added | SpringBoot MicroServices - Naresh i Technologies - Session48-07Dec2021-Tue (Initial contents), ReadMe.md updated (with screenshot tracker)
566ede9 Added | SpringBoot MicroServices - Naresh i Technologies - Session47-06Dec2021 (Initial contents), ReadMe.md updated

C:\raghs\prfsnl\github-repos\TechNotes\springNotes\springBootNotes (master -> origin)
?
```
