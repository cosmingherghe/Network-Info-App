package cosmingherghe.dev;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Formatter;
import java.util.List;
import java.util.Properties;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public Computer getPcNICsInfo() throws SocketException  {
        Computer comp = new Computer();
        List<NetworkCardInfo> list = NetworkTool.getNetworkInterfaces();
        Collections.sort(list, Comparator.comparing(NetworkCardInfo::isUp).reversed().thenComparing(NetworkCardInfo::getName));
        comp.setNIClist(list);
        return comp;
    }

    public String getMacAddress(NetworkInterface networkInterface) throws SocketException {
        String macAddress;
        byte[] macAddressBytes = networkInterface.getHardwareAddress();

            if (macAddressBytes != null) {
                StringBuilder sb = new StringBuilder();
                Formatter formatter = new Formatter(sb);
                for (byte b : macAddressBytes) {
                    formatter.format("%02X:", b);
                }
                formatter.close();

                macAddress = sb.toString().substring(0, sb.length() - 1);
            } else {
                macAddress = "MAC Address not found.";
            }
        return macAddress;
    }

    public String getDNS(String ipInfo) {
        Properties properties = System.getProperties();
        String dnsServers = properties.getProperty(ipInfo);
        return dnsServers;
    }
}