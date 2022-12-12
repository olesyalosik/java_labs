import java.io.*;

public class Readers {
    static FileReader isr2;

    static {
        try {
            isr2 = new FileReader("input.csv");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static BufferedReader fileIn = new BufferedReader(isr2);

    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader sysIn = new BufferedReader(isr);

    static FileWriter file1txt;

    static {
        try {
            file1txt = new FileWriter("logfile.txt", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static BufferedWriter loggerTxt = new BufferedWriter(file1txt);

    static FileWriter file1xml;

    static {
        try {
            file1xml = new FileWriter("out.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static BufferedWriter xmlWrite = new BufferedWriter(file1xml);
    static FileWriter file1json;

    static {
        try {
            file1json = new FileWriter("out.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static BufferedWriter jsonWrite = new BufferedWriter(file1json);

    static void souTCompany(Company c) throws IOException {
        System.out.println(c.toString());
        Readers.xmlWrite.write(c.toXMLString());
        Readers.xmlWrite.newLine();
        Readers.jsonWrite.write(c.toJSONString());
        Readers.jsonWrite.newLine();
        Readers.xmlWrite.write(" ");
        Readers.xmlWrite.newLine();
        Readers.jsonWrite.write(" ");
        Readers.jsonWrite.newLine();
    }
    public Readers() throws IOException {
    }
}
