# Git Notes

* When you clone a repository, you create a connection between the Bitbucket server (which Git knows as origin) and your local system.
* The git add command moves changes from the working directory to the Git staging area. The staging area is where you prepare a snapshot of a set of changes before committing them to the official history.
* The git commit takes the staged snapshot and commits it to the project history. Combined with git add, this process defines the basic workflow for all Git users.
* Up until this point, everything you have done is on your local system and invisible to your Bitbucket repository until you push those changes
* Git's ability to communicate with remote repositories (in your case, Bitbucket is the remote repository) is the foundation of every Git-based collaboration workflow.
* Git's collaboration model gives every developer their own copy of the repository, complete with its own local history and branch structure.
* Users typically need to share a series of commits rather than a single changeset. Instead of committing a changeset from a working copy to the central repository, Git lets you share entire branches between repositories.
* You manage connections with other repositories and publish local history by "pushing" branches to other repositories. You see what others have contributed by "pulling" branches into your local repository.
* 


## Links

* https://www.atlassian.com/git/tutorials/learn-git-with-bitbucket-cloud
* https://www.atlassian.com/git/tutorials/setting-up-a-repository
	* https://www.atlassian.com/git/tutorials/setting-up-a-repository/git-init
	* https://www.atlassian.com/git/tutorials/setting-up-a-repository/git-clone
	* https://www.atlassian.com/git/tutorials/setting-up-a-repository/git-config
	* YouTube Video Tutorial from Atlassian on initializing a repo (git init) - https://www.youtube.com/watch?v=jUlT-zQ-mbk
* https://www.atlassian.com/git/tutorials/saving-changes
* https://www.atlassian.com/git/tutorials/git-hooks
*  

## Starting Up a Repository

### git init

To create a new repo, you'll use the `git init` command. `git init` is a one-time command you use during the initial setup of a new repo. Executing this command will create a new `.git` subdirectory in your current working directory. This will also create a *new master branch*.

Pointing git init to an existing project directory will execute the same initialization setup as mentioned above, but scoped to that project directory.
inting git init to an existing project directory will execute the same initialization setup as mentioned above, but scoped to that project directory.

#### Command Usage

*Syntax*: `git init <directory>`

Create an empty Git repository in the specified directory. Running this command will create a new subdirectory called containing nothing but the .git subdirectory.

If you've already run `git init` on a project directory and it contains a `.git` subdirectory, you can *safely run* `git init` again on the same project directory. It will _*not* override_ an existing `.git` configuration.

#### Flavors

By default, git init will initialize the Git configuration to the .git subdirectory path. The subdirectory path can be modified and customized if you would like it to live elsewhere. You can set the `$GIT_DIR` environment variable to a custom path and git init will initialize the Git configuration files there. Additionally you can pass the `--separate-git-dir` argument for the same result. 

> A common use case for a separate .git subdirectory is to keep your system configuration "dotfiles" (.bashrc, .vimrc, etc.) in the home directory while keeping the .git folder elsewhere.

##### Bare Repositories (`git init --bare`)

Initialize an empty Git repository, but omit the working directory. Shared repositories should always be created with the --bare flag (see discussion below). Conventionally, repositories initialized with the --bare flag end in .git. For example, the bare version of a repository called my-project should be stored in a directory called my-project.git.

The --bare flag creates a repository that doesn't have a working directory, making it impossible to edit files and commit changes in that repository. You would create a bare repository to git push and git pull from, but never directly commit to it. Central repositories should always be created as bare repositories because pushing branches to a non-bare repository has the potential to overwrite changes.

> The most common use case for  git init --bare is to create a remote central repository:
> `ssh <user>@<host> cd path/above/repo git init --bare my-project.git`

First, you SSH into the server that will contain your central repository. Then, you navigate to wherever you'd like to store the project. Finally, you use the --bare flag to create a central storage repository. Developers would then clone my-project.git to create a local copy on their development machine.

#### git init templates

*Syntax* : `git init <directory> --template=<template_directory>`

Initializes a new Git repository and copies files from the  <template_directory> into the repository.

Templates allow you to initialize a new repository with a predefined .git subdirectory. You can configure a template to have default directories and files that will get copied to a new repository's .git subdirectory. The default Git templates usually reside in a `/usr/share/git-core/templates` directory but may be a different path on your machine.

The default templates are a good reference and example of how to utilize template features. A powerful feature of templates that's exhibited in the default templates is Git Hook configuration. You can create a template with predefined Git hooks and initialize your new git repositories with common hooks ready to go. Learn more about Git Hooks at the [Git Hook](https://www.atlassian.com/git/tutorials/git-hook) page.

### git clone 

If a project has already been set up in a central repository, the clone command is the most common way for users to obtain a local development clone. Like git init, cloning is generally a one-time operation. Once a developer has obtained a working copy, all version control operations are managed through their local repository.

#### FAQ: git clone Vs git init

A quick note: git init and git clone can be easily confused. At a high level, they can both be used to "initialize a new git repository." However, git clone is dependent on git init. git clone is used to create a copy of an existing repository. 

Internally, git clone first calls git init to create a new repository. It then copies the data from the existing repository, and checks out a new set of working files. 


