package utils;

import data.GenuinePhone;
import data.HandbookPhone;
import data.Phone;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneDao {
    private static final String PHONE_FILE_NAME = "phone.csv";

    public void writePhone(List<Phone> phoneList) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(PHONE_FILE_NAME);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Phone phone : phoneList) {
                bufferedWriter.write(phone.getI4());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

     public List<Phone> readPhone() {
        List<Phone> phoneList = new ArrayList<Phone>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(PHONE_FILE_NAME);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 6) {
                    try {
                        int id = Integer.parseInt(data[0]);
                        String phoneName = data[1];
                        double price = Double.parseDouble(data[2]);
                        int quantity = Integer.parseInt(data[3]);
                        String producer = data[4];
                        try {
                            int warrantyPeriod = Integer.parseInt(data[5]);
                            String warrantyScope = data[6];
                            phoneList.add(new GenuinePhone(id, phoneName, price, quantity, producer, warrantyPeriod, warrantyScope));
                        } catch (NumberFormatException e) {
                            String nation = data[5];
                            String phoneStatus = data[6];
                            phoneList.add(new HandbookPhone(id, phoneName, price, quantity, producer, nation, phoneStatus));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi định dạng số: " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fileReader.close();
                bufferedReader.close();
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return phoneList;
    }
}
