package Entities;

import NetworkHelper.Address;

public class LanInterface extends Interface{
    public LanInterface(Router router, Address address) {
        super(router, address);
    }

    @Override
    public void sendPacket(Address sender, Address receiver) {

    }
}
