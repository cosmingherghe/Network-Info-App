package cosmingherghe.dev;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

public class NetworkTool {

    public static String getComputerName() {
        String hostname;
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            hostname = inetAddress.getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            hostname = "Error.";
        }
        return hostname;
    }

    public static List<NetworkCardInfo> getNetworkInterfaces() throws SocketException {
        List<NetworkCardInfo> NICs = new ArrayList<>();
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            List<NetworkInterface> interfaceList = Collections.list(interfaces);
            
            interfaceList.forEach(networkInterface -> {
                try {
                    NICs.add(fromNetworkInterface(networkInterface));
                } catch (SocketException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return NICs;
    }

    public static NetworkCardInfo fromNetworkInterface(NetworkInterface netInterface) throws SocketException {
        NetworkCardInfo info = new NetworkCardInfo();
        info.setName(netInterface.getName());
        info.setDisplayName(netInterface.getDisplayName());
        info.setInetAddress(Collections.list(netInterface.getInetAddresses())
                                    .stream()
                                    .map(inetAddress -> inetAddress.getHostAddress())
                                    .toList());
        info.setInterfaceAddress(netInterface.getInterfaceAddresses()
                                    .stream()
                                    .map(interfaceAddress ->  {
                                        String address = interfaceAddress.getAddress().getHostAddress();
                                        String broadcast = (interfaceAddress.getBroadcast() != null) ? interfaceAddress.getBroadcast().getHostAddress() : "N/A";
                                        return address + " (Subnet: " + interfaceAddress.getNetworkPrefixLength() + ", Broadcast: " + broadcast + ")";
                                    })
                                    .collect(Collectors.toList()));
        info.setSubInterfaces(Collections.list(netInterface.getSubInterfaces())
                                    .stream()
                                    .map(t -> {
                                        try {
                                            return fromNetworkInterface(t);
                                        } catch (SocketException e) {
                                            e.printStackTrace();
                                        }
                                        return new NetworkCardInfo("N\\A");
                                    })
                                    .collect(Collectors.toList()));
        info.setLoopback(netInterface.isLoopback());
        info.setPointToPoint(netInterface.isPointToPoint());
        info.setUp(netInterface.isUp());
        info.setVirtual(netInterface.isVirtual());
        info.setSupportsMulticast(netInterface.supportsMulticast());
        info.setMAC(netInterface.getHardwareAddress());
        if(netInterface.getParent() != null) { 
            info.setParent(fromNetworkInterface(netInterface.getParent())); 
        }
        //FIXME it seems that we are not getting the real data
        info.setMTU(convertBytes((netInterface.getMTU() > 0) ? netInterface.getMTU() : 0));
        return info;
    }

    public static String convertBytes(long bytes) {
        if (bytes < 0) {
            throw new IllegalArgumentException("Bytes cannot be negative");
        }

        long tb = bytes / (1024L * 1024 * 1024 * 1024);
        long gb = (bytes % (1024L * 1024 * 1024 * 1024)) / (1024L * 1024 * 1024);
        long mb = (bytes % (1024L * 1024 * 1024)) / (1024L * 1024);
        long kb = (bytes % (1024L * 1024)) / 1024;
        long b = bytes % 1024;

        StringBuilder result = new StringBuilder();
        if (tb > 0) result.append(tb).append(" TB ");
        if (gb > 0) result.append(gb).append(" GB ");
        if (mb > 0) result.append(mb).append(" MB ");
        if (kb > 0) result.append(kb).append(" KB ");
        if (b > 0) result.append(b).append(" bytes");

        return result.toString().trim();
    }
}