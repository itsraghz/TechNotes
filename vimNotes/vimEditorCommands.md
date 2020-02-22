# Vi/Vim Editor Commands
------------------------------------------------------------------------------------------
| Sl # | 	Date	| 	Author		  	 | 		Remarks	         |
| ---- |. -------------.| -----------------------------	 | ----------------------------- |
|  1   | 22 Feb 2020 	| Raghavan alias Saravanan Muthu | Initial Version		 | 
|      |       		| 	                         |                               |
------------------------------------------------------------------------------------------

#Todo - for pending few of the commands 

## How to change the mode to Command Mode?

Change to Command mode by pressing `Esc` key if you are in the Insert/Visual mode.
It is the very basic pre-requisite for issuing any commands to the Vi/Vim editor. 

## How to go to the end of the file?

## How to go to the beginning character of the file (start of the file)?

## How to go to the beginning of the line?

## How to go to the end of the line?
> Change to Command mode at first if required.

Press the `$` key to go the the end of the current line.

## How to delete a word (or delete a line of content word by word) ?
Pressing the `w` key in the `Command Mode` will delete a whole word from the current cursor position.
You can repeat the same until all the words are deleted in the current line, should you wish to. 
However, you can use `d $` to delete all the words from the current cursor position till the end of the line, which is comparatively easy.

## How to delete the characters from the current cursor position till the end of the line?
> Change to Command mode at first if required.

Press `d $` to delete all the characters from the current cursor position till the end of the line.

## How to delete an entire line?
Pressing `dd` in the `Command Mode` deletes a complete line of text in the Vi/Vim editor.

## How to delete more than one line in Vi/Vim editor?
> The operator `dd` takes a quantifier as a prefix to take the number of lines to be opearted upon (deletion in this case).

You can press a numerical value before the `dd` to delete that many number of lines. For example, pressing `5dd` will delete 
the 5 lines of text from the current line where the cursor is present.

## How to operate more than one line at a time?

## How to do a bulk move (shift/indentation) in Vi/Vim for more than one line at a time?
