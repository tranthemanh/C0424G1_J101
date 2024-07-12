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

            String phoneName;
            while (true) {
                System.out.println("Enter phone name: ");
                phoneName = sc.nextLine();
                if (isValidName(phoneName)) {
                    System.out.println("Invalid name. It should not be empty.");
                } else {
                    break;
                }
            }


            double phonePrice;
            while (true) {
                System.out.println("Enter phone price: ");
                phonePrice = Double.parseDouble(sc.nextLine());
                if (!isValidPrice(phonePrice)) {
                    System.out.println("Invalid price. It should be a valid number greater than 0.");
                } else {
                    break;
                }
            }

            int phoneQuantity;
            while (true) {
                System.out.println("Enter phone quantity: ");
                phoneQuantity = Integer.parseInt(sc.nextLine());
                if (!isValidQuantity(phoneQuantity)) {
                    System.out.println("Invalid quantity. It should be a positive number.");
                } else {
                    break;
                }
            }

            String phoneProducer;
            while (true) {
                System.out.println("Enter phone producer: ");
                phoneProducer = sc.nextLine();
                if (!isValidProducer(phoneProducer)) {
                    System.out.println("Invalid producer. It should not be empty.");
                } else {
                    break;
                }
            }


            System.out.println("Type of phone (1 - Genuine phone, 2 - Handbook phone): ");
            int phoneType = Integer.parseInt(sc.nextLine());

            Phone phone = null;

            if (phoneType == 1) {
                int warrantyPeriod;
                while (true) {
                    System.out.println("Enter warranty period: ");
                    warrantyPeriod = Integer.parseInt(sc.nextLine());
                    if (!isValidWarrantyPeriod(warrantyPeriod)) {
                        System.out.println("Invalid warranty period. It should be a positive number not exceeding 730 days.");
                    } else {
                        break;
                    }
                }

                String warrantyScope;
                while (true) {
                    System.out.println("Enter warranty scope: ");
                    warrantyScope = sc.nextLine();
                    if (!isValidWarrantyScope(warrantyScope)) {
                        System.out.println("Invalid warranty scope. It should be 'Noi Dia' or 'Quoc Te'.");
                    } else {
                        break;
                    }
                }
                phone = new GenuinePhone(id, phoneName, phonePrice, phoneQuantity, phoneProducer, warrantyPeriod, warrantyScope);
                phoneList.add(phone);
                phoneDao.writePhone(phoneList);
            } else if (phoneType == 2) {
                String nation;
                while (true) {
                    System.out.println("Enter nation: ");
                    nation = sc.nextLine();
                    if (!isValidNation(nation)) {
                        System.out.println("Invalid nation. It should not be Vietnam.");
                    } else {
                        break;
                    }
                }

                String phoneStatus;
                while (true) {
                    System.out.println("Enter phoneStatus: ");
                    phoneStatus = sc.nextLine();
                    if (!isValidPhoneStatus(phoneStatus)) {
                        System.out.println("Invalid phone status. It should be 'Da su dung' or 'May moi'.");
                    } else {
                        break;
                    }
                }

                phone = new HandbookPhone(id, phoneName, phonePrice, phoneQuantity, phoneProducer, nation, phoneStatus);
                phoneList.add(phone);
                phoneDao.writePhone(phoneList);
            } else {
                System.out.println("Invalid medical record type");
            }
            System.out.println(" Add phone successfully");
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete() {
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
            if (phone.getName().toLowerCase().contains(name.toLowerCase())) {
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

    private static boolean isValidName(String name) {
        return name != null && name.trim().isEmpty();
    }

    private static boolean isValidPrice(double price) {
        return price > 0;
    }

    private static boolean isValidQuantity(int quantity) {
        return quantity > 0;
    }

    private static boolean isValidProducer(String producer) {
        return producer != null && !producer.trim().isEmpty();
    }

    private static boolean isValidWarrantyPeriod(int warrantyPeriod) {
        return warrantyPeriod > 0 && warrantyPeriod <= 730;
    }

    private static boolean isValidWarrantyScope(String warrantyScope) {
        return "Noi Dia".equalsIgnoreCase(warrantyScope) || "Quoc Te".equalsIgnoreCase(warrantyScope);
    }

    private static boolean isValidNation(String nation) {
        return nation != null && !nation.trim().equalsIgnoreCase("Viet nam");
    }

    private static boolean isValidPhoneStatus(String phoneStatus) {
        return "Da su dung".equalsIgnoreCase(phoneStatus) || "Hang moi".equalsIgnoreCase(phoneStatus);
    }
}

