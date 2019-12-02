package companyAndDevice;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyAndDeviceMain {

    private static final String FILE_LOCATION = "C:\\Users\\Vartotojas\\IdeaProjects\\company-device\\src\\companyAndDevice\\data.txt";
    private static final String OUTPUT_FILE_LOCATION = "C:\\Users\\Vartotojas\\IdeaProjects\\company-device\\src\\companyAndDevice\\output.txt";

    public static void main(String[] a) {
        List<Company> companyList = getCompanyListFromFile();

        for (Company company : companyList) {
            if (company.getDevices().get(0).getPrice() > company.getDevices().get(1).getPrice()) {
                System.out.printf("Brangiausias %s Device objektas yra: %s", company.getName(), company.getDevices().get(0).getName());
                System.out.println();
            }
            if (company.getDevices().get(0).getPrice() < company.getDevices().get(1).getPrice()) {
                System.out.printf("Brangiausias %s Device objektas yra: %s", company.getName(), company.getDevices().get(1).getName());
                System.out.println();
            }

        }
        writeDataToFile(companyList);
    }
/*        for (Company company: companyList){
            if (company.getProductionType().equals("TECHNOLOGIES")){
                System.out.println(company.toString());
            }
        }*/

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

    private static void writeDataToFile(List<Company> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_LOCATION))) {

            bw.write("5 objektų inicializavimas:\n\n");

            for (Company company : data) {
                bw.write(String.valueOf(company) + "\n");
            }
            bw.write("\n");

            for (Company company : data) {
                if (company.getDevices().get(0).getPrice() > company.getDevices().get(1).getPrice()) {
                 bw.write("Brangiausias " + company.getName() + " Device objektas yra: " + company.getDevices().get(0).getName()+ "\n");
                }
                if (company.getDevices().get(0).getPrice() < company.getDevices().get(1).getPrice()) {
                    bw.write("Brangiausias " + company.getName() + " Device objektas yra: " + company.getDevices().get(1).getName()+ "\n");
                }

            }


                } catch(IOException e){
                    System.out.println("Klaida, rasant i faila");
                }
            }

        }

