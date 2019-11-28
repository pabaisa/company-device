package companyAndDevice;

import java.util.List;

public class Company {
    private String name;
    private String address;
    private String productionType;
    private List<Device> devices;

    public Company(String name, String address, String productionType, List<Device> devices) {
        this.name = name;
        this.address = address;
        this.productionType = productionType;
        this.devices = devices;
    }

    public String getName() {return name;}

    public String getAddress() {return address;}

    public String getProductionType() {return productionType;}

    public List<Device> getDevices() {return devices;}

     public String toString(){
        return String.format ("Company name: %s, address: %s, Production Type: %s, %s, %s", name, address, getProductionType(), devices.get(0).toString(), devices.get(1).toString());
    }

}
