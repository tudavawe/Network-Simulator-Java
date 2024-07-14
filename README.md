# Network-Simulator-Java

Simulate the behaviour of a network with multiple routers, each having their own devices through organising the network as a graph.

### Layer description:
* Physical layer:
    * Static and unique entity for the entire network
    * Mode : Wired or Wireless
    * void Transmit(Addr* origin, Addr* destination, Mode mode)
    * Random errors
* Other layers : Part of each router entity, communication between layers follow OSI model excluding layers 5-7

### Entity description:
* Router
* Device
* Application
* Physical layer Entity
* Message encoding Entity
* Message
* Connection

### Packet application flow

Application payload => Device => Orig Router => Network of Routers => Dest Router => Dest Device => Dest Application

### Problems to solve

1) Device to router
   * Wired
   * Wireless
   * 0, 1 or more devices
2) Logging system
3) How to be able to make more devices send in the interval such that collisions happen
4) Main Interface
5) Router to router = Ethernet
6) Switches ??
7) Should there be a DHCP server??
8) Message creation maybe differs (Router, Device)




### Important values
DHCP Server address:


