# URL: https://nitratine.net/blog/post/encryption-and-decryption-in-python/

import cryptography

# print("cryptography module is successfully imported.")

from cryptography.fernet import Fernet
key = Fernet.generate_key()
print(f'Fernet generated key is : {key}')
decoded_key = key.decode()
print(f'Decoded key : {decoded_key}')

# Store the key into a file safely
file = open('key.key', 'wb')
file.write(key) # The key is type bytes still
file.close()

# Read the key from the file 
file = open('key.key', 'rb')
key_read = file.read() # The key will be type bytes
file.close()
print(f'key_read from file is : {key_read}')

## Actual Encryption
message = "my dark secret".encode()
f = Fernet(key)
encrypted_message = f.encrypt(message)
print(f'Encrypted message : {encrypted_message}')


## Decryption
decrypted_message = f.decrypt(encrypted_message)
print(f'Decrypted message in bytes : {decrypted_message}')
decrypted_string = decrypted_message.decode()
print(f'Decrypted message in String : {decrypted_string}')


