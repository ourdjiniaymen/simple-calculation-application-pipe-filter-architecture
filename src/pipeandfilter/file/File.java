package pipeandfilter.file;

import java.io.*;

public class File {
    public File(String nameFile) {
        this.nameFile = nameFile;
    }

    private String nameFile;

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public void writeLine(String line) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nameFile, true));
            writer.append(line).append("\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFile() {
        String content = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nameFile));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            String ls = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            // delete the last new line separator
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            reader.close();

            content = stringBuilder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
