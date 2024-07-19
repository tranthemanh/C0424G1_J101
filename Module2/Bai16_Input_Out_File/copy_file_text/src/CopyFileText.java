import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFileText {

    public List<Integer> readFile(String filePath) {
        List<Integer> list = new ArrayList<Integer>();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException("File khong ton tai.");
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                list.add(Integer.parseInt(line));
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    public void writeFile(String filePath, List<Integer> list) {
        try {
            FileWriter writer = new FileWriter(filePath);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(list.toString());
            bw.close();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
