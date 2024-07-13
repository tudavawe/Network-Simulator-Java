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
* 

### Packet application flow

Application payload => Device => Orig Router => Network of Routers => Dest Router => Dest Device => Dest Application





