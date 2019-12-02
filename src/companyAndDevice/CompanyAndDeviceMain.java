package companyAndDevice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CompanyAndDeviceMain {

    private static final String FILE_LOCATION = "C:\\Users\\Vartotojas\\IdeaProjects\\company-device\\src\\companyAndDevice\\data.txt";

    public static void main(String[] a) {
        List<Company> companyList = getCompanyListFromFile();
        
        for (Company company : companyList) {
            System.out.println(company.toString());
        }

        for (Company value : companyList) {
            System.out.println(Math.max(value.getDevices().get(0).getPrice(), value.getDevices().get(1).getPrice()));
        }
        for (Company company: companyList){
            if (company.getProductionType().equals("TECHNOLOGIES")){
                System.out.println(company.toString());
            }
        }
    }

    private static List<Company> getCompanyListFromFile() {
        List<Company> companyList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_LOCATION))) {
            String line = "";

            while (line != null) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] splittedLine = line.split(";");
                companyList.add(mapCompanyDataToObject(splittedLine));

            }
        } catch (IOException e) {
            System.out.println("Klaida nuskaitant faila");
        }
        return companyList;
    }

    private static Company mapCompanyDataToObject(String[] companyData) {
        return new Company(companyData[0], companyData[1], mapProductionTypeData(companyData[2]), mapDeviceToObjectData(companyData[3]));
    }

    private static String mapProductionTypeData(String productiontype) {
        switch (productiontype.toLowerCase()) {
            case ("technologies"): {
                return ProductionType.TECHNOLOGIES.name();

            }
            case ("automobiles"): {
                return ProductionType.AUTOMOBILES.name();

            }
            case ("garden_tools"): {
                return ProductionType.GARDEN_TOOLS.name();

            }
            case ("food"): {
                return ProductionType.FOOD.name();

            }
            default: {
                return ("error");

            }
        }
    }

    private static List<Device> mapDeviceToObjectData(String deviceData) {
        List<Device> deviceList = new ArrayList<>();
        String[] splittedLine = deviceData.split("-");
        for (String deviceInfo : splittedLine) {
            String[] devicesData = deviceInfo.split(",");
            deviceList.add(new Device(devicesData[0], Double.parseDouble(devicesData[1]), Integer.parseInt(devicesData[2]), devicesData[3]));
        }
        return deviceList;
    }
}

