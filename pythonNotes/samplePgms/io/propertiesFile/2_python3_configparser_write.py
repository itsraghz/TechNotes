# Ref URL: https://docs.python.org/3/library/configparser.html

import configparser

config = configparser.ConfigParser()

# Prepare the entries to be written
config['DEFAULT'] = {'ServerAliveInterval': '45',
		     'Compression' : 'yes',
		     'CompressionLevel' : '9'}

config['bitbucket.org'] = {}
config['bitbucket.org']['User']='hg'

config['topsecret.server.com']={}
topsecret = config['topsecret.server.com']
topsecret['Port'] = '50022' # mutate the parser
topsecret['ForwardX11'] = 'no' # same here

config['DEFAULT']['ForwardX11'] = 'yes'

# Time to write
with open('example.ini', 'w') as configfile: 
    config.write(configfile)

print(f'the configuration entries are written successfully into the file - [example.ini]')

