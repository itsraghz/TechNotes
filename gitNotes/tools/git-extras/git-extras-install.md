# git-extras install 

## About the tool

  A nice utiliity on Git, used a wrapper for certain commands with a shortcut to achieve things quickly. 

  As per the home page, it does mention about the following commands.

  |   Command    |   Description                  |
  | ------------ | ------------------------------ |
  | git-ignore   | git-ignore is a convenient extra that allows you to manually add file types and comments to the .git-ignore file without having to open a text editor. It works with both the global ignore file for your user account and the individual ignore file for the repository you are working in.|
  | git-info     | git-info retrieves all the information you need to get your head in the context of a repo you are working with. It includes any remote URLs, remote branches, local branches, configuration info, and the last commit. |
  | git-mr and git-pr  | These extras do similar things and work in basically the same way.      git-mr checks out a merge request from GitLab     git-pr checks out a pull request on GitHub. |
  | git-relese   | By combining commit, tag, and push into a single command, git-release saves a lot of keystrokes for executing three commands that often run in sequence. |

  *Note*: Read the documentation for the full list of commands, and also the detailed usage of the commands mentioned above. 

## Links

 * https://opensource.com/article/20/4/git-extras
 * https://github.com/tj/git-extras
 * https://github.com/tj/git-extras/blob/master/Installation.md
 * Video link for the Introduction : https://vimeo.com/45506445

## Terminal Output

  * It required to run it on the Command Prompt where it found the 'mgnw64' directory.
  * Tried in `Cmder` first, and then in `Git Bash` and finally opened up the normal `Command Window` in Windows OS.

```
raghs@LAPTOP-63DBKP7Q MINGW64 ~ (master)
$ pwd
/c/Users/ragha

raghs@LAPTOP-63DBKP7Q MINGW64 ~ (master)
$ where git
C:\installedSoft\Git\mingw64\bin\git.exe
C:\installedSoft\Git\cmd\git.exe

raghs@LAPTOP-63DBKP7Q MINGW64 ~ (master)
$ cd /c/rags

raghs@LAPTOP-63DBKP7Q MINGW64 /c/rags
$ git clone https://github.com/tj/git-extras.git
Cloning into 'git-extras'...
remote: Enumerating objects: 88, done.
remote: Counting objects: 100% (88/88), done.
remote: Compressing objects: 100% (60/60), done.
remote: Total 6151 (delta 47), reused 51 (delta 28), pack-reused 6063
Receiving objects: 100% (6151/6151), 1.49 MiB | 871.00 KiB/s, done.
Resolving deltas: 100% (3971/3971), done.

raghs@LAPTOP-63DBKP7Q MINGW64 /c/rags
$ cd git-extras/

raghs@LAPTOP-63DBKP7Q MINGW64 /c/rags/git-extras (master)
$ ls
AUTHORS             check_dependencies.sh\*  CONTRIBUTING.md  History.md   Installation.md  man/               Readme.md
bin/                check_integrity.sh\*     etc/             install.cmd  LICENSE          need_git_commit
brew-release.patch  Commands.md             helper/          install.sh\*  Makefile         not_need_git_repo

raghs@LAPTOP-63DBKP7Q MINGW64 /c/rags/git-extras (master)
$ where git
C:\installedSoft\Git\mingw64\bin\git.exe
C:\installedSoft\Git\cmd\git.exe

raghs@LAPTOP-63DBKP7Q MINGW64 /c/rags/git-extras (master)
$ install.cmd /c/installedSoft/Git/mingw64/bin/
bash: install.cmd: command not found

raghs@LAPTOP-63DBKP7Q MINGW64 /c/rags/git-extras (master)
$ install.sh /c/installedSoft/Git/mingw64/bin/
bash: install.sh: command not found

raghs@LAPTOP-63DBKP7Q MINGW64 /c/rags/git-extras (master)
$ ./install.sh /c/installedSoft/Git/mingw64/bin/
Setting up 'git-extras'....
./install.sh: line 8: sudo: command not found

raghs@LAPTOP-63DBKP7Q MINGW64 /c/rags/git-extras (master)
$ cmd /c install.cmd /c/installedSoft/Git/mingw64/bin/
Microsoft Windows [Version 10.0.17763.1158]
(c) 2018 Microsoft Corporation. All rights reserved.

C:\rags\git-extras>install.

C:\rags\git-extras>dir
dir
 Volume in drive C is Windows
 Volume Serial Number is A48B-4AA8

 Directory of C:\rags\git-extras

21-04-2020  09:30    <DIR>          .
21-04-2020  09:30    <DIR>          ..
21-04-2020  09:30               432 .travis.yml
21-04-2020  09:30             3,731 AUTHORS
21-04-2020  09:30    <DIR>          bin
21-04-2020  09:30               733 brew-release.patch
21-04-2020  09:30               185 check_dependencies.sh
21-04-2020  09:30             2,408 check_integrity.sh
21-04-2020  09:30            37,079 Commands.md
21-04-2020  09:30             1,005 CONTRIBUTING.md
21-04-2020  09:30    <DIR>          etc
21-04-2020  09:30    <DIR>          helper
21-04-2020  09:30            55,504 History.md
21-04-2020  09:30             5,055 install.cmd
21-04-2020  09:30               542 install.sh
21-04-2020  09:30             4,992 Installation.md
21-04-2020  09:30             1,137 LICENSE
21-04-2020  09:30             4,042 Makefile
21-04-2020  09:30    <DIR>          man
21-04-2020  09:30               295 need_git_commit
21-04-2020  09:30               236 not_need_git_repo
21-04-2020  09:30               743 Readme.md
              16 File(s)        118,119 bytes
               6 Dir(s)  16,025,710,592 bytes free

C:\rags\git-extras>dir /w
dir /w
 Volume in drive C is Windows
 Volume Serial Number is A48B-4AA8

 Directory of C:\rags\git-extras

[.]                     [..]                    .travis.yml
AUTHORS                 [bin]                   brew-release.patch
check_dependencies.sh   check_integrity.sh      Commands.md
CONTRIBUTING.md         [etc]                   [helper]
History.md              install.cmd             install.sh
Installation.md         LICENSE                 Makefile
[man]                   need_git_commit         not_need_git_repo
Readme.md
              16 File(s)        118,119 bytes
               6 Dir(s)  16,025,710,592 bytes free

C:\rags\git-extras>install.cmd \installedSoft\Git\mingw64\bin
install.cmd \installft\Git\mingw64\bin
Using git install path "\installft\Git\mingw64\bin" as PREFIX, please make sure it's really a
path to the mingw64 directory...

No mingw64 folder found in C:\installft\Git\mingw64.

Please supply a proper "Git for Windows 2.x" install path:
"install.cmd c:\[git-install-path]"

C:\rags\git-extras>install.cmd \installedSoft\Git\
install.cmd \installedSoft\Git\
'install.cmd' is not recognized as an internal or external command,
operable program or batch file.
                exit
exitags\git-extras>

raghs@LAPTOP-63DBKP7Q MINGW64 /c/rags/git-extras (master)
$ cd ..

raghs@LAPTOP-63DBKP7Q MINGW64 /c/rags
$
```

### Installation in Windows Commad Prompt

```
Microsoft Windows [Version 10.0.17763.1158]
(c) 2018 Microsoft Corporation. All rights reserved.

C:\Users\ragha>cd \rags\git-extras

C:\rags\git-extras>dir /w
 Volume in drive C is Windows
 Volume Serial Number is A48B-4AA8

 Directory of C:\rags\git-extras

[.]                     [..]                    .travis.yml             AUTHORS                 [bin]                   brew-release.patch
check_dependencies.sh   check_integrity.sh      Commands.md             CONTRIBUTING.md         [etc]                   [helper]
History.md              install.cmd             install.sh              Installation.md         LICENSE                 Makefile
[man]                   need_git_commit         not_need_git_repo       Readme.md
              16 File(s)        118,119 bytes
               6 Dir(s)  16,025,706,496 bytes free

C:\rags\git-extras>where git
C:\installedSoft\Git\cmd\git.exe

C:\rags\git-extras>install.cmd c:\installedSoft\Git\cmd
Using git install path "c:\installedSoft\Git\cmd" as PREFIX, please make sure it's really a
path to the mingw64 directory...

Installing to c:\installedSoft\Git\cmd
Installing binaries...
Installing man pages...

done

C:\rags\git-extras>git info
git: 'info' is not a git command. See 'git --help'.

Did you mean one of these?
        init
        mailinfo

C:\rags\git-extras>
```

