# Python Cryptography Module Install

```
C:\rags\TechNotes\pythonNotes\samplePgms\io (master)
¿ python -m pip install cryptography
Collecting cryptography
  Downloading https://files.pythonhosted.org/packages/3c/44/1b2f908a7f55428f3f5df4914dff1b4f97ff07f6848a576682f9a06e9cea/cryptography-2.9-cp38-cp38-win_amd64.whl (1.5MB)
     |¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿| 1.5MB 652kB/s
Collecting six>=1.4.1 (from cryptography)
  Downloading https://files.pythonhosted.org/packages/65/eb/1f97cb97bfc2390a276969c6fae16075da282f5058082d4cb10c6c5c1dba/six-1.14.0-py2.py3-none-any.whl
Collecting cffi!=1.11.3,>=1.8 (from cryptography)
  Downloading https://files.pythonhosted.org/packages/b4/78/eefed9f51baa2b2c891915b4590a237ed6bc6d02beec177fc503bae8eb53/cffi-1.14.0-cp38-cp38-win_amd64.whl (177kB)
     |¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿| 184kB 939kB/s
Collecting pycparser (from cffi!=1.11.3,>=1.8->cryptography)
  Downloading https://files.pythonhosted.org/packages/ae/e7/d9c3a176ca4b02024debf82342dab36efadfc5776f9c8db077e8f6e71821/pycparser-2.20-py2.py3-none-any.whl (112kB)
     |¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿| 112kB 1.3MB/s
Installing collected packages: six, pycparser, cffi, cryptography
Successfully installed cffi-1.14.0 cryptography-2.9 pycparser-2.20 six-1.14.0
WARNING: You are using pip version 19.2.3, however version 20.0.2 is available.
You should consider upgrading via the 'python -m pip install --upgrade pip' command.

C:\rags\TechNotes\pythonNotes\samplePgms\io (master)
¿
```

```
C:\Users\ragha                                                 
¿ pip install pytz                                             
Collecting pytz                                                
  Using cached pytz-2019.3-py2.py3-none-any.whl (509 kB)       
Installing collected packages: pytz                            
Successfully installed pytz-2019.3                             
                                                               
C:\Users\ragha                                                 
¿                                                              
```

## An alternate suggested in StackOverflow but did not proceed further

 Just installed the wheel module but before proceeding, tried the other tip suggested in Stack Overflow which worked. It was actually installing only the binary of the mysql-client for pyton.

Ref URL: https://stackoverflow.com/questions/26866147/mysql-python-install-error-cannot-open-include-file-config-win-h

```
C:\rags\TechNotes\pythonNotes\samplePgms\db (master)
? pip install wheel
Collecting wheel
  Downloading wheel-0.34.2-py2.py3-none-any.whl (26 kB)
Installing collected packages: wheel
Successfully installed wheel-0.34.2
```

## Alternate for MySQL-python client which gave an error. The below one worked fine.
```
C:\rags\TechNotes\pythonNotes\samplePgms\db (master)
? pip install --only-binary :all: mysqlclient
Collecting mysqlclient
  Downloading mysqlclient-1.4.6-cp38-cp38-win_amd64.whl (263 kB)
     |¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦¦| 263 kB 21 kB/s
Installing collected packages: mysqlclient
Successfully installed mysqlclient-1.4.6

C:\rags\TechNotes\pythonNotes\samplePgms\db (master)
?
```

## Packtpub Python Workshop Recommendation

*Note*: The python home directory seemed to have been taken as `C:\python38` which I presume should have been the side effect of installing the `*Anaconda Python Installer*`. Need to check if there are any errors during the course.

```
C:\Users\ragha\Downloads
¿ pip install matplotlib seaborn numpy
Collecting matplotlib
  Downloading matplotlib-3.2.1-cp38-cp38-win_amd64.whl (9.2 MB)
     |¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿| 9.2 MB 1.1 MB/s
Collecting seaborn
  Downloading seaborn-0.10.0-py3-none-any.whl (215 kB)
     |¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿| 215 kB 1.3 MB/s
Collecting numpy
  Downloading numpy-1.18.2-cp38-cp38-win_amd64.whl (12.8 MB)
     |¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿| 12.8 MB 2.2 MB/s
Collecting kiwisolver>=1.0.1
  Downloading kiwisolver-1.2.0-cp38-none-win_amd64.whl (58 kB)
     |¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿| 58 kB 722 kB/s
Collecting pyparsing!=2.0.4,!=2.1.2,!=2.1.6,>=2.0.1
  Downloading pyparsing-2.4.7-py2.py3-none-any.whl (67 kB)
     |¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿| 67 kB 509 kB/s
Collecting python-dateutil>=2.1
  Downloading python_dateutil-2.8.1-py2.py3-none-any.whl (227 kB)
     |¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿| 227 kB 3.3 MB/s
Collecting cycler>=0.10
  Downloading cycler-0.10.0-py2.py3-none-any.whl (6.5 kB)
Collecting scipy>=1.0.1
  Downloading scipy-1.4.1-cp38-cp38-win_amd64.whl (31.0 MB)
     |¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿| 31.0 MB 70 kB/s
Collecting pandas>=0.22.0
  Downloading pandas-1.0.3-cp38-cp38-win_amd64.whl (8.9 MB)
     |¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿| 8.9 MB 297 kB/s
Requirement already satisfied: six>=1.5 in c:\python38\lib\site-packages (from python-dateutil>=2.1->matplotlib) (1.14.0)
Requirement already satisfied: pytz>=2017.2 in c:\python38\lib\site-packages (from pandas>=0.22.0->seaborn) (2019.3)
Installing collected packages: kiwisolver, pyparsing, python-dateutil, numpy, cycler, matplotlib, scipy, pandas, seaborn
Successfully installed cycler-0.10.0 kiwisolver-1.2.0 matplotlib-3.2.1 numpy-1.18.2 pandas-1.0.3 pyparsing-2.4.7 python-dateutil-2.8.1 scipy-1.4.1 seaborn-0.10.0

C:\Users\ragha\Downloads
¿
```
