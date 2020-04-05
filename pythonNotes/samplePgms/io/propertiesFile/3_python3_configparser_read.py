# Ref URL: https://docs.python.org/3/library/configparser.html
# Ref URL: https://stackoverflow.com/a/26221097/1001242

import configparser

config = configparser.ConfigParser()
print(f'Initial sections of the config ', config.sections())

'''
config = config.read('example.ini')
print(f'example.ini has been read successfully')
'''

config = configparser.RawConfigParser()
config.read('example.ini')
# case sensitive - get method
print(config.get('DEFAULT','Compression'))
print(config.get('bitbucket.org','User'))
