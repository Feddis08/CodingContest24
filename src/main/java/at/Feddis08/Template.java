package at.Feddis08;

import java.io.*;

public class Template {

    public static String savePath = "./res/";
    public static String levelName = "Level1.txt";
    public static String result = "";
    public static String instruction = "";
    public static void main(String[] args) throws IOException {
        System.out.println(getFile(savePath + "./test.txt"));
        instruction = getFile(savePath + levelName);

        saveToFile(savePath + levelName, result);

    }
    private static void saveToFile(String filePath, String data) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filePath, "UTF-8");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        writer.write(data);
        writer.close();
    }
    public static String getFile(String path) throws IOException {
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        String result = br.readLine();
        while ((st = br.readLine()) != null){
            result = result + "\n" + st;
        }
        return result;
    }
}