# Spring MongoShell

We can connect to the MongoDB via MongoShell utility from the command line.

## Pre-requisites

We need to enable the *Network Access* in MongoDB Cluster remotely to facilitate accessing the collections from our machine (local).

*URL*: [https://cloud.mongodb.com/v2/5d82ff7df2a30b8e6458cd0c#/security/network/accessList](https://cloud.mongodb.com/v2/5d82ff7df2a30b8e6458cd0c#/security/network/accessList)

We can perform any of the following options available.

* Permit the Custom IP Address - _safe_
	> *Note*: This is for a temporary duration and it gets auto expired after a certain time limit. If needed, we can customize it.
* Allow All _Unsafe_

```sql
➜  springMongoNotes git:(master) ✗ pwd
/Users/raghavan.muthu/raghs/prfsnl/github-repos/TechNotes/springNotes/springMongoNotes
```

## How to enter 

Use *mongosh* utility to use the *Mongo Shell* as follows.

*Command Syntax*

```sh
mongosh "mongodb+srv://<clusterName>" --apiVersion 1 --username <username> --password <Password>
```

* The Cluster Name can be found in MongoDB Cluster Account
* UserName - what you have configured
* Password - *NOT Recommended* to specify it in the Command Line directly for the _obvious_ reasons. If not specified, the user will be prompted to type.

*Command with Values filled*

```sh
mongosh "mongodb+srv://raghsclustr.lxy8a.mongodb.net" --apiVersion 1 --username m001-student --password RaghsMongo123
```

Upon successfully authenticating (with the credentials and the Network Access being tallied), the Mongo Shell prints an informatory message to let us know that we are welcomed in. Most importantly, is shares the *Mongosh Log ID* which is unique and helpful for the traction.

```sql
➜  springMongoNotes git:(master) ✗ mongosh "mongodb+srv://raghscluster.lxy8a.mongodb.net" --apiVersion 1 --username m001-student --password RaghsMongo123
Current Mongosh Log ID:	648c0636612ba1df0ebb0512
Connecting to:		mongodb+srv://<credentials>@raghscluster.lxy8a.mongodb.net/?appName=mongosh+1.9.1
Using MongoDB:		6.0.6 (API Version 1)
Using Mongosh:		1.9.1

For mongosh info see: https://docs.mongodb.com/mongodb-shell/

Atlas RaghsCluster-shard-0 [primary] test>
```

*Notes:

* The prompt also changes to `Atlas <ClusterName> [primary] test>` whereas the `[primary]` is the Primary Database and `test` is the default Database being ready to be operated.

We can now issue the command `show dbs` to list all the available databases. 

Also, we can perform the subsequent operations to begin working with.

```sql
Atlas RaghsCluster-shard-0 [primary] test> show dbs
myFirstDatabase   72.00 KiB
video            956.00 KiB
admin            372.00 KiB
local              8.48 GiB
Atlas RaghsCluster-shard-0 [primary] test> use myFirstDatabase
switched to db myFirstDatabase
```

## How to identify the currently selected Database / the database currently in use?

Issue the simplest command `db` to get to know the currently selected database.

```sql
Atlas RaghsCluster-shard-0 [primary] myFirstDatabase> db
myFirstDatabase
```

## How to find the list of tables / collections 

In MongoDB, each database has a list of Collections (which is analogous to Tables in RDBMS).

```sql
Atlas RaghsCluster-shard-0 [primary] myFirstDatabase> show collections
customer
```

## How to find / query all the records from a Collection?

Use the command `db.<collection>.find()` to get all the records in a Collection.

MongoDB always returns the data in JSON format and in an Array (JSON Array) to represent a list of data (find All - through `find()`). Each element in the list, will be a JSON Object representing one full row of data (in a table - RDBMS), each separated by a Comma.

```sql
Atlas RaghsCluster-shard-0 [primary] myFirstDatabase> db.customer.find()
[
  {
    _id: ObjectId("64867ceb2afdd84047e4de9d"),
    firstName: 'Alice',
    lastName: 'Smith',
    _class: 'com.raghsonline.springdatamongodbdemo.model.Customer'
  },
  {
    _id: ObjectId("64867ceb2afdd84047e4de9e"),
    firstName: 'Bob',
    lastName: 'Smith',
    _class: 'com.raghsonline.springdatamongodbdemo.model.Customer'
  },
  {
    _id: ObjectId("6486ebf2ec9ecf94f2a8e2fa"),
    firstName: 'Raghavan',
    lastName: 'Muthu'
  }
]
```
> Note: The `_id` is an inbuilt key representing the *Primary Key* of an element. 

## How to Insert a Record to a Collection ?

We use th syntax `db.<collection>.insertOne(<JSONObject>)` to insert one record into a Collection.

```sql
Atlas RaghsCluster-shard-0 [primary] myFirstDatabase> db.customer.insertOne({"firstName": "Kannan", "lastName": "Muthu"})
{
  acknowledged: true,
  insertedId: ObjectId("648c06ae612ba1df0ebb0513")
}
```

MongoDB responds with an acknowledgement and the primary key (`id`) of the inserted record.

```sql 
Atlas RaghsCluster-shard-0 [primary] myFirstDatabase> db.customer.find()
[
  {
    _id: ObjectId("64867ceb2afdd84047e4de9d"),
    firstName: 'Alice',
    lastName: 'Smith',
    _class: 'com.raghsonline.springdatamongodbdemo.model.Customer'
  },
  {
    _id: ObjectId("64867ceb2afdd84047e4de9e"),
    firstName: 'Bob',
    lastName: 'Smith',
    _class: 'com.raghsonline.springdatamongodbdemo.model.Customer'
  },
  {
    _id: ObjectId("6486ebf2ec9ecf94f2a8e2fa"),
    firstName: 'Raghavan',
    lastName: 'Muthu'
  },
  {
    _id: ObjectId("648c06ae612ba1df0ebb0513"),
    firstName: 'Kannan',
    lastName: 'Muthu'
  }
]
Atlas RaghsCluster-shard-0 [primary] myFirstDatabase>
```
## How to exit from the Shell ?

Typically we press `Ctrl+C` but this MongoShell expects `Ctrl+D` once or `Ctrl+C` *twice* to exit.

```sql
Atlas RaghsCluster-shard-0 [primary] myFirstDatabase> 
(To exit, press Ctrl+C again or Ctrl+D or type .exit)
Atlas RaghsCluster-shard-0 [primary] myFirstDatabase>
```

## How to delete an IP Address ?

Are you sure you want to delete IP: 59.97.116.218/32? 
https://www.mongodb.com/docs/atlas/setup-cluster-security/#add-ip-addresses-to-the-whitelist 
