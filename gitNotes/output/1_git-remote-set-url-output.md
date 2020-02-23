# git remote set-url origin - Terminal output before and after

Used this to update from HTTPS to SSL to avoid from git asking the credentials everytime I use `git push`.

## Terminal Output

`
C:\rags\TechNotes (master)
¿ git remote -v
origin  https://github.com/itsraghz/TechNotes.git (fetch)
origin  https://github.com/itsraghz/TechNotes.git (push)

C:\rags\TechNotes (master)
¿ git remote set-url origin git@github.com:itsraghz/TechNotes.git

C:\rags\TechNotes (master)
¿ git remote -v
origin  git@github.com:itsraghz/TechNotes.git (fetch)
origin  git@github.com:itsraghz/TechNotes.git (push)

C:\rags\TechNotes (master)
¿
`
