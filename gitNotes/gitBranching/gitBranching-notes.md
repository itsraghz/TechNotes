# Git Branching

 Branching helps you deal with different tasks in parallel without really clashing with each other. 
 It helps you carryon independent tasks by starting off from the same parent (master) - codebase. 

 We will see the following topics related to the *Git Branches* in a precise manner in this section. 

 * List all branches
 * Create a branch
 * Checkout to a branch
 * Rename a branch
 * Delete a branch 
 * Merging into branches

## Create, Rename, Delete branches

### List all the branches

`git branch`

Lists all the branches you have in your local repository

### Create a new branch

*Syntax* : `git checkout -b <branchName>`

*Example* : `git checkout -b ticket1` &rarr; creates a new branch called `ticket1` from the *master* branch (by default) and switches the repository to that branch.

> Note: Git is linux based and hence it is *case sensitive*. The name of the branch should be intact. 

```
admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/GitHubRepos (master)
$ git checkout -b ticket1
Switched to a new branch 'ticket1'

admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/GitHubRepos (ticket1)
$ 
```

See the next line in the Terminal, the branch being shown is now `ticket1` from the `master`.

### Checkout a branch (or switch to that branch)

*Syntax*:  `git checkout <branchName>`

> Note : Checking out from a branch lets you switch to that branch immediately.

Please note that *Git* is *linux* based and it is *case sensitive* on the names of the files. 

```
admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/GitHubRepos (ticket1)
$ git checkout Master
error: pathspec 'Master' did not match any file(s) known to git
```

### Rename a branch

*Syntax* : `git branch -m <oldNameOfBranch> <newNameOfBranch>`

> Note : You can't rename the currently active branch. Should you wish to do so, you should switch to a different branch and then issue the command. 

### Delete a branch 

*Syntax*: `git branch -d <branchName>`

> Note: If there are any changes in the branch that is not commited, or committed-but-not-merged, Git will initimate you of the same and prevent you 
from deleting the same. 

### Force delete a branch 

*Syntax* : `git branch -D <branchname>`

Note the argument is *captial D* to force delete a branch by overriding the intimation/warning if any, by Git for the uncommitted/unmerged changes in the branch being
deleted. 

## Comparing and Merging branches

 Let us suppose you had been working on a new branch called `ticket1` from the *master* branch and now you want to merge the changes in the `ticket1` branch to the `master`.

 There are two ways the merging can happen.

 * Fast-forward : If the master branch had not further changes since when the `ticket1` branch was created, it is the faily straight and easy. It is just merging all the changes from `ticket1` to `master` and it is called *fast-forward*.
 > Ideally the references of master is updated to the reference to the `ticket1`. It is that simple as the changes were happening in the *linear sequence*.
 *

### Merging branches
  
 The `git merge` command helps us with merging of one branch contents to another branch. 

 *Source Branch*: The branch whose contents we want to merge into another branch. Example, the `ticket1` branch. 
 *Target Branch*: The branch into which we want the contents of other branch to be merged. Exampoe, the `master` branch.

  You need to first check out to the *target* branch and then issue the `merge` command. 

  The commands to be issued in sequence for merging. 

  ```
  git checkout master
  git merge ticket1
  ```

  Git will tell you of the style of merging that took place. Carefully watch the output of the `git merge` command below for the same.

  ```
  admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/GitHubRepos/gitPractices (ticket1)
  $ git checkout master
  Switched to branch 'master'

  admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/GitHubRepos/gitPractices (master)
  $ ls
  initialfile.txt

  admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/GitHubRepos/gitPractices (master)
  $ git merge ticket1
  Updating 7f43088..402b592
  Fast-forward
  solution1.txt | 0
  1 file changed, 0 insertions(+), 0 deletions(-)
  create mode 100644 solution1.txt

  admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/GitHubRepos/gitPractices (master)
  $ ls
  initialfile.txt  solution1.txt

  admin@LenovaG51-35 MINGW64 /c/raghs/prfsnl/GitHubRepos/gitPractices (master)
  $
  ```
  
### Comparing branches

 Before you actually merge the contents fo one branch to another, you have an opportunity to do a glance at the actual changes / contents to be merged. 

 You can issue the `git compare` command for the same.

 *Syntax*: `git compare <branch1> <branch2>`

 *Example*: `git compare master ticket1`

## Git Rebase

 The `git rebase` command helps you to organize the command history in the local repository to keep it succinct. Typically it is used to clean up the interim commits and histories while merging the changies to a different branch, thereby letting us focus on the end results alone.

 For example, you can treat this like reading a rought draft of your notes Vs the final copy of the notes, which makes sense when you ship the final product from a specific branch to a master branch. 

 > Note: Rebase has got the following nuances. 
 > * It is an advanced feature and it is NOT MANDATORY. 
 > * It can cause problems when you are working in a distributed team/environment

There are a few scenarios where we might to use the `rebase`

  * Clean up local history before sharing it with a branch - for personal resaons most probably.
  * Pulling changes into your branch from another branch *without performing a merge*.

There are a few scenarios we should *NOT use* the `rebase`.
 
  * Do NOT use rebase on a public branch, as it can cause lot of confusion and rework.
  * Check the team guidelines before you use `rebase` on a public/team/distributed repository

### Squash a commit 

 Squashing a commit is the way to clean up the historical commits by making a brand new commit from all the previous ones. 

 Git actually performs the following behind the scenes

  * Create a new commit
  * Copy all the contents from the rest of all previous/available commits
  * Asks for a commit message for the new commit (optionally)

*Branch Master*
 
    `<CommitRef#1>` 

*Branch Ticket1* (created from `CommitRef#1`)

    `<CommitRef#1> ---  <BranchCommit#1> ---- <BranchCommit#2> --- <BranchCommit#3>`

*Rebase - Squash Commit in Master*

 You can use the *squash* to combine or merge the 2nd and 3rd commit into the 1st commit, so that it appears as one commit. 

   `<CommitRef#1> --- <MergedBranchCommits>`

### Rebase Branch from Master

 If you perform a `git rebase` from master to a different branch (that has got its own commits off from master), then the 
 changes if any present in the master post the branch was created, then the rebase helps us get those commits in master gets
 merged into the branch in a linear or sequential fashion and then the specific commits on the branch are attached to this 
 commmit from master. 

 Note that `rebase` does *not move* the commits rather it creates a *copy* of those commits, so that it can change the parent..

 > The originanl commits are eventually garbage collected by Git. 

### Commands to be used for the rebase

 | Command  | Description |
 | -------- | ------------- |
 | git log --oneline | 	See the branch history in a precise manner. The --oneline flag helps to chop off the details other than summary |
 | git merge-base ticket1 master | Get the original base of the "ticket1" branch created from master |
 | git rebase -i <commitId> | Start the rebase from the commit ID (which is the SHA) |
 | git rebase master | Pull in changes from the master branch then replay branch commits after |  

*Example* 

 When you issue a `git rebase` command, Git will present you a file wiht the list of commit Ids (SHA References) for you to suggest the further proceedings.

 ```
 pick 123A4d commit 1 in ticket1 branch
 squash 3441E3 commit 2 in ticket1 branch
 squash 4472E1 completed ticket1
 ```

 When you save the file, it will merge the 2nd and 3rd commits into 1st commit and asks you further for the actual commit message for the merging. 

```
# This is the 1st commit message
commit 1 in ticket1 branch

# This is the 2nd commit message
commit 2 in ticket1 branch

# This is the 3rd commit message 
completed ticket1
```

 You can choose whichever message you wat by deleting th rest and save the file. Git will then do the actual rebase with the new commits along with the message you had chosen. 


