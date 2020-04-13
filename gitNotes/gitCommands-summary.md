# Git Commands

| Command    |    Description         | Remarks |
| :--------: | :--------------------: | :-----: |
| git init   | creates or reinitiates a git repo on the folder where this command is executed | See a folder called `.git` created. |
| git config |  | |
| git config --list |  |
| git status |  |
| git log [--oneline] | | 
| git add file1 file2 | adds the files `file1` and `file2` to the git repo. | The file are space separated |
| git add . | adds all the `untracked` file in the workspace to the staging area | Easy to add all the files at once |
| git commit -m "<a short commit message>" | Commits all the staged files to the repo | `-m` flag helps to add a short and meaningful message |
| git commit | opens up the default editor configured to get a commmit message | waits for the opened up editor to be saved and closed to perform the actual `commit` |
| git config --global core.editor | shows the default editor configured to work with git operations | the file is `.gitconfig` and located in the `~/` directory (user's home dir) |
| git config unset core.editor | `unset` removes an entry of the property specified in the `~/.gitconfig` file |  |
| git push | |  | 
| git reverse | |  |
| git fetch | | |

