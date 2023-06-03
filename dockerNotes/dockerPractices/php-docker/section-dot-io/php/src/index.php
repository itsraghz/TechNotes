<?php
	echo "Hello there, this is a PHP Apache container. <br/>";

//These are the defined authentication environment in the db service

// The MySQL service named in the docker-compose.yml.
$host = 'db';

// Database use name
$user = 'MYSQL_USER';

//database user password
$pass = 'MYSQL_PASSWORD';

// database name
$mydatabase = 'MYSQL_DATABASE';

// check the mysql connection status
$conn = new mysqli($host, $user, $pass, $mydatabase);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} else {
    echo "Connected to MySQL server successfully! <br/>";
}

echo "<b>Connection Object : </b> <pre>", print_r($conn), "</pre>";

//mysqli_report(MYSQLI_REPORT_ERROR | MYSQLI_REPORT_STRICT);
//$mysqli = new mysqli("localhost", "my_user", "my_password", "world");

$query = 'SELECT username, password FROM users ORDER BY ID DESC';

echo "<b>Query : </b> <i>$query</i><br/>";

// Using iterators
$result = $conn->query($query);
echo "<b>Result: </b> <pre>", print_r($result), "</pre>";

//if($result) {
   // echo "......<i>Yes, the result is present!</i> <br/>";
    while ($row = $result->fetch_assoc()) {
        printf("%s (%s)\n", $row["username"], $row["password"]);
    }    
//}

?>
