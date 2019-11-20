package sample.maven.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;

import java.io.InputStream;
import java.io.PushbackInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;

import java.util.List;
import java.util.ArrayList;

public class MavenMainClass {

    public static void main(String[] args) throws IOException {

//        String inputFile = "/Users/shanaka/Desktop/vfs/smook/test.csv";
//        CSVReader reader = new CSVReader(new FileReader(inputFile), ',', '"');
//        //  String[] line = reader.readNext();
//
//        List<String[]> data = reader.readAll();
//
//        int k = 0;
//        //  while ((line = reader.readNext()) != null) {

        String inputFile = "/Users/shanaka/Documents/tickets/CAPGEMINISUB-2/test.csv";
        FileReader reader = new FileReader(inputFile);

        int quote = '"';
        int c;
        boolean withinQuote = false;
        int maxBatchCount = 2;
        int currentBatchCount = 0;
        ArrayList<Integer> chars = new ArrayList<Integer>();
        int k = 0;
        while ((c = reader.read()) != -1) {
            if (c == quote) {
                withinQuote = !withinQuote;
            }
            if (!withinQuote && c == '\n') {
                currentBatchCount++;

                if (currentBatchCount >= maxBatchCount) {
                    File f = new File("/Users/shanaka/Documents/tickets/CAPGEMINISUB-2/WriteChar" + k + ".csv");
                    k++;
                    chars.add((int) ',');
                    FileWriter out = new FileWriter(f);
                    for (int i = 0; i < chars.size(); i++) {
                        out.write(chars.get(i));
                    }
                    out.close();
                    System.out.println("Done ..........");
                    chars.clear();
                    currentBatchCount = 0;
                    continue;
                }
            }
            chars.add(c);
        }
        File f = new File("/Users/shanaka/Documents/tickets/CAPGEMINISUB-2/WriteChar" + "final" + ".csv");
        chars.add((int) ',');
        FileWriter out = new FileWriter(f);
        for (int i = 0; i < chars.size(); i++) {
            out.write(chars.get(i));
        }
        out.close();
        System.out.println("Finish ..........");

//        for (String[] rows : data) {
//
//           /* String row=null;
//            for (int i = 0; i < line.length; i++) {
//                System.out.print(line[i]);
//                System.out.print(",");
//                row = row + line[i] + ",";
//            }*/
//
//
//
//           // List<String[]> allRows = parser.parseAll(new FileReader(new File("/Users/shanaka/Desktop/vfs/smook/test.csv")));
//
//            String dataa = Arrays.toString(rows);
//            //System.out.println(dataa);
//            FileWriter csvWriter = new FileWriter("/Users/shanaka/Documents/tickets/CAPGEMINISUB-2/" + "new" + k + ".csv");
//            csvWriter.write(dataa);
//            csvWriter.flush();
//            csvWriter.close();
//            k++;
//        }

//        while ((line = reader.readNext()) != null) {
//            String row=null;
//            for (int i = 0; i < line.length; i++) {
//                System.out.print(line[i]);
//                System.out.print(",");
//                row = row + line[i] + ",";
//            }
//            System.out.println(" ");
//            FileWriter csvWriter = new FileWriter("/Users/shanaka/Documents/tickets/CAPGEMINISUB-2/"+"new"+k+".csv");
//            csvWriter.write(row);
//            csvWriter.flush();
//            csvWriter.close();
//            k++;
//        }

//        BufferedReader csvReader = new BufferedReader(new FileReader(inputFile));
//        String row;
//        int i=0;
//        while ((row = csvReader.readLine()) != null) {
//            // do something with the data
//
//            FileWriter csvWriter = new FileWriter("/Users/shanaka/Documents/tickets/CAPGEMINISUB-2/"+"new"+i+".csv");
//            csvWriter.write(row);
//            csvWriter.flush();
//            csvWriter.close();
//            i++;
//        }
//        csvReader.close();

    }

}
