package Entities;

import NetworkHelper.Address;

public class WanInterface extends Interface{
    public WanInterface(Router router, Address address) {
        super(router, address);
    }

    @Override
    public void sendPacket(Address sender, Address receiver) {

    }
}
