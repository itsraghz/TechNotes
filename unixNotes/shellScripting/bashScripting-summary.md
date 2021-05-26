# Bash - Shell Scripting Notes

## Common Operations

## String Manipulation

  * https://www.cyberciti.biz/faq/how-to-extract-substring-in-bash/

## Date Manipulation

> Reference : https://www.shell-tips.com/linux/how-to-format-date-and-time-in-linux-macos-and-bash/

```sh
#!/bin/bash

echo "Today's date is : `date`"
echo "Date in YYYY-MMM format is : `date '+%Y-%B'`"

month=`date '+%B'`
monthNum=`date '+%m'`
year=`date '+%Y'`
echo "Month is : $month"
echo "Month Num is : $monthNum"
echo "Year is : $year"
```
### Output

```sh
pw8khe6h1l4u@sg2plcpnl0194 [~/shellscripts]$ ./testdate.sh
Today's date is : Wed May 26 11:32:56 MST 2021
Date in YYYY-MMM format is : 2021-May
Month is : May
Month Num is : 05
Year is : 2021
```
