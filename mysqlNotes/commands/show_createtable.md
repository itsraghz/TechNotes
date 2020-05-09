# Show Create Table

The MySQL `show` command helps you to get the information on the objects like `tables`, `sequences`, `views` etc., where can see the SQL commands used to create them.

## Syntax

 The syntax for the command is `show create table <objectName>`, where the object name is the name of the object (table/sequence/view/procedure etc.,)

## Example

```
MariaDB [itsraghz]> show create table blog;
+-------+-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| Table | Create Table

                                                                                                  |
+-------+-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
| blog  | CREATE TABLE `blog` (
  `article_id` int(11) NOT NULL,
  `article_title` varchar(50) NOT NULL,
  `article_content` text NOT NULL,
  `article_timestamp` datetime NOT NULL,
  `updated_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `author` varchar(30) NOT NULL DEFAULT 'raghs',
  `category` varchar(100) DEFAULT 'Misc' COMMENT 'a logical group of categories of a blog entry'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 |
+-------+-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
1 row in set (0.00 sec)

MariaDB [itsraghz]>
```
