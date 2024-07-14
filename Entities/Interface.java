package Entities;

import NetworkHelper.Address;

public abstract class Interface {
    private final Router router;
    private final Address address;

    public Interface(Router router, Address address) {
        this.router = router;
        this.address = address;
    }

    public Router getRouter() {
        return router;
    }

    public Address getAddress() {
        return address;
    }

    public abstract void sendPacket(Address sender, Address receiver);
}
