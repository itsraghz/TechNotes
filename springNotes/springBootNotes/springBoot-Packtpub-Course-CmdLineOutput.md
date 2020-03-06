```
Microsoft Windows [Version 10.0.17763.973]
(c) 2018 Microsoft Corporation. All rights reserved.

C:\Users\ragha>curl -x POST http://localhost:8080/farm/home/access
curl: (5) Could not resolve proxy: POST

C:\Users\ragha>curl -X POST http://localhost:8080/farm/home/access
{"timestamp":"2020-02-08T18:58:17.220+0000","status":404,"error":"Not Found","message":"No message available","path":"/farm/home/access"}
C:\Users\ragha>curl -X POST http://localhost:8080/farm/home/accessDate
February 09, 2020
C:\Users\ragha>
C:\Users\ragha>
C:\Users\ragha>curl -X POST http://localhost:8080/farm/home/accessDate
February 09, 2020
C:\Users\ragha>curl -X POST http://localhost:8080/farm/home/accessDate
February 09, 2020
C:\Users\ragha>curl -X POST http://localhost:8080/farm/login/auth -d "username=user&password=user"
curl: (7) Failed to connect to localhost port 8080: Connection refused

C:\Users\ragha>curl -X POST http://localhost:8080/farm/login/auth -d "username=user&password=user"
{"timestamp":"2020-02-09T10:09:17.414+0000","status":405,"error":"Method Not Allowed","message":"Request method 'POST' not supported","path":"/farm/login/auth"}
C:\Users\ragha>curl -X POST http://localhost:8080/farm/login/auth -d "username=user&password=user"
{"timestamp":"2020-02-09T10:21:57.407+0000","status":405,"error":"Method Not Allowed","message":"Request method 'POST' not supported","path":"/farm/login/auth"}
C:\Users\ragha>curl -X POST http://localhost:8080/farm/login/auth -d "username=user&password=user"
{"timestamp":"2020-02-09T10:24:12.580+0000","status":400,"error":"Bad Request","message":"Required String parameter 'userName' is not present","path":"/farm/login/auth"}
C:\Users\ragha>
C:\Users\ragha>
C:\Users\ragha>curl -X POST http://localhost:8080/farm/home/accessDate
February 09, 2020
C:\Users\ragha>curl -X POST http://localhost:8080/farm/login/auth -d "username=user&password=user"
{"timestamp":"2020-02-09T10:25:39.977+0000","status":400,"error":"Bad Request","message":"Required String parameter 'userName' is not present","path":"/farm/login/auth"}
C:\Users\ragha>curl -X POST http://localhost:8080/farm/login/auth -d "userName=user&password=user"
Welcome to FarmUp, member user!
C:\Users\ragha>curl -X POST http://localhost:8080/farm/login/auth -d "username=user&password=user"
{"timestamp":"2020-02-09T10:28:04.189+0000","status":400,"error":"Bad Request","message":"Required String parameter 'userName' is not present","path":"/farm/login/auth"}
C:\Users\ragha>curl -X POST http://localhost:8080/farm/login/auth -d "username=user&password=user"
Welcome to FarmUp, member user!
C:\Users\ragha>
C:\Users\ragha>
C:\Users\ragha>curl -X GET http://localhost:8080/farm/login/role/admin
User : admin is an Administrator
C:\Users\ragha>curl -X GET http://localhost:8080/farm/login/role/raghs
User : raghs is an Administrator
C:\Users\ragha>curl -X POST http://localhost:8080/farm/login/role/root/raghs
{"timestamp":"2020-02-09T10:35:19.560+0000","status":404,"error":"Not Found","message":"No message available","path":"/farm/login/role/root/raghs"}
C:\Users\ragha>curl -X GET http://localhost:8080/farm/login/role/raghs
User : raghs is an Administrator
C:\Users\ragha>curl -X POST http://localhost:8080/farm/login/role/root/raghs
shgartoor
C:\Users\ragha>curl -X POST http://localhost:8080/farm/login/role/root/raghs@gmail.com
{"timestamp":"2020-02-09T10:38:19.716+0000","status":404,"error":"Not Found","message":"No message available","path":"/farm/login/role/root/raghs@gmail.com"}
C:\Users\ragha>
C:\Users\ragha>
C:\Users\ragha>curl -X GET http://localhost:8080/farm
Welcome to FarmUp
Let us manage, harvest and, enjoy our gains!
C:\Users\ragha>curl -X GET http://localhost:8080/farm/search
{"timestamp":"2020-02-09T11:38:36.507+0000","status":404,"error":"Not Found","message":"No message available","path":"/farm/search"}
C:\Users\ragha>curl -X GET http://localhost:8080/farm
Welcome to FarmUp
Let us manage, harvest and, enjoy our gains!
C:\Users\ragha>curl -X GET http://localhost:8080/farm/search
<!DOCTYPE html>
<html lang="en">
        <head>
                <meta charset="UTF-8"/>
                <title>Farm Harvester</title>
        </head>
        <body>
                <h2>Search Harvest</h2>
                <form action="/farm/search" method="post">
                        <label>Search : </label>
                        <input type=text name="keyword"/><br/>
                        <input type=submit value="search"/>
                </form>
        </body>
</html>
C:\Users\ragha>curl -X POST http://localhost:8080/farm/search -d "keyword=potato"
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Farm Harvester</title>
</head>
<body>
   <h2>They result of the keyword: potato</h2>
   <table>
         <tr>
             <td>Apple</td>
         </tr>
         <tr>
             <td>Tomato</td>
         </tr>
         <tr>
             <td>Potato</td>
         </tr>
   </table>
</body>
</html>
C:\Users\ragha>curl -X POST http://localhost:8080/farm/search -d "keyword=onion"
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Farm Harvester</title>
</head>
<body>
   <h2>They result of the keyword: onion</h2>
   <table>
         <tr>
             <td>Apple</td>
         </tr>
         <tr>
             <td>Tomato</td>
         </tr>
         <tr>
             <td>Potato</td>
         </tr>
   </table>
</body>
</html>
C:\Users\ragha>curl -x GET http://localhost:8080/farm/harvest/add
curl: (5) Could not resolve proxy: GET

C:\Users\ragha>curl -X GET http://localhost:8080/farm/harvest/add
{"timestamp":"2020-02-09T12:27:17.610+0000","status":404,"error":"Not Found","message":"No message available","path":"/farm/harvest/add"}
C:\Users\ragha>
C:\Users\ragha>curl -X GET http://localhost:8080/farm/harvest/add
{"timestamp":"2020-02-09T13:02:42.205+0000","status":404,"error":"Not Found","message":"No message available","path":"/farm/harvest/add"}
C:\Users\ragha>curl -X GET http://localhost:8080/endPoints
<!DOCTYPE html>
<html lang="en">
        <head>
                <title>Endpoint list</title>
        </head>
        <body>
                <table>
                  <thead>
                          <tr>
                            <th>path</th>
                            <th>methods</th>
                            <th>consumes</th>
                            <th>produces</th>
                            <th>params</th>
                            <th>headers</th>
                            <th>custom</th>
                          </tr>
                  </thead>
                  <tbody>
                                                        <tr>
                                  <td>[/farm/harvest/add]</td>
                                  <td>[GET]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                            </tr>
                                <tr>
                                  <td>[/farm/harvest/add]</td>
                                  <td>[POST]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                            </tr>
                                <tr>
                                  <td>[/farm/home/footer]</td>
                                  <td>[GET]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                            </tr>
                                <tr>
                                  <td>[/farm/home/accessDate]</td>
                                  <td>[POST]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                            </tr>
                                <tr>
                                  <td>[/farm/home/header]</td>
                                  <td>[GET]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                            </tr>
                                <tr>
                                  <td>[/farm]</td>
                                  <td>[GET]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                            </tr>
                                <tr>
                                  <td>[/farm/login/auth]</td>
                                  <td>[POST]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                            </tr>
                                <tr>
                                  <td>[/farm/login/guest]</td>
                                  <td>[GET]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                            </tr>
                                <tr>
                                  <td>[/farm/login/role/{user}/{pwd:[A-Za-z0-9@$_]{3,20}}]</td>
                                  <td>[POST]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                            </tr>
                                <tr>
                                  <td>[/farm/login/role/{user}]</td>
                                  <td>[GET]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                            </tr>
                                <tr>
                                  <td>[/farm/search]</td>
                                  <td>[GET]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                            </tr>
                                <tr>
                                  <td>[/farm/search]</td>
                                  <td>[POST]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                            </tr>
                                <tr>
                                  <td>[/endPoints]</td>
                                  <td>[GET]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                            </tr>
                                <tr>
                                  <td>[/error]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                            </tr>
                                <tr>
                                  <td>[/error]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                                  <td>[text/html]</td>
                                  <td>[]</td>
                                  <td>[]</td>
                            </tr>
                  </tbody>
                </table>
        </body>
</html>
C:\Users\ragha>curl -X GET http://localhost:8080/farm/harvest/add
{"timestamp":"2020-02-09T13:02:50.121+0000","status":404,"error":"Not Found","message":"No message available","path":"/farm/harvest/add"}
C:\Users\ragha>curl -X GET http://localhost:8080/farm/
Welcome to FarmUp
Let us manage, harvest and, enjoy our gains!
C:\Users\ragha>curl -X GET http://localhost:8080/farm/harvest/add
<!DOCTYPE html>
<html lang="en">
        <head>
                <meta charset="UTF-8"/>
                <title>Farm Harvester</title>
        </head>
        <body>
                <h2>Add Harvest</h2>
                <form action="/farm/harvest/add" method="post">
                        <label>Name : </label>
                                <input type="text" name="name"/><br/>
                        <label>Qty : </label>
                                <input type="text" name="qty"/><br/>
                        <label>Price : </label>
                                <input type="text" name="price"/><br/>
                        <input type="submit" value="Add"/>
                </form>
        </body>
</html>
C:\Users\ragha>curl -F "document=@C:\raghs\prsnl\ToDo - 01Feb2020.txt" http://localhost:8080/farm/legalDocument
{"timestamp":"2020-02-09T18:52:22.909+0000","status":404,"error":"Not Found","message":"No message available","path":"/farm/legalDocument"}
C:\Users\ragha>curl -F "document=@C:\raghs\prsnl\ToDo - 01Feb2020.txt" http://localhost:8080/farm/legalDocument
Added document : ToDo - 01Feb2020.txt
C:\Users\ragha>
```
