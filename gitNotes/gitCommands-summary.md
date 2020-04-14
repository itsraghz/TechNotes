# Git Commands

| Command    |    Description         | Remarks |
| :--------: | :--------------------: | :-----: |
| `git init` | creates or reinitiates a git repo on the folder where this command is executed | See a folder called `.git` created. |
| `git config` | Shows the git config menu and the list of options to invoke | Parent command |
| `git config --list` | Lists down all the configurations in the System | |
| `git status` | Shows the status of the repository/snapshot with respect to the previous commit made | It basically two different type of files *`untracked`* and *`modified`*. Untracked is the files which were not present in the latest snapshot/commit of the repo but which are newly added and yet to be commited. _Modified_ is the set of files which were earlier present in the snapshot/commit of the repo but modified recently. |
| `git log` | Shows the summary of all git commits made so far in the repo. | Shows the commit Id and the commit message in the descending order.  |
| `git log --oneline` | Shows the summary of all git commit so far made, in a concise manner. | Shows the shortened version of the commitId but that is unique enough to identify it individually. |
| `git add file1 file2` | adds the files `file1` and `file2` to the git repo. | The file are space separated |
| `git add .` | adds all the `untracked` file in the workspace to the staging area | Easy to add all the files at once |
| `git reset HEAD dummy.txt` | removes the file `dummy.txt` from staging area to the workspace (to remove the tracking) | works fine in the new version of Git.|
| `git rm --cached file1` | removes the file `file1` from the staging area to the worspace (to remove the tracking) | works in the previous version of Git (2.1 or earlier) [To be verified] |
| `git commit -m "<a short commit message>"` | Commits all the staged files to the repo | `-m` flag helps to add a short and meaningful message. Also you need to configure the username and password which are the mandatory elements of the commit message. |
| `git commit` | opens up the default editor configured to get a commmit message | waits for the opened up editor to be saved and closed to perform the actual `commit` |
| `git config --global core.editor` | shows the default editor configured to work with git operations | the file is `.gitconfig` and located in the `~/` directory (user's home dir) |
| `git config --global unset core.editor` | `unset` removes an entry of the property specified in the `~/.gitconfig` file |  |
| `git config --global core.editor "code --wait"` | sets the `vscode` (Visual Studio Code editor) with the flag `wait` to wait for the file to be saved and closed once a `git commit` command is issued on the terminal. | You can set any favorite editor of your choice in place of `code`. By default `Git Bash` is set with the `vi/vim` editor | 
| `git show HEAD` | shows the commit what HEAD is pointing to | displays the detailed message of the corresponding commit. The word `HEAD` is case insensitive. If this was not the initial commit, it shows the difference of the snapshots (file contents) from the previous commit to this commit for a visual understanding. |
| `git show commitId` | similar to `git show HEAD`, it shows the details of the commit pointed to by the `commitId. | Example: `git show 889ddc7` will show the commit id `889ddc7`. | 
| `git show HEAD~1` | to show the commit id which is `1` level down from `HEAD` pointer.| You can specify any number after the tilde symbol (`~`) to get to that level of commit from the `HEAD` pointer. |
| git push | push the contents of the repository (delta change if is not the initial commmit) from the staging area to the remote repo.| It might ask you to enter the credentials to authenticate to the repo.  |
| `git checkout file1` | undo the changes on the `file1`. | Can do `git checkout .` or `git checkout \*` for making the undo checkin of more than one file, in the current snapshot. All the changes being done in those files will be reverted. *Safest of the other alternative commands* like `git revert`, `git reset` as we cannot change or delete the previous commits in checkout. |
| `git checkout commitId` | checks out the repo with the specific commit mentioned by `commitId`. | Traversing to a specific point in time in the repo timelines, like *System Restore* in the Windows OS. It shows the message in the terminal that *You are in detached *HEAD*, meaning the HEAD is no longer pointing to the latest commit in the repo. Also the pointer is changed on the repo that shows the recent commit where we had checked out to. You can verify the status using the `git log --oneline` where you see the commit entires uptil this commitId. _Internally the pointers are adjusted and not like the rest of the commits are deleted._|
| `git checkout master` | Bring back the workspace to the latest snapshot, by making the HEAD pointing to the `master` branch. | The next immediate option for `git checkout commitId` to bring back the workspace in the consistent state. The pointer now shows the `(masater)` for the repo. You can verify again with the `git log --oneline` where you see that the workspace restores all the commits uptil the very latest. *Checkout is very safe as  it is _READ_ONLY_ command, and we cannot do any change or delete the previous commits*. |
| `git reverse` | | |
| `git reset` | | |
| `git fetch` | | |

