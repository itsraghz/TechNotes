# A program to print the list of keywords in the current running version of Python

import sys
import keyword
version=sys.version
print(f'List of keywords in the current version of Python - {version}')
print("-------------------------------------------------")
print(keyword.kwlist)
