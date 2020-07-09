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



