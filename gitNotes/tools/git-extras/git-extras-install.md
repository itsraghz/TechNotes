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

### Further steps to copy over the `git-extras` executales into `..Git\libexec\` directory

*Note*: Tried this as suggested by Devendra, still did not work. The command line invocation of `git-info` or `git-release` says `command not found` !

```
C:\Users\ragha\Downloads
¿ cd \installedSoft\Git\

C:\installedSoft\Git
¿ ls
LICENSE.txt  ReleaseNotes.html  bin/  cmd/  dev/  etc/  git-bash.exe\*  git-cmd.exe\*  mingw64/  tmp/  unins000.dat  unins000.exe\*  unins000.msg  usr/

C:\installedSoft\Git
¿ cd mingw64\

C:\installedSoft\Git\mingw64
¿ ls
bin/  doc/  etc/  lib/  libexec/  share/  ssl/

C:\installedSoft\Git\mingw64
¿ cd bin

C:\installedSoft\Git\mingw64\bin
¿ ls
WhoUses.exe\*       certtool.exe\*         git-lfs.exe\*             libffi-6.dll\*        libminizip-1.dll\*   libunistring-2.dll\*   tcl86.dll\*
antiword.exe\*      connect.exe\*          git-receive-pack.exe\*    libgcc_s_seh-1.dll\*  libnettle-6.dll\*    libwinpthread-1.dll\*  tclsh.exe\*
bunzip2.exe\*       create-shortcut.exe\*  git-upload-archive.exe\*  libgmp-10.dll\*       libnghttp2-14.dll\*  openssl.exe\*          tclsh86.exe\*
bzcat.exe\*         curl-winssl/          git-upload-pack.exe\*     libgmpxx-4.dll\*      libp11-kit-0.dll\*   p11-kit.exe\*          tk86.dll\*
bzcmp\*             curl.exe\*             git.exe\*                 libgnutls-30.dll\*    libpcre-1.dll\*      p11tool.exe\*          trust.exe\*
bzdiff\*            edit.dll\*             gitk\*                    libgomp-1.dll\*       librtmp-1.dll\*      pdftotext.exe\*        update-ca-trust\*
bzegrep\*           edit_test.exe\*        libatomic-1.dll\*         libhogweed-4.dll\*    libspdylay-7.dll\*   pkcs1-conv.exe\*       wish.exe\*
bzfgrep\*           edit_test_dll.exe\*    libbz2-1.dll\*            libiconv-2.dll\*      libssh2-1.dll\*      psktool.exe\*          wish86.exe\*
bzgrep\*            envsubst.exe\*         libcares-2.dll\*          libidn-11.def        libssp-0.dll\*       recode-sr-latin.exe\*  x86_64-w64-mingw32-agrep.exe\*
bzip2.exe\*         gettext.exe\*          libcharset-1.dll\*        libidn-11.dll\*       libstdc++-6.dll\*    sexp-conv.exe\*        x86_64-w64-mingw32-deflatehd.exe\*
bzip2recover.exe\*  gettext.sh\*           libcurl-4.dll\*           libintl-8.dll\*       libsystre-0.dll\*    sqlite3_analyzer.sh\*  x86_64-w64-mingw32-inflatehd.exe\*
bzless\*            gettextize\*           libeay32.dll\*            libjansson-4.dll\*    libtasn1-6.dll\*     srptool.exe\*          xmlwf.exe\*
bzmore\*            git-cvsserver\*        libexpat-1.dll\*          libmetalink-3.dll\*   libtre-5.dll\*       ssleay32.dll\*         zlib1.dll\*

C:\installedSoft\Git\mingw64\bin
¿ cd \rags\git-extras\

C:\rags\git-extras (master)
¿ ls
AUTHORS          Commands.md  Installation.md  Makefile   bin/                check_dependencies.sh\*  etc/     install.cmd  man/             not_need_git_repo
CONTRIBUTING.md  History.md   LICENSE          Readme.md  brew-release.patch  check_integrity.sh\*     helper/  install.sh\*  need_git_commit

C:\rags\git-extras (master)
¿ cd bin

C:\rags\git-extras\bin (master)
¿ ls
git-alias\*         git-clear-soft\*              git-delta\*         git-ignore-io\*      git-pr\*             git-reset-file\*              git-standup\*
git-archive-file\*  git-coauthor\*                git-effort\*        git-info\*           git-psykorebase\*    git-root\*                    git-summary\*
git-authors\*       git-commits-since\*           git-extras\*        git-local-commits\*  git-pull-request\*   git-rscp                     git-sync\*
git-back\*          git-contrib\*                 git-feature\*       git-lock\*           git-reauthor\*       git-scp\*                     git-touch\*
git-browse\*        git-count\*                   git-force-clone\*   git-locked\*         git-rebase-patch\*   git-sed\*                     git-undo\*
git-brv\*           git-cp\*                      git-fork\*          git-merge-into\*     git-refactor\*       git-setup\*                   git-unlock\*
git-bug\*           git-create-branch\*           git-fresh-branch\*  git-merge-repo\*     git-release\*        git-show-merged-branches\*
git-bulk\*          git-delete-branch\*           git-gh-pages\*      git-missing\*        git-rename-branch\*  git-show-tree\*
git-changelog\*     git-delete-merged-branches\*  git-graft\*         git-mr\*             git-rename-remote\*  git-show-unmerged-branches\*
git-chore\*         git-delete-submodule\*        git-guilt\*         git-obliterate\*     git-rename-tag\*     git-squash\*
git-clear\*         git-delete-tag\*              git-ignore\*        git-paste\*          git-repl\*           git-stamp\*

C:\rags\git-extras\bin (master)
¿ ls -ltrh C:\installedSoft\Git\
LICENSE.txt        cmd\               git-bash.exe       tmp\               unins000.msg
ReleaseNotes.html  dev\               git-cmd.exe        unins000.dat       usr\
bin\               etc\               mingw64\           unins000.exe
C:\rags\git-extras\bin (master)
¿ ls -ltrh C:\installedSoft\Git\mingw64\
bin\      doc\      etc\      lib\      libexec\  share\    ssl\
C:\rags\git-extras\bin (master)
¿ ls -ltrh C:\installedSoft\Git\mingw64\libexec\
git-core\  p11-kit\
C:\rags\git-extras\bin (master)
¿ ls -ltrh C:\installedSoft\Git\mingw64\libexec\
total 0
drwxr-xr-x 1 raghs 197610 0 Apr  1  2017 p11-kit/
drwxr-xr-x 1 raghs 197610 0 Apr  1  2017 git-core/

C:\rags\git-extras\bin (master)
¿ ls -ltrh C:\installedSoft\Git\mingw64\libexec\git-core\
total 272M
-rwxr-xr-x   2 raghs 197610  34K Jul 21  2016 libffi-6.dll\*
-rwxr-xr-x   2 raghs 197610 207K Aug 30  2016 libidn-11.dll\*
-rwxr-xr-x   2 raghs 197610 100K Aug 30  2016 libtasn1-6.dll\*
-rwxr-xr-x   2 raghs 197610 1.6M Oct  8  2016 tcl86.dll\*
-rwxr-xr-x   2 raghs 197610 1.4M Oct  8  2016 tk86.dll\*
-rwxr-xr-x   2 raghs 197610 232K Oct 13  2016 libnettle-6.dll\*
-rwxr-xr-x   2 raghs 197610 202K Oct 13  2016 libhogweed-4.dll\*
-rwxr-xr-x   2 raghs 197610 196K Nov  7  2016 libssh2-1.dll\*
-rwxr-xr-x   2 raghs 197610  74K Nov 28  2016 libjansson-4.dll\*
-rwxr-xr-x   2 raghs 197610  69K Nov 28  2016 libspdylay-7.dll\*
-rwxr-xr-x   2 raghs 197610 157K Nov 30  2016 libexpat-1.dll\*
-rwxr-xr-x   2 raghs 197610  33K Jan 12  2017 libgmpxx-4.dll\*
-rwxr-xr-x   2 raghs 197610 498K Jan 12  2017 libgmp-10.dll\*
-rwxr-xr-x   2 raghs 197610 1.8M Jan 13  2017 libunistring-2.dll\*
-rwxr-xr-x   2 raghs 197610 103K Jan 15  2017 libcares-2.dll\*
-rwxr-xr-x   2 raghs 197610  73K Jan 15  2017 libbz2-1.dll\*
-rwxr-xr-x   2 raghs 197610  92K Jan 17  2017 zlib1.dll\*
-rwxr-xr-x   2 raghs 197610  84K Jan 17  2017 libminizip-1.dll\*
-rwxr-xr-x   2 raghs 197610 276K Jan 17  2017 libpcre-1.dll\*
-rwxr-xr-x   2 raghs 197610  59K Jan 30  2017 libmetalink-3.dll\*
-rwxr-xr-x   2 raghs 197610 408K Jan 31  2017 ssleay32.dll\*
-rwxr-xr-x   2 raghs 197610 2.2M Jan 31  2017 libeay32.dll\*
-rwxr-xr-x   2 raghs 197610 162K Jan 31  2017 libnghttp2-14.dll\*
-rwxr-xr-x   2 raghs 197610 131K Feb 21  2017 libintl-8.dll\*
-rwxr-xr-x   2 raghs 197610 510K Feb 24  2017 libcurl-4.dll\*
-rwxr-xr-x   2 raghs 197610 159K Feb 26  2017 libgomp-1.dll\*
-rwxr-xr-x   2 raghs 197610  82K Feb 26  2017 libgcc_s_seh-1.dll\*
-rwxr-xr-x   2 raghs 197610  39K Feb 26  2017 libatomic-1.dll\*
-rwxr-xr-x   2 raghs 197610 1.4M Feb 26  2017 libstdc++-6.dll\*
-rwxr-xr-x   2 raghs 197610  22K Feb 26  2017 libssp-0.dll\*
-rwxr-xr-x   2 raghs 197610 166K Mar  2  2017 librtmp-1.dll\*
-rwxr-xr-x   2 raghs 197610  92K Mar  2  2017 libtre-5.dll\*
-rwxr-xr-x   2 raghs 197610  18K Mar  2  2017 libsystre-0.dll\*
-rwxr-xr-x   2 raghs 197610 1.1M Mar  6  2017 libiconv-2.dll\*
-rwxr-xr-x   2 raghs 197610  43K Mar  6  2017 libcharset-1.dll\*
-rwxr-xr-x   2 raghs 197610 1.4M Mar  7  2017 libgnutls-30.dll\*
-rwxr-xr-x   2 raghs 197610 989K Mar  7  2017 libp11-kit-0.dll\*
-rwxr-xr-x   1 raghs 197610 137K Mar 13  2017 git-credential-manager.exe\*
-rwxr-xr-x   1 raghs 197610 214K Mar 13  2017 git-askpass.exe\*
-rwxr-xr-x   1 raghs 197610  61K Mar 13  2017 Microsoft.Vsts.Authentication.dll\*
-rwxr-xr-x   1 raghs 197610 199K Mar 13  2017 Microsoft.IdentityModel.Clients.ActiveDirectory.dll\*
-rwxr-xr-x   1 raghs 197610  88K Mar 13  2017 Microsoft.IdentityModel.Clients.ActiveDirectory.Platform.dll\*
-rwxr-xr-x   1 raghs 197610  34K Mar 13  2017 Microsoft.Alm.Git.dll\*
-rwxr-xr-x   1 raghs 197610  41K Mar 13  2017 Microsoft.Alm.Authentication.dll\*
-rwxr-xr-x   1 raghs 197610 288K Mar 13  2017 GitHub.Authentication.exe\*
-rwxr-xr-x   2 raghs 197610  42K Mar 14  2017 edit.dll\*
-rwxr-xr-x   2 raghs 197610  56K Mar 20  2017 libwinpthread-1.dll\*
-rwxr-xr-x   1 raghs 197610 2.1M Mar 27  2017 git.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-write-tree.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-worktree.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-whatchanged.exe\*
-rwxr-xr-x   1 raghs 197610 4.3K Mar 27  2017 git-web--browse\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-verify-tag.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-verify-pack.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-verify-commit.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-var.exe\*
-rwxr-xr-x   1 raghs 197610 1.2M Mar 27  2017 git-upload-pack.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-upload-archive.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-update-server-info.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-update-ref.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-update-index.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-unpack-objects.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-unpack-file.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-tag.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-symbolic-ref.exe\*
-rwxr-xr-x   1 raghs 197610  63K Mar 27  2017 git-svn\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-submodule--helper.exe\*
-rwxr-xr-x   1 raghs 197610  27K Mar 27  2017 git-submodule\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-stripspace.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-status.exe\*
-rwxr-xr-x   1 raghs 197610  14K Mar 27  2017 git-stash\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-stage.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-show.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-show-ref.exe\*
-rwxr-xr-x   1 raghs 197610 1.1M Mar 27  2017 git-show-index.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-show-branch.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-shortlog.exe\*
-rw-r--r--   1 raghs 197610 9.1K Mar 27  2017 git-sh-setup
-rwxr-xr-x   1 raghs 197610 1.1M Mar 27  2017 git-sh-i18n--envsubst.exe\*
-rw-r--r--   1 raghs 197610 2.4K Mar 27  2017 git-sh-i18n
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-send-pack.exe\*
-rwxr-xr-x   1 raghs 197610  51K Mar 27  2017 git-send-email\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-rm.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-revert.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-rev-parse.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-rev-list.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-reset.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-rerere.exe\*
-rwxr-xr-x   1 raghs 197610 3.7K Mar 27  2017 git-request-pull\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-replace.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-repack.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-remote.exe\*
-rwxr-xr-x   1 raghs 197610 1.3M Mar 27  2017 git-remote-https.exe\*
-rwxr-xr-x   1 raghs 197610 1.3M Mar 27  2017 git-remote-http.exe\*
-rwxr-xr-x   1 raghs 197610 1.3M Mar 27  2017 git-remote-ftps.exe\*
-rwxr-xr-x   1 raghs 197610 1.3M Mar 27  2017 git-remote-ftp.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-remote-fd.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-remote-ext.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-reflog.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-receive-pack.exe\*
-rw-r--r--   1 raghs 197610 3.9K Mar 27  2017 git-rebase--merge
-rw-r--r--   1 raghs 197610  29K Mar 27  2017 git-rebase--interactive
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-rebase--helper.exe\*
-rw-r--r--   1 raghs 197610 2.5K Mar 27  2017 git-rebase--am
-rwxr-xr-x   1 raghs 197610  16K Mar 27  2017 git-rebase\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-read-tree.exe\*
-rwxr-xr-x   1 raghs 197610 3.6K Mar 27  2017 git-quiltimport\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-push.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-pull.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-prune.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-prune-packed.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-patch-id.exe\*
-rw-r--r--   1 raghs 197610 2.6K Mar 27  2017 git-parse-remote
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-pack-refs.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-pack-redundant.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-pack-objects.exe\*
-rwxr-xr-x   1 raghs 197610 140K Mar 27  2017 git-p4\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-notes.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-name-rev.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-mv.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-mktree.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-mktag.exe\*
-rw-r--r--   1 raghs 197610 8.7K Mar 27  2017 git-mergetool--lib
-rwxr-xr-x   1 raghs 197610  11K Mar 27  2017 git-mergetool\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-merge.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-merge-tree.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-merge-subtree.exe\*
-rwxr-xr-x   1 raghs 197610  944 Mar 27  2017 git-merge-resolve\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-merge-recursive.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-merge-ours.exe\*
-rwxr-xr-x   1 raghs 197610 3.7K Mar 27  2017 git-merge-one-file\*
-rwxr-xr-x   1 raghs 197610 2.5K Mar 27  2017 git-merge-octopus\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-merge-index.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-merge-file.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-merge-base.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-mailsplit.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-mailinfo.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-ls-tree.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-ls-remote.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-ls-files.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-log.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-interpret-trailers.exe\*
-rwxr-xr-x   1 raghs 197610  19K Mar 27  2017 git-instaweb\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-init.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-init-db.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-index-pack.exe\*
-rwxr-xr-x   1 raghs 197610 1.2M Mar 27  2017 git-imap-send.exe\*
-rwxr-xr-x   1 raghs 197610 1.2M Mar 27  2017 git-http-push.exe\*
-rwxr-xr-x   1 raghs 197610 1.2M Mar 27  2017 git-http-fetch.exe\*
-rwxr-xr-x   1 raghs 197610 1.1M Mar 27  2017 git-http-backend.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-help.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-hash-object.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-grep.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-get-tar-commit-id.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-gc.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-fsck.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-fsck-objects.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-format-patch.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-for-each-ref.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-fmt-merge-msg.exe\*
-rwxr-xr-x   1 raghs 197610  13K Mar 27  2017 git-filter-branch\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-fetch.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-fetch-pack.exe\*
-rwxr-xr-x   1 raghs 197610 1.2M Mar 27  2017 git-fast-import.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-fast-export.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-difftool.exe\*
-rwxr-xr-x   1 raghs 197610 2.2K Mar 27  2017 git-difftool--helper\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-diff.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-diff-tree.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-diff-index.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-diff-files.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-describe.exe\*
-rwxr-xr-x   1 raghs 197610 1.1M Mar 27  2017 git-daemon.exe\*
-rwxr-xr-x   1 raghs 197610 159K Mar 27  2017 git-cvsserver\*
-rwxr-xr-x   1 raghs 197610  32K Mar 27  2017 git-cvsimport\*
-rwxr-xr-x   1 raghs 197610  13K Mar 27  2017 git-cvsexportcommit\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-credential.exe\*
-rwxr-xr-x   1 raghs 197610 1.1M Mar 27  2017 git-credential-store.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-count-objects.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-config.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-commit.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-commit-tree.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-column.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-clone.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-clean.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-cherry.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-cherry-pick.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-checkout.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-checkout-index.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-check-ref-format.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-check-mailmap.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-check-ignore.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-check-attr.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-cat-file.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-bundle.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-branch.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-blame.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-bisect--helper.exe\*
-rwxr-xr-x   1 raghs 197610  16K Mar 27  2017 git-bisect\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-archive.exe\*
-rwxr-xr-x   1 raghs 197610  37K Mar 27  2017 git-archimport\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-apply.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-annotate.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-am.exe\*
-rwxr-xr-x 118 raghs 197610 2.1M Mar 27  2017 git-add.exe\*
-rwxr-xr-x   1 raghs 197610  42K Mar 27  2017 git-add--interactive\*
-rwxr-xr-x   1 raghs 197610 100K Mar 27  2017 git-gui.tcl\*
-rwxr-xr-x   1 raghs 197610 1.1K Mar 27  2017 git-gui--askyesno\*
-rwxr-xr-x   1 raghs 197610 1.4K Mar 27  2017 git-gui--askpass\*
-rwxr-xr-x   1 raghs 197610  687 Mar 27  2017 git-gui\*
-rwxr-xr-x   1 raghs 197610  687 Mar 27  2017 git-citool\*
-rwxr-xr-x   1 raghs 197610  17K Mar 27  2017 git-subtree\*
-rwxr-xr-x   1 raghs 197610  34K Mar 27  2017 git-credential-wincred.exe\*
drwxr-xr-x   1 raghs 197610    0 Apr  1  2017 mergetools/

C:\rags\git-extras\bin (master)
¿ ls -ltrh C:\installedSoft\Git\mingw64\libexec\git-core\ > git-core-before-copy-26Apr2020.txt

C:\rags\git-extras\bin (master)
¿ ls
git-alias\*         git-clear-soft\*                     git-delete-tag\*    git-ignore\*         git-paste\*          git-repl\*                    git-stamp\*
git-archive-file\*  git-coauthor\*                       git-delta\*         git-ignore-io\*      git-pr\*             git-reset-file\*              git-standup\*
git-authors\*       git-commits-since\*                  git-effort\*        git-info\*           git-psykorebase\*    git-root\*                    git-summary\*
git-back\*          git-contrib\*                        git-extras\*        git-local-commits\*  git-pull-request\*   git-rscp                     git-sync\*
git-browse\*        git-core-before-copy-26Apr2020.txt  git-feature\*       git-lock\*           git-reauthor\*       git-scp\*                     git-touch\*
git-brv\*           git-count\*                          git-force-clone\*   git-locked\*         git-rebase-patch\*   git-sed\*                     git-undo\*
git-bug\*           git-cp\*                             git-fork\*          git-merge-into\*     git-refactor\*       git-setup\*                   git-unlock\*
git-bulk\*          git-create-branch\*                  git-fresh-branch\*  git-merge-repo\*     git-release\*        git-show-merged-branches\*
git-changelog\*     git-delete-branch\*                  git-gh-pages\*      git-missing\*        git-rename-branch\*  git-show-tree\*
git-chore\*         git-delete-merged-branches\*         git-graft\*         git-mr\*             git-rename-remote\*  git-show-unmerged-branches\*
git-clear\*         git-delete-submodule\*               git-guilt\*         git-obliterate\*     git-rename-tag\*     git-squash\*

C:\rags\git-extras\bin (master)
¿ pwd
C:\rags\git-extras\bin

C:\rags\git-extras\bin (master)
¿ mv git-core-before-copy-26Apr2020.txt ..\

C:\rags\git-extras\bin (master)
¿ ls -ltrh C:\installedSoft\Git\mingw64\libexec\git-core\ | wc -l
215

C:\rags\git-extras\bin (master)
¿ ls -ltrh C:\installedSoft\Git\mingw64\libexec\git-core\ | wc -l >> ..\git-core-before-copy-26Apr2020.txt

C:\rags\git-extras\bin (master)
¿ tail -n 5 ..\git-core-before-copy-26Apr2020.txt
-rwxr-xr-x   1 raghs 197610  687 Mar 27  2017 git-citool\*
-rwxr-xr-x   1 raghs 197610  17K Mar 27  2017 git-subtree\*
-rwxr-xr-x   1 raghs 197610  34K Mar 27  2017 git-credential-wincred.exe\*
drwxr-xr-x   1 raghs 197610    0 Apr  1  2017 mergetools/
215

C:\rags\git-extras\bin (master)
¿ cp * \installedSoft\Git\mingw64\libexec\git-core\

C:\rags\git-extras\bin (master)
¿ ls
git-alias\*         git-clear-soft\*              git-delta\*         git-ignore-io\*      git-pr\*             git-reset-file\*              git-standup\*
git-archive-file\*  git-coauthor\*                git-effort\*        git-info\*           git-psykorebase\*    git-root\*                    git-summary\*
git-authors\*       git-commits-since\*           git-extras\*        git-local-commits\*  git-pull-request\*   git-rscp                     git-sync\*
git-back\*          git-contrib\*                 git-feature\*       git-lock\*           git-reauthor\*       git-scp\*                     git-touch\*
git-browse\*        git-count\*                   git-force-clone\*   git-locked\*         git-rebase-patch\*   git-sed\*                     git-undo\*
git-brv\*           git-cp\*                      git-fork\*          git-merge-into\*     git-refactor\*       git-setup\*                   git-unlock\*
git-bug\*           git-create-branch\*           git-fresh-branch\*  git-merge-repo\*     git-release\*        git-show-merged-branches\*
git-bulk\*          git-delete-branch\*           git-gh-pages\*      git-missing\*        git-rename-branch\*  git-show-tree\*
git-changelog\*     git-delete-merged-branches\*  git-graft\*         git-mr\*             git-rename-remote\*  git-show-unmerged-branches\*
git-chore\*         git-delete-submodule\*        git-guilt\*         git-obliterate\*     git-rename-tag\*     git-squash\*
git-clear\*         git-delete-tag\*              git-ignore\*        git-paste\*          git-repl\*           git-stamp\*

C:\rags\git-extras\bin (master)
¿ ls -ltrh C:\installedSoft\Git\mingw64\libexec\git-core\ | wc -l >> ..\git-core-before-copy-26Apr2020.txt

C:\rags\git-extras\bin (master)
¿ tail -n 5 ..\git-core-before-copy-26Apr2020.txt
-rwxr-xr-x   1 raghs 197610  17K Mar 27  2017 git-subtree\*
-rwxr-xr-x   1 raghs 197610  34K Mar 27  2017 git-credential-wincred.exe\*
drwxr-xr-x   1 raghs 197610    0 Apr  1  2017 mergetools/
215
287

C:\rags\git-extras\bin (master)
¿ ls -l | wc -l
73

C:\rags\git-extras\bin (master)
¿
```

### Attempt to run the `git-info` command it is failing still.

```
C:\rags\TechNotes (master)
¿ git-info
'git-info' is not recognized as an internal or external command,
operable program or batch file.
```
