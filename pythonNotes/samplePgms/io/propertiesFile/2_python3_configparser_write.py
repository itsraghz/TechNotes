# Ref URL: https://docs.python.org/3/library/configparser.html

import configparser

config = configparser.ConfigParser()
config['DEFAULT'] = {'ServerAliveInterval': '45',
		     'Compression' : 'yes',
		     'Comp

