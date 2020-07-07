# Vi/Vim Editor Commands

## Version History

| Sl No. | Date | Author | Remarks |
| --- | --- | --- | --- |
| 1 | 22 Feb 2020 | Raghavan Muthu | Initial Version |
| 2 | 10 Apr 2020 | Raghavan Muthu | Vim Command History Added |
| 3 | 28 Jun 2020 | Raghavan Muthu | Vim Commands Added |
|   |             |                |  1. Search for the next/previous occurrence of a word |

#Todo - for pending few of the commands 

## How many modes are available in Vi editor?
There are 3 different modes available in Vi/Vim Editor, as follows. 

  * Command Mode - default mode as and when you open a file (operates on lines of text)
  * Insert Mode/ Append Mode - to add/modify the contents of the file
  * Visual Mode - to visually select a block of code and manipulate it further (copy, paste, delete etc.,)

## How to change the mode to Command Mode?

Change to Command mode by pressing `Esc` key if you are in the Insert/Visual mode.
It is the very basic pre-requisite for issuing any commands to the Vi/Vim editor. 

## How many different options are there in the Visual Mode of Vi editor?

There are 3 different possible operations you can perform in the `visual` mode of the Vi editor, as follows - all at once on the block of text selected by
navigating the arrow keys.

 * Character mode : v (lower-case)
 * Line mode : V (Upper case)
 * Block mode : Ctrl+v

## How to go to the beginning character of the file (start of the file)?
> Change to the Command mode by pressing the `Esc` key at first, if required. 

The operator `G` (uppercase - <shift+g>) takes to the last line of the file (end of file), however, it takes a quantifier as a prefix.
If you press `1G`, the cursor will be taken to the 1st line of the file (and to the 1st character of the line as well).

> Another easy shortcut is to press `gg` (*twice* the time __lowercase 'g'__), that will take you to the beginning the file.\

> Yet another very simple shortcut is to use `:1` to specify the line number to navigate. 

## How to go to the beginning of the line?
> Change to the Command mode by pressing the `Esc` key at first, if required.

Press `0` at any position of the line will take you to the 0th position (starting character) of the line where the cursor is present.

## How to go to the end of the line?
> Change to the Command mode by pressing the `Esc` key at first, if required.

Press the `$` key to go the the end of the current line.

## How to go to the end of the file?
> Change to the Command mode by pressing the `Esc` key at first, if required.

By pressing the `$` key in the `Command Mode`, you can navigate to the end of the current line, whereas to go to the end of the file you should
press the `G$` (`Capital+G`). 

## How to go to the last line of the file in Vi/Vim editor?
> Change to the Command mode by pressing the `Esc` key at first, if required. 

Press `:$<Enter>` to take the cursor to the last line of the file opened in Vi editor.  

## How to make the last line of the file editable ? How to go to the last line of the file (end of file) and shift to `insert` mode ?
> Change to the Command mode by pressing the `Esc` key at first, if required.

Press `GA` together (uppercase), whereas the `G` will take you to the last line of the file (end of file)
and `A` will keep the editor in `Append` mode. 

## How to open a particular file in Vi editor and let the cursor point to a specific line? 
To make `Vi` editor start at a particular line in a file, add `+<line_number>` as a prefix to the file name while you invoke `Vi` / `Vim` in the
command line to open the file. 

> To open a file named `foo.txt` and take the cursor to the 6th line, issue the command `*vi +6 foo.txt*`. 

## How to open a particular file in Vi editor and let the cursor point to a specific word? 
To make `Vi` editor start at a particular word in a file, add `+/<word_to_search_for>` as a prefix to the file name while you invoke `Vi` / `Vim` in the
command line to open the file. **Remember:** This is `case sensitive` search.  

> To open a file named `foo.txt` and take the cursor to (first occurrence of the) word 'text', issue the command `*vi +/text foo.txt*`. 

In case, there is no word matching the case you had supplied while opening the file in the Command Line, the Vi/Vim editor says that 'there is no such pattern'

```
E486: Pattern not found: <word_to_search_for> 
```

# How to navigate word by word in the current line in Vi editor?
> Change to the Command mode by pressing the `Esc` key at first, if required. 

Press `w` in `Command Mode` to navigate (traverse) the cursor word by word in a forward direction.  
Press `b` in `Command Mode` to navigate (traverse) the cursor word by word in a reverse/backward direction.

## How to undo the changes in Vi/Vim editor?
> Change to the Command mode by pressing the `Esc` key at first, if required.  

Press `Ctrl + U` or `:undo` or simply `u` to undo the recent changes you had done on the present file opened in Vi/Vim.  
You can use the *Quantifier* for this `redo` command, which should be a numeral prefixed with the command.

> If you use `6u` will undo the last 6 changes applied recently on the file opened in the *current session*.

> *Note*: The difference between `u` (lowercase) and `U` (uppercase) operator is that the uppercase operator `U` will
undo all the changes applied on the current line at one shot, whereas the lowercase operator `u` will undo the recent 
changes one after the other. __If you accidentally typed `U`, you can undo that change with the `u`__.

## How to redo the changes in Vi/Vim editor?
> Change to the Command mode by pressing the `Esc` key at first, if required.  

Press `Ctrl + R` or `:redo` to redo the recent changes you had undone on the present file opened in Vi/Vim.  
You can use the *Quantifier* for this `redo` command, which should be a numeral prefixed with the command.  

> If you use `6<Ctrl+R>` will redo the last 6 changes undone in the *current session*.

## How to delete a word (or delete a line of content word by word) ?
Pressing the `w` key in the `Command Mode` will delete a whole word from the current cursor position.  
You can repeat the same until all the words are deleted in the current line, should you wish to. 
However, you can use `d $` to delete all the words from the current cursor position till the end of the line, which is comparatively easy.

## How to delete the characters from the current cursor position till the end of the line?
> Change to the Command mode by pressing the `Esc` key at first, if required.  

Press `d $` to delete all the characters from the current cursor position till the end of the line.

## How to delete an entire line?
Pressing `dd` in the `Command Mode` deletes a complete line of text in the Vi/Vim editor.

## How to delete more than one line in Vi/Vim editor?
> Change to the Command mode by pressing the `Esc` key at first, if required. 

> The operator `dd` takes a quantifier as a prefix to take the number of lines to be opearted upon (deletion in this case). 

You can press a numerical value before the `dd` to delete that many number of lines. For example, pressing `5dd` will delete 
the 5 lines of text from the current line where the cursor is present.

## How to operate more than one line at a time?
> Change to the Command mode by pressing the `Esc` key at first, if required.  

Press `v` to enable the `visual mode` that will facilitate the selection of lines of your choice and the Vi editor will visually
highlight the lines you had selected. Once a selection is made, you can press `d` or `x` to cut the lines selected and keep it in the buffer (clipboard)
which you can paste it elsewhere in the file by pressing `p` character - all in `Command Mode`. 

> #TODO - to copy the contents after selection in the `visual` mode.

## How to do a bulk move (shift/indentation) in Vi/Vim for more than one line at a time?
> Change to the Command mode by pressing the `Esc` key at first, if required.  

Type `v` to facilitate a visual selection of lines of your choice, and then press `.` to indent towards right once, and press `<number>.` to indent that many number of lines towards the right side. #TODO for the &lt; key and for left indentation. 

## What is Yanking in Vi/Vim editor? How do you copy more than one line at a time in Vi/Vim Editor?
> Change to the Command mode by pressing the `Esc` key at first, if required.  

Press `yy` key (yanking) [two times `y`]  to copy/yank the current line where the cursor is present. This command can take a quantifier as a prefix, like most of the other editor commands. You can issue `5yy` to copy 5 lines from the current cursor position towards the bottom of the file (forward direction), which you can paste it using `p` operator/command. 

> #TODO - how to copy the lines in the bottom to top order? 

## How to set the line numbers in Vi/Vim Editor? How to toggle the line numbers in the Vi/Vim Editor?
> Change to the Command mode by pressing the `Esc` key at first, if required.  

Issue the command inside the Vi editor `:set number` OR `:set nu` (nu is the shortform of number) to turn on  the line numbers.  
Issue the command inside the vi editor `:set nonumber` OR `:set nonu` OR `:set nu!` (nu NOT- nu!) to turn off the line numbers.  

> Remember: the commands are __case sensitive__ in Vi/Vim editor. If you type the commands in all uppercase, it would throw an error saying that __E0492: Not an Editor Command : <Command_You_Recently_Issued> __.

## How to turn on / off the syntax highlighting in the Vi/Vim editor?
> Change to the Command mode by pressing the `Esc` key at first, if required.  

Issue the command inside the Vi editor `:syntax on` to turn on the Syntax Highlighting. Reissuing the command does __NOT__ have any effects.  
Issue the command inside the vi editor `:syntax off` to turn off the Syntax highlighting.

> Remember: the commands are __case sensitive__ in Vi/Vim editor. If you type the commands in all uppercase, it would throw an error saying that __E0492: Not an Editor Command : <Command_You_Recently_Issued> __.

## Are the Commands in Vi / Vim editor case sensitive ? 

Yes, the commands in Vi/Vim editor are case sensitive. If you issue a command in an improper way (mixed/sentence case or upper case), the editor will issue an error message stating that `__E0492: Not an Editor Command : <RecentlyIssuedCommand>__`.

## How to enable line number setting permanently while using Vi/Vim Editor?
If you need number every time you start vi/vim, append the following line to your ~/.vimrc file:
> $ vi ~/.vimrc  

Append the following line in the `.vimrc` file as follows. 

> set number

## How to set a relative line numbering in Vi/Vim Editor?
It is an interesting feature in Vi editor where it would start the numbering from the line where the cursor is present (starts from 0) and shows the rest of the lines accoringly in the forward / incremental numbering, whereas all the numbers before the current position of the cursor will have the numbers in the reverse order from bottom to top starting from the cursor position.  

> In order to set the numbering on, type `:set relativenumber` OR `:set rnu` (short form) to turn on the relative numbering.  
> Type `:set norelativenumber` OR `:set nornu` OR `:set rnu!` (rnu NOT -> rnu!) to turn off the relative numbering.

## How do I see a particular/all the settings applied for a Vi/Vim Editor?
> Change to the Command mode by pressing the `Esc` key at first, if required.  

Press `:set` to list of settings what you had applied so far in the current session in your vim config file or during the runtime.  
Press `:set all` to see the list of all settings available in the vim config.

## How do you search in Vi editor in a case (in)sensitive mode ? 
> Change to the Command mode by pressing the `Esc` key at first, if required.  

Press `:set ic` to let Vi editor search in the case insensitive mode, and press `:set noic` to let the Vi editor search in a case sensitive mode (no-ic).  

> Reference URL : https://stackoverflow.com/questions/2287440/how-to-do-case-insensitive-search-in-vim?rq=1 

## Is there a difference between copying via yanking (`yy`) and visual mode (`v`) and pasting it? 

Yes. If you copy and paste it via Yanking, the cursor have to be set a line before, so that when you press `p` the contents in buffer (clipboard) will be pasted to the next line of the cursor. Whereas if you copy via visual mode, the contents of the buffer will be pasted on the same line of the cursor where you press `p` key. 

## How to save the file as a new file (Save As) in Vi/Vim editor?

 There is no direct facility in Vi/Vim editor as in other editors like Notepad to do a 'Save As'. Instead you can issue the command `:w <fileName.txt>` to get the current file saved under a new name. Ensure that the file name being issued in this command is a non-existing file so that Vim creates the new file for you, otherwise it might overwrite the contents of the existing file.

## How to remove the `^M` (Ctrl+M) characters stored in a file?

 Typically this happens due to the OS specific end of line of characters. In Windows OS a newline character is a combination of two keys `\r\n` where `\r` is for carriage return and `\n` is for the newline (line break), whereas in Unix/Linux based OS, it is just a `\n`. When you add/modify a content in a file in Windows OS, the end of line characters are diplayed with ^M to match with the extra character that is not matching.

   **Reference URL ** 
     - https://its.ucsc.edu/unix-timeshare/tutorials/clean-ctrl-m.html
     - https://stackoverflow.com/questions/1110678/m-at-the-end-of-every-line-in-vim

   In order to replace the `^M` characters, you can do the following : 

     - Use `sed` --> `sed -e "s/^M//" fileName > newFileName.txt` . You can press `Ctrl+V` and then `Ctrl+M` in succession to get the `^M`. (tried but not worked)
     - Use it in VIM editor itself. In the Esc (Command) Mode, type `:%s/^M//g`
     - Use it in VIM editor. `:%s/^M$//`
     - (Easy tip and worked well) Use it in VIM editor : `:%s/\r$//` to avoid the ^V^M hassle
     
   To avoid the encoding saved differently, use the following

    - `:set ff=unix` and then `:wq`. Now your file is back to the good-old-Unix-way. `ff`- file format (suppose)
    - If you need to bring back to DOS encoding, you can type `:set ff=dos` and then `:wq`
    - Alternate is to use the full format in the command `:set fileformats=dos`

## How you would get the previously typed command in Vi/Vim editor?

 Ref URL: https://stackoverflow.com/questions/8928070/vim-show-my-last-command-command

  * Hit the colon (`:`) and then use the up arrow to start going back through previous commands. You can use the `up/down` arrows too to move around the list.

## How would you get the previously searched patterns in Vi/Vim editor?

 * while (`:`) and up/down arrows show command history, (`/`) up/down arrows show search patterns history. 
 * `/q` will show you command history in Vim. `q/` will show you history of searches.

## How would you display/show the whitespaces , tabs in Vi/Vim editor? 

 * Use the following command in the `Command` Mode to show the whitespaces and tabs in the file opened. `:set listchars=space:_,tab:>~ list`. 
 * You will now see spaces as colored _ characters, and tabs as a single > followed by as many ~s as needed.

## How do you covert the tabs into spaces in Vi/Vim editor?

* Apply the following command : `:1,$s/\t/  /g` - whereas the `1,$` will apply this rule from the line number 1 to end of file (`$`), and `s` to search, and `\t` for the tab character, and `'/  /'` to replace with two whitespaces (if required you can make it one space) and `g` stands for global change.i

## Does Vi/Vim have an auto save option?

 * https://vi.stackexchange.com/questions/830/does-vim-autosave
 * https://vim.fandom.com/wiki/Auto_save_files_when_focus_is_lost

