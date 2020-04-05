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