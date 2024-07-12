package manager;

import data.GenuinePhone;
import data.HandbookPhone;
import data.Phone;
import utils.PhoneDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneManager {
    private static Scanner sc = new Scanner(System.in);
    private List<Phone> phoneList;
    private PhoneDao phoneDao;

    public PhoneManager() {
        phoneDao = new PhoneDao();
        phoneList = phoneDao.readPhone();
    }

    public void add() {
        try {
            int id = (phoneList.size() > 0) ? (phoneList.get(phoneList.size() - 1).getId() + 1) : 1;

            System.out.println("Enter phone number: ");
            String phoneNumber = sc.nextLine();

            System.out.println("Enter phone price: ");
            double phonePrice = Double.parseDouble(sc.nextLine());

            System.out.println("Enter phone quantity: ");
            int phoneQuantity = Integer.parseInt(sc.nextLine());

            System.out.println("Enter phone producer: ");
            String phoneProducer = sc.nextLine();

            System.out.println("Type of phone (1 - Genuine phone, 2 - Handbook phone): ");
            int phoneType = Integer.parseInt(sc.nextLine());

            Phone phone = null;

            if (phoneType == 1) {
                System.out.println("Enter warranty period: ");
                int warrantyPeriod = Integer.parseInt(sc.nextLine());

                System.out.println("Enter warranty scope: ");
                String warrantyScope = sc.nextLine();

                phone = new GenuinePhone(id, phoneNumber, phonePrice, phoneQuantity, phoneProducer, warrantyPeriod, warrantyScope);
                phoneList.add(phone);
                phoneDao.writePhone(phoneList);
            }else if(phoneType == 2) {
                System.out.println("Enter nation: ");
                String nation = sc.nextLine();

                System.out.println("Enter phoneStatus: ");
                String phoneStatus = sc.nextLine();

                phone = new HandbookPhone(id, phoneNumber, phonePrice, phoneQuantity, phoneProducer, nation, phoneStatus);
                phoneList.add(phone);
                phoneDao.writePhone(phoneList);
            }else {
                System.out.println("Invalid medical record type");
            }
            System.out.println(" Add phone successfully");
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
    }

    public void delete(){
        System.out.println("Enter phone id: ");
        int id = Integer.parseInt(sc.nextLine());
        Phone phone = findPlayerById(id);

        if (phone != null) {
            System.out.println("Are you sure you want to delete? (1 is yes, 0 is no): ");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice == 1) {
                phoneList.remove(phone);
                updatePhoneIds();
                phoneDao.writePhone(phoneList);
                System.out.println("Phone delete successfully.");
            } else {
                System.out.println("Phone not delete.");
            }
        } else {
            System.out.println("ID does not exist");
        }
    }

    private Phone findPlayerById(int id) {
        for (Phone phone : phoneList) {
            if (phone.getId() == id) {
                return phone;
            }
        }
        return null;
    }

    private void updatePhoneIds() {
        for (int i = 0; i < phoneList.size(); i++) {
            phoneList.get(i).setId(i + 1);
        }
    }

    public void displayPhone() {
        if (phoneList.isEmpty()) {
            System.out.println("No phones to display.");
        } else {
            for (Phone phone : phoneList) {
                System.out.println(phone);
            }
        }
    }

    public void searchByPhoneName() {
        System.out.println("Enter phone name to search: ");
        String name = sc.nextLine();
        List<Phone> results = new ArrayList<>();
        for (Phone phone : phoneList) {
            if (phone.getPhoneName().toLowerCase().contains(name.toLowerCase())) {
                results.add(phone);
            }
        }
        if (results.isEmpty()) {
            System.out.println("No phones found with name '" + name + "'.");
        } else {
            System.out.println("Phones found with name '" + name + "':");
            for (Phone phone : results) {
                System.out.println(phone);
            }
        }
    }
}

