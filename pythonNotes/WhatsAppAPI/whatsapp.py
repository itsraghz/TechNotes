import os
from twilio.rest import Client

client = Client()

from_whatsapp='whatsapp:+918095261616'
# to_whatsapp_number='whatsapp' + os.environ['WHATSAPP_TO_NUMBER'];
to_whatsapp_number='whatsappi:+65 9481 9630'


message = 'Hello Khushi - from Automated Python API for WhatsApp :)'

client.messages.create(body = 'Hello Khushi, How are you? - Automated Message from Python Twilio API', 
			from_ = from_whatsapp_number,
			to_ = to_whatsapp_number)




