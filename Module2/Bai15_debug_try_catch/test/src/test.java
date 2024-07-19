import java.io.*;

public class test {
    public static void main(String[] args) {
        File myFile = new File("data.txt");
        //kiem tra file ton tai
        try {
            if (!myFile.exists()) {
                throw new FileNotFoundException("File not found");
            }
            //Kiem tra quyen doc
            if (!myFile.canRead()) {
                throw new Exception("Cannot read file");
            }
            //kiem tra quyen ghi
            if (!myFile.canWrite()) {
                throw new Exception("Cannot write file");
            }
            //Thao tac doc ghi du lieu
            //Thao tac ghi dữ liệu voi class FileWriter
            FileWriter fileWriter = new FileWriter(myFile);
            fileWriter.write("Hello Worlddddddddddd");
            //ghi dòng mới
            fileWriter.write("\n");
            fileWriter.write("Goodbye Worlddddddddddd");
            fileWriter.close();



        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            FileReader fileReader = new FileReader(myFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
