package companyAndDevice;

import companyAndDevice.Device;
import companyAndDevice.ProductionType;

import java.util.List;

public class Company {
    private String name;
    private String address;
    private ProductionType productionType;
    private List<Device> devices;

    public Company(String name, String address, ProductionType productionType, List<Device> devices) {
        this.name = name;
        this.address = address;
        this.productionType = productionType;
        this.devices = devices;
    }

    public String getName() {return name;}

    public String getAddress() {return address;}

    public Enum getProductionType() {return productionType;}

    public List<Device> getDevices() {return devices;}

}
