
# Git keeps asking the password whenever I type the commands like `git push`, `git pull`, `git fetch` etc., even after setting my remote with `ssh`

Generally this would be an issue if the remote repo is set with the `https://` instead of `ssh` and it goes away as long as you set your remote-repo with the *SSH* with the following command.

* HTTPS - `https://github.com/username/repo.git`
* SSH - `ssh://git@github.com/username/repo.git`

```
git remote set-url origin git@github.com:username/repo.git
```

 My situation was a bit different as even when I set the remote repo with `ssh` it keeps asking for a password. The suggestion is to issue the `ssh-add` after you invoke the `ssh agent`.

## Screenshots

  Please see the `images` folder for the relevant screenshots. 

## Command Output

```
raghs@Raghs-LegionY540-TPIN MINGW64 /c/raghs/prsnl/github-repo-raghsPrsnl/raghsPrsnl (master)
$ git config --get remote.origin.url
git@github.com:itsraghz/raghsPrsnl.git

raghs@Raghs-LegionY540-TPIN MINGW64 /c/raghs/prsnl/github-repo-raghsPrsnl/raghsPrsnl (master)
$ git remote set-url origin git@github.com:itsraghz/raghsPrsnl.git

raghs@Raghs-LegionY540-TPIN MINGW64 /c/raghs/prsnl/github-repo-raghsPrsnl/raghsPrsnl (master)
$ git config --get remote.origin.url
git@github.com:itsraghz/raghsPrsnl.git

raghs@Raghs-LegionY540-TPIN MINGW64 /c/raghs/prsnl/github-repo-raghsPrsnl/raghsPrsnl (master)
$ git remote -v
origin  git@github.com:itsraghz/raghsPrsnl.git (fetch)
origin  git@github.com:itsraghz/raghsPrsnl.git (push)

raghs@Raghs-LegionY540-TPIN MINGW64 /c/raghs/prsnl/github-repo-raghsPrsnl/raghsPrsnl (master)
$ eval `ssh-agent -s`
Agent pid 1834

raghs@Raghs-LegionY540-TPIN MINGW64 /c/raghs/prsnl/github-repo-raghsPrsnl/raghsPrsnl (master)
$ ssh-add
Enter passphrase for /c/Users/Raghavan Muthu/.ssh/id_rsa:
Identity added: /c/Users/Raghavan Muthu/.ssh/id_rsa (raghavan.muthu@outlook.com)

raghs@Raghs-LegionY540-TPIN MINGW64 /c/raghs/prsnl/github-repo-raghsPrsnl/raghsPrsnl (master)
$ cd ~
```

The below output shows that there is no password being asked when the git push is issued in a script.

```
raghs@Raghs-LegionY540-TPIN MINGW64 ~
$ ls *.sh
dailyPush.sh*                                           dailyPush-RaghsPrsnl-ExpenseParser-Java.sh*  dailyPush-RaghsPrsnl-LalithaSahasranaamam.sh*
dailyPush-RaghsPrsnl-Both-GM-and-PacktpubFreeEbook.sh*  dailyPush-RaghsPrsnl-GMMessages.sh*          dailyPush-RaghsPrsnl-PacktpubFreeEbooks.sh*

raghs@Raghs-LegionY540-TPIN MINGW64 ~
$ ./dailyPush-RaghsPrsnl-GMMessages.sh
/c/Users/Raghavan Muthu
changing to the target directory..
/c/raghs/prsnl/github-repo-raghsPrsnl/raghsPrsnl
On branch master
Your branch is up to date with 'origin/master'.

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   misc/Good Morning Messages - Quotes.md

no changes added to commit (use "git add" and/or "git commit -a")
[master 9b1eabf] [RaghsLenovoLegion] | Updated | GM Messages
 1 file changed, 1 insertion(+), 27 deletions(-)
Enumerating objects: 7, done.
Counting objects: 100% (7/7), done.
Delta compression using up to 8 threads
Compressing objects: 100% (4/4), done.
Writing objects: 100% (4/4), 420 bytes | 420.00 KiB/s, done.
Total 4 (delta 3), reused 0 (delta 0), pack-reused 0
remote: Resolving deltas: 100% (3/3), completed with 3 local objects.
To github.com:itsraghz/raghsPrsnl.git
   49dcad4..9b1eabf  master -> master
On branch master
Your branch is up to date with 'origin/master'.

nothing to commit, working tree clean

raghs@Raghs-LegionY540-TPIN MINGW64 ~
$
```
