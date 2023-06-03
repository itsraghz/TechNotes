<?php

mysqli_report(MYSQLI_REPORT_ERROR | MYSQLI_REPORT_STRICT);

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

$mysqli = new mysqli($host, $user, $pass, $mydatabase);

// check the MySQL connection status
//$mysqli = new mysqli($host, $user, $pass, 'db');

if ($mysqli->connect_error) {
    die("Connection failed: " . $mysqli->connect_error);
} else {
    echo "Connected to MySQL server successfully! <br/>";
}

echo "<b>Connection Object : </b> <pre>", print_r($mysqli), "</pre>";

//$mysqli = new mysqli("localhost", "my_user", "my_password", "world");

$query = "SELECT username, password FROM users ORDER BY ID DESC";

$result = $mysqli->query($query);

/* fetch associative array */
while ($row = $result->fetch_assoc()) {
    printf("%s (%s)\n", $row["username"], $row["password"]);
}

?>