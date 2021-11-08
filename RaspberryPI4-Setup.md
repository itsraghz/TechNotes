# Raspberry PI (Re)Setup Guide

Creating this User Guide for my own reference, as I kinda forgot the steps involved, after a few months of inactivity :) 

## Setting up Raspberry PI and connect to the PC or an external monitor.

Connecting to a PC (via VNC Viewer) can help you reuse the same peripherals attached the PC/Laptop itself (Keyboard, Mouse and Display), whereas an external monitor will only have a display but you may need to use the keyboard and mouse connected via the respective/specific USB ports available in the Raspberry PI 4 - luckily the V4 has got 2 additional USB ports for the same reason.

You can also use a hybrid approach as well, using an extended monitor for display alone and reuse the keyboard and mouse with the laptop - totally depending on your need.

Please look at the credentials and other associated information in the respective sub sections below, for the configuration. 

## First things first - Install OS

First things first - A Raspberry PI needs to have the OS installed, which would have to be installed (as NOOBS - New Out Of the Box Software) in the Micro USB comes attached with the kit. Thanks to Pibox, where the Raspberry PI OS also was installed in the USB chip and shipped. 

Then, you need to configure the network settings in the hard disk - the entire OS and config is available in the 16 G Micro SD Card for you to play around. 

## Network Details

Add or Update a file named `wpa_supplicant.conf` in the topmost boot `/` directory of the Micro SD Card. This is a file that contains the details of the network (Wi-Fi). 

The configuration is mostly self explanatory. The recent search today has revealed that the two properties below are optional, as I had a doubt on how to configure the term *WPA2* - whether `WPA2-Personal` or `WPA2 Personal` and with and without quotes.

```
        key_mgmt="WPA2-Personal"
        scan_ssid=1
```

The sample file contents are given below.

```sh
admin@LenovaG51-35 MINGW64 /z/rags/raspberryPI
$ cat wpa_supplicant.conf
ctrl_interface=DIR=/var/run/wpa_supplicant GROUP=netdev
update_config=1
country=IN #Your country code

network={
        ssid="RaghsACTFibernet" #Your WiFi Name
        psk="act12345"  #Your WiFi password
}

admin@LenovaG51-35 MINGW64 /z/rags/raspberryPI
$ ls -l
total 3
-rw-r--r-- 1 admin 197609   0 Aug 11  2020 ssh
-rw-r--r-- 1 admin 197609 262 Nov  8 14:25 wpa_supplicant-RaghsACTFibernet.conf
-rw-r--r-- 1 admin 197609 242 Nov  8 12:59 wpa_supplicant-RaghsAirtel4GLTE.conf
-rw-r--r-- 1 admin 197609 214 Nov  8 14:25 wpa_supplicant.conf

admin@LenovaG51-35 MINGW64 /z/rags/raspberryPI
$ cat wpa_supplicant-RaghsACTFibernet.conf
ctrl_interface=DIR=/var/run/wpa_supplicant GROUP=netdev
update_config=1
country=IN #Your country code

network={
        ssid="<Network-Name-or-SSID>" #Your WiFi Name
        psk="<Password>"  #Your WiFi password
        key_mgmt="WPA2-Personal"
        scan_ssid=1
}

admin@LenovaG51-35 MINGW64 /z/rags/raspberryPI
$
```

## Enabling SSH - Headless way

The Raspberry PI without any a display is called headless mode. To get itself available for connecting from outside, you need to enable the SSH mode.

* Step 1 - Do it inside the Rasperry PI terminal 
* Step 2 - Do it outside the terminal but in the filesystem. 

Add a dummy / empty file called `ssh` in the `boot` partition/folder `/` where the `wpa_supplicant.conf` file is also present. 

```sh
admin@LenovaG51-35 MINGW64 /z/rags/raspberryPI
$ ls -l
total 3
-rw-r--r-- 1 admin 197609   0 Aug 11  2020 ssh
-rw-r--r-- 1 admin 197609 214 Nov  8 14:25 wpa_supplicant.conf

```

Once you boot up the Raspberry PI, it will look for this file and prepare itself to be connected via SSH Terminal.

You can issue the `ssh` command to get yourself connected to the Raspberry PI remotely in an usual/typical fashion.

```
ssh pi@<IPAddress>
```

There is a standard/default user named `pi` created in every Raspberry PI ,much similar to a root. You can also create your own, like `raghs` is what I created with the super/root privileges of course :) 

```
sh raghs@192.168.0.103
```

## Raspberry Kit Details

Got it from PiBox.
RaspberryPi 4 with 4GB RAM.

# Credentials

## Raspberry PI 

> ssh pi@<IP> [Password: <Verify-RaghsPHP-Application>]
> su raghs [new user created on the PI4 box]

## Wifi Details

http://192.168.0.1 - Router Admin Console for Act Fibernet
Password : act@123

Wifi SSID (Service Set Identifier) - RaghsACTFibernet / act12345 (WPA2-Personal)

# Terminologies / Abbreviations

* WPA - Wi-fi Protected Access
* WPA-PSK - Pre-shared Key
* WPA-Personal - extension/new enhancement of WPA PSK
* SSID - [Service Station Identifier](https://www.webopedia.com/definitions/ssid/)
* VNC
* SSH - Secured Socket Shell

# Toolkit

* VNC Viewer
* Extended Monitor
* Putty or any terminal client 
* Extended Monitor, External Keyboard and Mouse  - USB Compatible - if needed

## Getting to know the IP Address of the Raspberry PI

The moment the Raspberry PI gets booted, it picks up the network details from the `wpa_supplicant.conf` file and gets itself connected , provided the details are intact. 

Also, it enabled the *SSH* , if it finds the `ssh` file present in the boot system folder.

To get the IP address allotted to the Raspberry PI, you can use follow any of the two steps.

* Step 1 - Command line
* Step 2 - Router Admin Console 

### Step 1 - Command Line

Issue the following command in the terminal to get the list of devices/IP addresses available in the network. 

`arp -a`

*ARP* stands for *Address Resolution Protocol* and the option `-a` indicates to display *all*.  This is the primary reason we want the Raspberry PI to be a part of the same network. 

> Note: You can get the Raspberry PI connected to the same network via the Ethernet Cable as well, for which the Raspberry PI Kit has got the Ethernet port available. The modern laptops don't have the Ethernet Port, which you need to verify it prior. 

I tried to connect the Raspberry PI via Ethernet cable once today, as an alternate as long time the Raspberry PI did not catch the wifi network at all but after a while I got the PI connected to the external monitor, as the ethernet stuff did not yield a proper result and also I have wasted a few hours already.

```sh
admin@LenovaG51-35 MINGW64 /z/rags/raspberryPI
$ arp -a

Interface: 192.168.0.102 --- 0x11
  Internet Address      Physical Address      Type
  192.168.0.1           d8-07-b6-ec-9c-ae     dynamic
  192.168.0.100         00-15-00-01-4c-33     dynamic
  192.168.0.103         cc-d4-2e-cc-95-56     dynamic
  192.168.0.106         f4-0f-24-0c-50-06     dynamic
  192.168.0.255         ff-ff-ff-ff-ff-ff     static
  224.0.0.2             01-00-5e-00-00-02     static
  224.0.0.22            01-00-5e-00-00-16     static

admin@LenovaG51-35 MINGW64 /z/rags/raspberryPI
$
```

Here the IP address `192.168.0.103` is the IP allotted for the Raspberry PI. It is again a dynamically allotted IP Address. You can verify the devices via the Router Admin Console to be very sure and easily picking up.

## Step 2 - Router Admin Console.

Another way to really get the right IP address for the Raspberry PI device is to check the Wi-fi Settings in the Router's *Admin Console*, where you can find the list of connected devices, along with their names (`hostname`) and the respective IP address.

```sh
Online Devices
	ID	Device Name	IP Address	MAC Address	Connection Type
	1	Unknown	192.168.0.100	00-15-00-01-4C-33	Wireless
	2	android-10231178fc48a475	192.168.0.101	F8-84-F2-08-05-34	Wireless
	3	LenovaG51-35	192.168.0.102	48-E2-44-4C-A4-83	Wireless
	4	raspberrypi	192.168.0.103	DC-A6-32-A6-60-64	Wireless
	5	Raghavan-alias-Saravanan-s-M42	192.168.0.104	A6-A2-10-E8-6E-87	Wireless
``` 

You can see that the device `raspberrypi` has been registered with the IP address `192.168.0.103`. 

## Connect to the Raspberry PI

You can connect to the Raspberry PI in two different ways.

* Step 1- Using a `putty` like terminal client
* Step 2- Using *VNCViewer* to get the desktop of the Raspberry PI. 

### Step 1 - Using a `putty` like terminal client

You can use either *putty* or any other terminal which can talk on Linux stuff. 


`ssh pi@<IPAddress>`

supply the actual values,

`ssh pi@192.168.0.103`

will ask for the password. Supply the one you created. By default the password is `raspberry`.

# Raspberry PI Update

You can update the Raspberry PI - Kernel and its libraries via the command `raspi-config` which should be prefixed with `sudo` as this command should be executed by a root user for the sensitivity of this command.

In the menu options displayed, choose the appropriate menu/sub-menu to invoke the System update. 

```sh
raghs@raspberrypi:/home/pi $ sudo raspi-config
Hit:1 http://raspbian.raspberrypi.org/raspbian buster InRelease
Hit:2 http://archive.raspberrypi.org/debian buster InRelease
Reading package lists... Done
Reading package lists... Done
Building dependency tree
Reading state information... Done
The following packages will be upgraded:
  raspi-config
1 upgraded, 0 newly installed, 0 to remove and 392 not upgraded.
Need to get 28.0 kB of archives.
After this operation, 8,192 B of additional disk space will be used.
Get:1 http://archive.raspberrypi.org/debian buster/main armhf raspi-config all 20210212 [28.0 kB]
Fetched 28.0 kB in 1s (38.3 kB/s)
Reading changelogs... Done
(Reading database ... 160830 files and directories currently installed.)
Preparing to unpack .../raspi-config_20210212_all.deb ...
Unpacking raspi-config (20210212) over (20200727) ...
Setting up raspi-config (20210212) ...
Processing triggers for systemd (241-7~deb10u4+rpi1) ...
Sleeping 5 seconds before reloading raspi-config
BCM2711 detected
Dedicated VL805 EEPROM detected
*** UPDATE AVAILABLE ***
BOOTLOADER: update available
CURRENT: Thu 16 Apr 2020 05:11:26 PM UTC (1587057086)
 LATEST: Fri 31 Jul 2020 01:43:39 PM UTC (1596203019)
 FW DIR: /lib/firmware/raspberrypi/bootloader/stable
VL805: update available
CURRENT: 000137ad
 LATEST: 000138a1
Connection to 192.168.0.103 closed by remote host.
Connection to 192.168.0.103 closed.

C:\Users\admin
λ
```

# Connecting through the VNC Viewer

Once the Raspberry PI 4 device gets booted and connects itself to/with the network configured, all we may need is either a terminal or GUI to take charge of the OS and the filesytem. 

The terminal is accessed via the Command Line but the display / visual part is handled by the VNC Viewer. 

To connect the Raspberry PI via the VNC Viewer, for which it needs the following steps.

* Install VNC Viewer on both the Windows 10 and Raspberry PI 4 devices
* Enable the VNC in the Raspberry PI terminal, with the root access (sudo) #Todo the commands

Once the VNC viewer/client is installed, all you may need is the IP address of the Raspberry PI 4. 

Note: This you can get it from `arp -a` command

The VNC immediately gets you the acutal *remote control* of the GUI desktop of the Raspberry PI 4. You can have the entire desktop of the Raspberry PI at your hands now, with which you can continue to the use the System in the usual manner.

```
# Shutdown

Whenever possible you should be shutting down the Raspberry PI in a proper and graceful way, which can prevent the device maintain a proper health and also not getting corrupted. 

```sh
sudo shutdown
```

Executing this command will submit a request to the Kernel and the kernal will confirm it saying that the shutdown request has been registered and as a goodwill or kind gesture, it gives 1 minute for the user to windup / close the activities which he/she was doing it, and it will also printthe message in the termainl indicating the time at which the shutdown will take place. It will shutdown at the right/informed time. 

```sh
pi@raspberrypi:~ $
Broadcast message from root@raspberrypi on pts/0 (Mon 2021-11-08 16:37:49 IST):

The system is going down for poweroff at Mon 2021-11-08 16:38:49 IST!


Broadcast message from root@raspberrypi on pts/0 (Mon 2021-11-08 16:38:49 IST):

The system is going down for poweroff NOW!

Connection to 192.168.0.103 closed by remote host.
Connection to 192.168.0.103 closed.

C:\Users\admin
λ
```
