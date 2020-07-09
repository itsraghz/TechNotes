```
admin@LenovaG51-35 MINGW64 ~
$ cd /c

admin@LenovaG51-35 MINGW64 /c
$ cd raghs/prfsnl/

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl
$ cd BitBucketRepos/

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos
$ ls
emerald-butterfly/

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos
$ git clone https://itsraghz@bitbucket.org/itsraghz/bitbucketstationlocations.git
Cloning into 'bitbucketstationlocations'...
remote: Counting objects: 3, done.
remote: Compressing objects: 100% (2/2), done.
remote: Total 3 (delta 0), reused 0 (delta 0)
Unpacking objects: 100% (3/3), 1.30 KiB | 49.00 KiB/s, done.

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos
$ ls
bitbucketstationlocations/  emerald-butterfly/

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos
$ cd bitbucketstationlocations/
l
admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (master)
$ ls
README.md

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (master)
$ echo "Earth's Moon" >> locations.txt

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (master)
$ git status
On branch master
Your branch is up to date with 'origin/master'.

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        locations.txt

nothing added to commit but untracked files present (use "git add" to track)

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (master)
$ git add locations.txt

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (master)
$ git status
On branch master
Your branch is up to date with 'origin/master'.

Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        new file:   locations.txt


admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (master)
$ git restore --staged locations.txt

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (master)
$ git status
On branch master
Your branch is up to date with 'origin/master'.

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        locations.txt

nothing added to commit but untracked files present (use "git add" to track)

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (master)
$ git add .

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (master)
$ git status
On branch master
Your branch is up to date with 'origin/master'.

Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        new file:   locations.txt


admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (master)
$ git commit -m "Initial commit"
[master a7e0c4a] Initial commit
 1 file changed, 1 insertion(+)
 create mode 100644 locations.txt

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (master)
$ git push origin master
Enumerating objects: 4, done.
Counting objects: 100% (4/4), done.
Delta compression using up to 4 threads
Compressing objects: 100% (2/2), done.
Writing objects: 100% (3/3), 312 bytes | 44.00 KiB/s, done.
Total 3 (delta 0), reused 0 (delta 0), pack-reused 0
To https://bitbucket.org/itsraghz/bitbucketstationlocations.git
   014e966..a7e0c4a  master -> master

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (master)
$

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (master)
$ git pull
remote: Counting objects: 3, done.
remote: Compressing objects: 100% (3/3), done.
remote: Total 3 (delta 0), reused 0 (delta 0)
Unpacking objects: 100% (3/3), 420 bytes | 6.00 KiB/s, done.
From https://bitbucket.org/itsraghz/bitbucketstationlocations
   a7e0c4a..abc22b7  master     -> origin/master
Updating a7e0c4a..abc22b7
Fast-forward
 stationlocations | 5 +++++
 1 file changed, 5 insertions(+)
 create mode 100644 stationlocations

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (master)
$ git remote -v
origin  https://itsraghz@bitbucket.org/itsraghz/bitbucketstationlocations.git (fetch)
origin  https://itsraghz@bitbucket.org/itsraghz/bitbucketstationlocations.git (push)

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (master)
$


admin@LenovaG51-35 MINGW64 /
$ cd /c/raghs/prfsnl/BitBucketRepos/

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos
$ cd bitbucketstationlocations/

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (master)
$ ls
locations.txt  README.md  stationlocations

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (master)
$ git branch future-plans

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (master)
$ git branch
  future-plans
* master

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (master)
$ git checkout future-plans
Switched to branch 'future-plans'

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (future-plans)
$ git branch
* future-plans
  master

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (future-plans)
$ ls
locations.txt  README.md  stationlocations

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (future-plans)
$ vim stationlocations

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (future-plans)
$ git status
On branch future-plans
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   stationlocations

no changes added to commit (use "git add" and/or "git commit -a")

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (future-plans)
$ git add stationlocations

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (future-plans)
$ git status
On branch future-plans
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        modified:   stationlocations


admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (future-plans)
$ git commit stationlocations -m 'making a change in a branch'
[future-plans a873819] making a change in a branch
 1 file changed, 5 insertions(+), 1 deletion(-)

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (future-plans)
$ git status
On branch future-plans
nothing to commit, working tree clean

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (future-plans)
$ git checkout master
Switched to branch 'master'
Your branch is up to date with 'origin/master'.

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (master)
$ git branch
  future-plans
* master

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (master)
$ git merge future-plans
Updating abc22b7..a873819
Fast-forward
 stationlocations | 6 +++++-
 1 file changed, 5 insertions(+), 1 deletion(-)

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (master)
$ explorer .

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (master)
$ git branch -d future-plans
Deleted branch future-plans (was a873819).

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (master)
$ git status
On branch master
Your branch is ahead of 'origin/master' by 1 commit.
  (use "git push" to publish your local commits)

nothing to commit, working tree clean

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (master)
$ git push origin master
Enumerating objects: 5, done.
Counting objects: 100% (5/5), done.
Delta compression using up to 4 threads
Compressing objects: 100% (3/3), done.
Writing objects: 100% (3/3), 389 bytes | 97.00 KiB/s, done.
Total 3 (delta 1), reused 0 (delta 0), pack-reused 0
To https://bitbucket.org/itsraghz/bitbucketstationlocations.git
   abc22b7..a873819  master -> master

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/BitBucketRepos/bitbucketstationlocations (master)
$

```