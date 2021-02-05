# Output -`git status -s`

The `git status` command generally gives you the verbose output with the meaningful text and the list of files being modified if any on the underlying repository. However, at times we may need to quickly refer the list of files alone, not the verbose text. In such cases, the `-s` argument helps to restrict the output to be short (and sweet :)).

## Output 1

```
raghs@Raghs-LegionY540-TPIN MINGW64 /c/raghs/prfsnl/github-repos/TechNotes/springNotes/springBootNotes/demo/spring-boot-rest (master)
$ git status
On branch master
Your branch is up to date with 'origin/master'.

Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        new file:   spring-io-demo-restservice/jar-executable-raghs/README.md
        new file:   spring-io-demo-restservice/jar-executable-raghs/restservice-0.0.1-SNAPSHOT.jar


raghs@Raghs-LegionY540-TPIN MINGW64 /c/raghs/prfsnl/github-repos/TechNotes/springNotes/springBootNotes/demo/spring-boot-rest (master)
$ git status -s
A  spring-io-demo-restservice/jar-executable-raghs/README.md
A  spring-io-demo-restservice/jar-executable-raghs/restservice-0.0.1-SNAPSHOT.jar

```

## Output 2

```
C:\raghs\prfsnl\github-repos\TechNotes\gitNotes (master -> origin)
? git status
On branch master
Your branch is up to date with 'origin/master'.

Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        modified:   gitCommands-summary.md
        new file:   output/6_git_status-s_output.md


C:\raghs\prfsnl\github-repos\TechNotes\gitNotes (master -> origin)
? git status -s
M  gitCommands-summary.md
A  output/6_git_status-s_output.md
```
