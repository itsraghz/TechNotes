# Simple Redis Tutorial in Redis CLI

## Install redis

Make sure you have installed `redis` through `brew` or any other mode of your choice.

`brew install redis`

## Verify the location where redis is insalled

Redis is installed as a Server and hence being made available as a `redis-server` in the System. 

```sh
➜  bin
whereis redis
redis:
➜  bin
which redis
redis not found
➜  bin
whereis redis-server
redis-server: /opt/homebrew/bin/redis-server
➜  bin
which redis-server
/opt/homebrew/bin/redis-server
```

However, when it is being dealt as a Service, it is just `redis`.

```sh
➜  bin
brew services list | grep redis
redis             none
➜  bin
brew services list | grep redis-server
```

## Start Redis Server

```sh
➜  bin
brew services start redis
==> Successfully started `redis` (label: homebrew.mxcl.redis)
```

## Verify the services list via `brew services list`

```sh
➜  bin
brew services list | grep redis
redis             started         raghavan.muthu ~/Library/LaunchAgents/homebrew.mxcl.redis.plist
```

## Simple Tutorial in Redis-CLI

```sh
➜  bin
redis-cli
127.0.0.1:6379> PING
PONG
127.0.0.1:6379> SET myKey "Hello, Redis"
OK
127.0.0.1:6379> GET myKey
"Hello, Redis"
127.0.0.1:6379> EXISTS myKey
(integer) 1
127.0.0.1:6379> KEYS *
1) "myKey"
127.0.0.1:6379> SET myKey "Hello, Raghs"
OK
127.0.0.1:6379> GET myKey
"Hello, Raghs"
127.0.0.1:6379> DEL myKey
(integer) 1
127.0.0.1:6379> EXISTS myKey
(integer) 0
127.0.0.1:6379> KEYS *
(empty array)
127.0.0.1:6379> FLUSHALL
OK
127.0.0.1:6379> exit
```

## Stop Redis Service

```sh
➜  bin
brew services stop redis
Stopping `redis`... (might take a while)
==> Successfully stopped `redis` (label: homebrew.mxcl.redis)
```

## Verify the Services list

```sh
➜  bin
brew services list | grep redis
redis             none
```
