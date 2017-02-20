package slobevg.etl.load;

import slobevg.etl.data.User;
import slobevg.etl.exceptions.LoaderException;
import sun.rmi.server.UnicastServerRef;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by meltzer on 20.02.17.
 */
public class CSVLoader implements Loader {
    private char separator;
    private String fileName;
    private String charSet;

    public CSVLoader(char separator, String fileName, String charSet) {
        this.separator = separator;
        this.fileName = fileName;
        this.charSet = charSet;
    }

    @Override
    public void load(Collection<User> userList) throws LoaderException {
        try
        {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), charSet));
            for (User user : userList)
            {
                StringBuffer line = new StringBuffer();
                line.append(user.getId());
                line.append(separator);
                line.append(user.getName());
                bw.write(line.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
