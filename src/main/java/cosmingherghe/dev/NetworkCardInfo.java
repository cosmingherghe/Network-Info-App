package cosmingherghe.dev;

import java.util.List;

public class NetworkCardInfo {
    private String name;
    private String displayName;
    // Returns the hardware address (usually MAC) of the interface if it has one and if it can be accessed given the current privileges.
    String MAC;	
    // IP address (either IPv4 or IPv6).
    private List<String> inetAddress;
    // IP address along with its subnet mask and broadcast address.
    private List<String> interfaceAddress;
    // Returns whether a network interface is a loopback interface.
    boolean	isLoopback;
    // Returns whether a network interface is a point to point interface.
    boolean	isPointToPoint;
    // Returns whether a network interface is up and running.
    boolean	isUp;
    // Returns whether this interface is a virtual interface (also called subinterface).
    boolean	isVirtual;
    // Returns whether a network interface supports multicasting or not.
    boolean	supportsMulticast;
    // Returns the Maximum Transmission Unit (MTU) of this interface.
    String MTU;
    // Returns the parent NetworkInterface of this interface if this is a subinterface, or null if it is a physical (non virtual) interface or has no parent.
    NetworkCardInfo parent;
    // Get an Enumeration with all the subinterfaces (also known as virtual interfaces) attached to this network interface.
    List<NetworkCardInfo> subInterfaces;
    public NetworkCardInfo() {
    }

    public NetworkCardInfo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<String> getInetAddress() {
        return inetAddress;
    }

    public void setInetAddress(List<String> inetAddress) {
        this.inetAddress = inetAddress;
    }

    public List<String> getInterfaceAddress () {
        return interfaceAddress;
    }

    public void setInterfaceAddress(List<String> interfaceAddress) {
        this.interfaceAddress = interfaceAddress;
    }

    public boolean isLoopback() {
        return isLoopback;
    }

    public void setLoopback(boolean isLoopback) {
        this.isLoopback = isLoopback;
    }

    public boolean isPointToPoint() {
        return isPointToPoint;
    }

    public void setPointToPoint(boolean isPointToPoint) {
        this.isPointToPoint = isPointToPoint;
    }

    public boolean isUp() {
        return isUp;
    }

    public void setUp(boolean isUp) {
        this.isUp = isUp;
    }

    public boolean isVirtual() {
        return isVirtual;
    }

    public void setVirtual(boolean isVirtual) {
        this.isVirtual = isVirtual;
    }

    public boolean isSupportsMulticast() {
        return supportsMulticast;
    }

    public void setSupportsMulticast(boolean supportsMulticast) {
        this.supportsMulticast = supportsMulticast;
    }

    public String getMAC() {
        return MAC;
    }

    public void setMAC(byte[] mac) {
        if (mac != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i],
                                (i < mac.length - 1) ? "-" : ""));
            }
            this.MAC = sb.toString();
        }
    }

    public void setMAC(String mAC) {
        MAC = mAC;
    }

    public String getMTU() {
        return MTU;
    }

    public void setMTU(String MTU) {
        this.MTU = MTU;
    }

    public NetworkCardInfo getParent() {
        return this.parent;
    }

    public void setParent(NetworkCardInfo parent) {
        this.parent = parent;
    }

    public List<NetworkCardInfo> getSubInterfaces() {
        return subInterfaces;
    }

    public void setSubInterfaces(List<NetworkCardInfo> subInterfaces) {
        this.subInterfaces = subInterfaces;
    }
}