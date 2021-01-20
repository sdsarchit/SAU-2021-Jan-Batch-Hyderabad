//import org.appache.commons.csv.*;
import java.io.*;
import java.util.*;
public class DeserialPrint{
static  List<Map.Entry<Integer, Integer>> deserializeAndSort(String fileName)throws Exception
    {
        HashMap<Integer, Integer> rollTotalMarks = null;

        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        rollTotalMarks = (HashMap<Integer, Integer>) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();

        List<Map.Entry<Integer, Integer>> tempList = new LinkedList<>(rollTotalMarks.entrySet());

        tempList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
                return (entry2.getValue()).compareTo(entry1.getValue());
            }
        });

        System.out.println("\nRank\tRoll number\tTotal Marks(300)");
        for(int i = 0; i < tempList.size(); i++)
        {
            System.out.println(i + 1 + "\t\t\t" + tempList.get(i).getKey() + "\t\t\t" + tempList.get(i).getValue());
        }
        return tempList;
    }

    static void writeToCSV(List<Map.Entry<Integer, Integer>> data, String path)throws Exception    {

//        Writing top 5 to CSV
        data.subList(5, data.size()).clear();
        System.out.println(data);

        try (FileWriter writer= new FileWriter(path, true);){
           for(int i = 0; i<data.size();i++){
                        writer.write(data.get(i).getKey());
                 writer.write(",");
           }
           writer.write("\r\n");
           for(int i = 0; i<data.size();i++){
                        writer.write(data.get(i).getValue());
                 }
                 writer.write("\r\n");
           }
        catch (IOException ex) {
            ex.printStackTrace();
        }


    }

    public static void main(String[] args)throws Exception {
        List<Map.Entry<Integer, Integer>> deserializedSortedData =  deserializeAndSort("student.txt");
        writeToCSV(deserializedSortedData, "rank.csv");
    }
}