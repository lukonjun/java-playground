import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import com.google.common.io.Files;

public class CreateFile {

    public static void main(String[] args) throws IOException {
        File file  = createEmptyTempFile("planeten");
        System.out.print(file.getAbsolutePath());
        List<String> stringList = new ArrayList<>();
        stringList.add("Naboo");
        stringList.add("Jakku");
        stringList.add("Kamino");
        writeToFile(file,stringList);
        appendTextToTop(file,"Coruscant\n");
    }


    /**
     * Each String add to stringList gets added to the file in a separate line.
     * Existing File Content is overwritten
     * @param absolutePath
     * @param stringList
     * @throws IOException
     */
    public static void writeToFile(String absolutePath, List<String> stringList) throws IOException {

        File file = new File(absolutePath);
        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        for(String s:stringList){
            printWriter.println(s);
        }

        printWriter.close();
    }

    /**
     * Each String add to stringList gets added to the file in a separate line.
     * Existing File Content is overwritten
     * @param file
     * @param stringList
     * @throws IOException
     */
    public static void writeToFile(File file, List<String> stringList) throws IOException {

        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        for(String s:stringList){
            printWriter.println(s);
        }

        printWriter.close();
    }

    public static File createEmptyTempFile(String fileName) throws IOException {

        File tempDirectory = new File(System.getProperty("java.io.tmpdir"));
        File fileWithAbsolutePath = new File(tempDirectory.getAbsolutePath() + fileName);

        Files.touch(fileWithAbsolutePath);

        return fileWithAbsolutePath;
    }

    /**
     * Append Text to the top of the file. Line breaks in text need to be explicitly set.
     * Copy the whole file, append a line to the top and then creates a new file.
     * @param file
     * @param text
     * @throws IOException
     */
    public static void appendTextToTop(File file, String text) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(file), StandardCharsets.UTF_8));
        String result = "";
        String line = "";
        while( (line = br.readLine()) != null){
            result = result + line + "\n";
        }

        result = text + result;

        file.delete();
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(result.getBytes());
        fos.flush();
    }

}
