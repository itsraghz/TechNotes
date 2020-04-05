# Error while installing MySQL-python via PIP

```
C:\rags\TechNotes\pythonNotes\samplePgms\db (master)
? pip install MySQL-python
Collecting MySQL-python
  Using cached MySQL-python-1.2.5.zip (108 kB)
Installing collected packages: MySQL-python
    Running setup.py install for MySQL-python ... error
    ERROR: Command errored out with exit status 1:
     command: 'c:\python38\python.exe' -u -c 'import sys, setuptools, tokenize; sys.argv[0] = '"'"'C:\\Users\\ragha\\AppData\\Local\\Temp\\pip-install-s2kft0wz\\MySQL-python\\setup.py'"'"'; __file__='"'"'C:\\Users\\ragha\\AppData\\Local\\Temp\\pip-install-s2kft0wz\\MySQL-python\\setup.py'"'"';f=getattr(tokenize, '"'"'open'"'"', open)(__file__);code=f.read().replace('"'"'\r\n'"'"', '"'"'\n'"'"');f.close();exec(compile(code, __file__, '"'"'exec'"'"'))' install --record 'C:\Users\ragha\AppData\Local\Temp\pip-record-o5t5la78\install-record.txt' --single-version-externally-managed --compile --install-headers 'c:\python38\Include\MySQL-python'
         cwd: C:\Users\ragha\AppData\Local\Temp\pip-install-s2kft0wz\MySQL-python\
    Complete output (29 lines):
    running install
    running build
    running build_py
    creating build
    creating build\lib.win-amd64-3.8
    copying _mysql_exceptions.py -> build\lib.win-amd64-3.8
    creating build\lib.win-amd64-3.8\MySQLdb
    copying MySQLdb\__init__.py -> build\lib.win-amd64-3.8\MySQLdb
    copying MySQLdb\converters.py -> build\lib.win-amd64-3.8\MySQLdb
    copying MySQLdb\connections.py -> build\lib.win-amd64-3.8\MySQLdb
    copying MySQLdb\cursors.py -> build\lib.win-amd64-3.8\MySQLdb
    copying MySQLdb\release.py -> build\lib.win-amd64-3.8\MySQLdb
    copying MySQLdb\times.py -> build\lib.win-amd64-3.8\MySQLdb
    creating build\lib.win-amd64-3.8\MySQLdb\constants
    copying MySQLdb\constants\__init__.py -> build\lib.win-amd64-3.8\MySQLdb\constants
    copying MySQLdb\constants\CR.py -> build\lib.win-amd64-3.8\MySQLdb\constants
    copying MySQLdb\constants\FIELD_TYPE.py -> build\lib.win-amd64-3.8\MySQLdb\constants
    copying MySQLdb\constants\ER.py -> build\lib.win-amd64-3.8\MySQLdb\constants
    copying MySQLdb\constants\FLAG.py -> build\lib.win-amd64-3.8\MySQLdb\constants
    copying MySQLdb\constants\REFRESH.py -> build\lib.win-amd64-3.8\MySQLdb\constants
    copying MySQLdb\constants\CLIENT.py -> build\lib.win-amd64-3.8\MySQLdb\constants
    running build_ext
    building '_mysql' extension
    creating build\temp.win-amd64-3.8
    creating build\temp.win-amd64-3.8\Release
    C:\Program Files (x86)\Microsoft Visual Studio\2017\BuildTools\VC\Tools\MSVC\14.16.27023\bin\HostX86\x64\cl.exe /c /nologo /Ox /W3 /GL /DNDEBUG /MD -Dversion_info=(1,2,5,'final',1) -D__version__=1.2.5 "-IC:\Program Files (x86)\MySQL\MySQL Connector C 6.0.2\include" -Ic:\python38\include -Ic:\python38\include "-IC:\Program Files (x86)\Microsoft Visual Studio\2017\BuildTools\VC\Tools\MSVC\14.16.27023\include" "-IC:\Program Files (x86)\Windows Kits\10\include\10.0.17763.0\ucrt" "-IC:\Program Files (x86)\Windows Kits\10\include\10.0.17763.0\shared" "-IC:\Program Files (x86)\Windows Kits\10\include\10.0.17763.0\um" "-IC:\Program Files (x86)\Windows Kits\10\include\10.0.17763.0\winrt" "-IC:\Program Files (x86)\Windows Kits\10\include\10.0.17763.0\cppwinrt" "-IC:\Program Files\IBM\SQLLIB\include" "-IC:\Program Files\IBM\SQLLIB\lib" /Tc_mysql.c /Fobuild\temp.win-amd64-3.8\Release\_mysql.obj /Zl
    _mysql.c
    _mysql.c(42): fatal error C1083: Cannot open include file: 'config-win.h': No such file or directory
    error: command 'C:\\Program Files (x86)\\Microsoft Visual Studio\\2017\\BuildTools\\VC\\Tools\\MSVC\\14.16.27023\\bin\\HostX86\\x64\\cl.exe' failed with exit status 2
    ----------------------------------------
ERROR: Command errored out with exit status 1: 'c:\python38\python.exe' -u -c 'import sys, setuptools, tokenize; sys.argv[0] = '"'"'C:\\Users\\ragha\\AppData\\Local\\Temp\\pip-install-s2kft0wz\\MySQL-python\\setup.py'"'"'; __file__='"'"'C:\\Users\\ragha\\AppData\\Local\\Temp\\pip-install-s2kft0wz\\MySQL-python\\setup.py'"'"';f=getattr(tokenize, '"'"'open'"'"', open)(__file__);code=f.read().replace('"'"'\r\n'"'"', '"'"'\n'"'"');f.close();exec(compile(code, __file__, '"'"'exec'"'"'))' install --record 'C:\Users\ragha\AppData\Local\Temp\pip-record-o5t5la78\install-record.txt' --single-version-externally-managed --compile --install-headers 'c:\python38\Include\MySQL-python' Check the logs for full command output.
```