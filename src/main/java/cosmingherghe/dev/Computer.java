package cosmingherghe.dev;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "PCname", "NIClist" })
public class Computer {
    private String PCname;
    private List<NetworkCardInfo> NIClist;

    public Computer() {
        PCname = NetworkTool.getComputerName();
    }

    public String getPCname() {
        return PCname;
    }

    public void setPCname(String name) {
        PCname = name;
    }

    public List<NetworkCardInfo> getNIClist() {
        return NIClist;
    }

    public void setNIClist(List<NetworkCardInfo> NICs) {
        NIClist = NICs;
    }

    public void addNICtoList(NetworkCardInfo NIC) {
        NIClist.add(NIC);
    }

    @Override
    public String toString() {
        return "Computer [PCname=" + PCname + ", NIClist=" + NIClist + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((PCname == null) ? 0 : PCname.hashCode());
        result = prime * result + ((NIClist == null) ? 0 : NIClist.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Computer other = (Computer) obj;
        if (PCname == null) {
            if (other.PCname != null)
                return false;
        } else if (!PCname.equals(other.PCname))
            return false;
        if (NIClist == null) {
            if (other.NIClist != null)
                return false;
        } else if (!NIClist.equals(other.NIClist))
            return false;
        return true;
    }
}
