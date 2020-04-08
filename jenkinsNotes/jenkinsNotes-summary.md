# Jenkins Notes

## AJP Port

 * Ref URL: 
   - https://www.wikiwand.com/en/Apache_JServ_Protocol
   - http://www.wellho.net/mouth/1549_http-https-and-ajp-comparison-and-choice.html

 * The Apache JServ Protocol is a binary protocol that can proxy inbound requests from a web server through to an application server that sits behind the web server
 * ajp carries the same information as http but in a binary format. The request method - GET or POST - is reduced to a single byte, and each of the additional headers are reduced to 2 bytes - typically, that's about a fifth of the size of the http packet. See ajp protocol specification for further internal details.
