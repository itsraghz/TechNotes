# Redis FAQ

## What is Redis, and how it is used?

Redis (_Re_mote _Di_ctionary _S_erver) is an open-source, in-memory data structure store, used as a database, cache, and message broker. It supports various data structures such as strings, hashes, lists, sets, and sorted sets with range queries. Redis also provides built-in replication, LRU eviction, transactions, and different levels of on-disk persistence.

## How to check the version of Redis installed?

You can use any of the following

* Use `redis-server --version` in the CLI/Terminal
* Use `INFO` command in the `redis-cli` interactive terminal
 
```sh
➜  github-repos
redis-server --version
Redis server v=7.2.5 sha=00000000:0 malloc=libc bits=64 build=bd81cd1340e80580
```

> *Note*: Observe the output on line #25 below in the snippet of `INFO` in the `redis-cli` session.

It provides a comprehensive list of all the metadata maintained by Redis, with different segments - `Server`, `Client`, `Memory` etc.,

```sh
➜  github-repos
redis-cli
127.0.0.1:6379> INFO
# Server
redis_version:7.2.5
redis_git_sha1:00000000
redis_git_dirty:0
redis_build_id:bd81cd1340e80580
redis_mode:standalone
os:Darwin 23.5.0 arm64
arch_bits:64
monotonic_clock:POSIX clock_gettime
multiplexing_api:kqueue
atomicvar_api:c11-builtin
gcc_version:4.2.1
process_id:53264
process_supervised:no
run_id:b2cb1b0d50532b839a9b20cf8880c927bb7a4ccf
tcp_port:6379
server_time_usec:1717288581687326
uptime_in_seconds:8
uptime_in_days:0
hz:10
configured_hz:10
lru_clock:6012549
executable:/opt/homebrew/opt/redis/bin/redis-server
config_file:/opt/homebrew/etc/redis.conf
io_threads_active:0
listener0:name=tcp,bind=127.0.0.1,bind=::1,port=6379

# Clients
connected_clients:1
cluster_connections:0
maxclients:10000
client_recent_max_input_buffer:16896
client_recent_max_output_buffer:0
blocked_clients:0
tracking_clients:0
clients_in_timeout_table:0
total_blocking_keys:0
total_blocking_keys_on_nokey:0

# Memory
used_memory:1170384
used_memory_human:1.12M
used_memory_rss:7241728
used_memory_rss_human:6.91M
used_memory_peak:1361456
used_memory_peak_human:1.30M
used_memory_peak_perc:85.97%
used_memory_overhead:1117784
used_memory_startup:1098864
used_memory_dataset:52600
used_memory_dataset_perc:73.55%
allocator_allocated:1167568
allocator_active:7209984
allocator_resident:7209984
total_system_memory:34359738368
total_system_memory_human:32.00G
used_memory_lua:31744
used_memory_vm_eval:31744
used_memory_lua_human:31.00K
used_memory_scripts_eval:0
number_of_cached_scripts:0
number_of_functions:0
number_of_libraries:0
used_memory_vm_functions:32768
used_memory_vm_total:64512
used_memory_vm_total_human:63.00K
used_memory_functions:216
used_memory_scripts:216
used_memory_scripts_human:216B
maxmemory:0
maxmemory_human:0B
maxmemory_policy:noeviction
allocator_frag_ratio:6.18
allocator_frag_bytes:6042416
allocator_rss_ratio:1.00
allocator_rss_bytes:0
rss_overhead_ratio:1.00
rss_overhead_bytes:31744
mem_fragmentation_ratio:6.20
mem_fragmentation_bytes:6074160
mem_not_counted_for_evict:0
mem_replication_backlog:0
mem_total_replication_buffers:0
mem_clients_slaves:0
mem_clients_normal:18704
mem_cluster_links:0
mem_aof_buffer:0
mem_allocator:libc
active_defrag_running:0
lazyfree_pending_objects:0
lazyfreed_objects:0

# Persistence
loading:0
async_loading:0
current_cow_peak:0
current_cow_size:0
current_cow_size_age:0
current_fork_perc:0.00
current_save_keys_processed:0
current_save_keys_total:0
rdb_changes_since_last_save:0
rdb_bgsave_in_progress:0
rdb_last_save_time:1717288573
rdb_last_bgsave_status:ok
rdb_last_bgsave_time_sec:-1
rdb_current_bgsave_time_sec:-1
rdb_saves:0
rdb_last_cow_size:0
rdb_last_load_keys_expired:0
rdb_last_load_keys_loaded:0
aof_enabled:0
aof_rewrite_in_progress:0
aof_rewrite_scheduled:0
aof_last_rewrite_time_sec:-1
aof_current_rewrite_time_sec:-1
aof_last_bgrewrite_status:ok
aof_rewrites:0
aof_rewrites_consecutive_failures:0
aof_last_write_status:ok
aof_last_cow_size:0
module_fork_in_progress:0
module_fork_last_cow_size:0

# Stats
total_connections_received:1
total_commands_processed:2
instantaneous_ops_per_sec:0
total_net_input_bytes:55
total_net_output_bytes:205212
total_net_repl_input_bytes:0
total_net_repl_output_bytes:0
instantaneous_input_kbps:0.01
instantaneous_output_kbps:0.00
instantaneous_input_repl_kbps:0.00
instantaneous_output_repl_kbps:0.00
rejected_connections:0
sync_full:0
sync_partial_ok:0
sync_partial_err:0
expired_keys:0
expired_stale_perc:0.00
expired_time_cap_reached_count:0
expire_cycle_cpu_milliseconds:0
evicted_keys:0
evicted_clients:0
total_eviction_exceeded_time:0
current_eviction_exceeded_time:0
keyspace_hits:0
keyspace_misses:0
pubsub_channels:0
pubsub_patterns:0
pubsubshard_channels:0
latest_fork_usec:0
total_forks:0
migrate_cached_sockets:0
slave_expires_tracked_keys:0
active_defrag_hits:0
active_defrag_misses:0
active_defrag_key_hits:0
active_defrag_key_misses:0
total_active_defrag_time:0
current_active_defrag_time:0
tracking_total_keys:0
tracking_total_items:0
tracking_total_prefixes:0
unexpected_error_replies:0
total_error_replies:0
dump_payload_sanitizations:0
total_reads_processed:3
total_writes_processed:5
io_threaded_reads_processed:0
io_threaded_writes_processed:0
reply_buffer_shrinks:1
reply_buffer_expands:0
eventloop_cycles:88
eventloop_duration_sum:13885
eventloop_duration_cmd_sum:3160
instantaneous_eventloop_cycles_per_sec:9
instantaneous_eventloop_duration_usec:119
acl_access_denied_auth:0
acl_access_denied_cmd:0
acl_access_denied_key:0
acl_access_denied_channel:0

# Replication
role:master
connected_slaves:0
master_failover_state:no-failover
master_replid:877058e479860a159618a5be1e2bc503d9356055
master_replid2:0000000000000000000000000000000000000000
master_repl_offset:0
second_repl_offset:-1
repl_backlog_active:0
repl_backlog_size:1048576
repl_backlog_first_byte_offset:0
repl_backlog_histlen:0

# CPU
used_cpu_sys:0.016247
used_cpu_user:0.017424
used_cpu_sys_children:0.000000
used_cpu_user_children:0.000000

# Modules

# Errorstats

# Cluster
cluster_enabled:0

# Keyspace
127.0.0.1:6379> exit
```

## What happens when you connect to `redis-cli` but the service is not started?

You get a meaningful error message stating that _Connection refused_.

> *Note*: The error message also gives the port # it attempts to connect to. The port # 6379 is the default port of Redis Server.

```sh
➜  github-repos
redis-cli
Could not connect to Redis at 127.0.0.1:6379: Connection refused
not connected>
```

## How will you start the Redis Server? 

You can use `brew services start redis` to get it started. The response is precise and meaningful with the service label.

```sh
➜  github-repos
brew services start redis
==> Successfully started `redis` (label: homebrew.mxcl.redis)
```
## How will you verify the Redis Service status?

You can use the command `brew servies list` and `grep` the `redis` on the output, which otherwise may be a long listing of all the services runnning on the machine.

If the `redis` service is running, it shows the output appropriately as follows, with the `plist` (Process List) info in Macbook.

```sh
➜  redisNotes git:(master) ✗
brew services list | grep redis
redis             started         raghavan.muthu ~/Library/LaunchAgents/homebrew.mxcl.redis.plist
```

## How will you stop the Redis Service?

You can use `brew services stop redis` to stop the service.

The output will be precise and meaningful to give you the context.  As it states that the service being shutdown is graceful and it _may take a while_, it is better to verify the service status as well subsequently to ensure that the service is properly stopped.

```sh
➜  redisNotes git:(master) ✗
brew services stop redis
Stopping `redis`... (might take a while)
==> Successfully stopped `redis` (label: homebrew.mxcl.redis)
➜  redisNotes git:(master) ✗
brew services list | grep redis
redis             none
```
