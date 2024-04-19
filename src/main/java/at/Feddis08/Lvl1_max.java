package at.Feddis08;

import java.io.*;

public class Lvl1_max {

    public static String savePath = "./res/";
    public static String levelName = "level1_5.in";
    public static String result = "";
    public static String instruction = "";
    public static void main(String[] args) throws IOException {
        instruction = getFile(savePath + levelName);

        String inputs[] = instruction.split("\n");


        for (String input : inputs) {
            String row[] = input.split(" ");
            result = result + level1(row) + "\n";
        }
        System.out.println(result);
        saveToFile(savePath + levelName+".new", result);

    }
    private static String level1(String row[]) {
        for (int i = 0; i < row.length; i++) {
            if(!(Integer.parseInt(row[i]) == i +1)) {
                return "" + (i + 1);
            }
        }
        return "0";
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