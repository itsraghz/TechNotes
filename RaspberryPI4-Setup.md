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
        ssid="RaghsACTFibernet" #Your WiFi Name
        psk="act12345"  #Your WiFi password
        key_mgmt="WPA2-Personal"
        scan_ssid=1
}

admin@LenovaG51-35 MINGW64 /z/rags/raspberryPI
$
```

## Raspberry Kit Details

Got it from PiBox.
RaspberryPi 4 with 4GB RAM.

# Credentials

## Raspberry PI 

> ssh pi@<IP> [Password: RaghsPI4@123]
> su raghs / RaghsPI4@123

## Wifi Details

http://192.168.0.1 - Router Admin Console for Act Fibernet
Password : act@123

Wifi SSID (Service Set Identifier) - RaghsACTFibernet / act12345 (WPA2-Personal)

