package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {
    @DataProvider
    public Iterator<Object[]> loginData() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"tirex@gmail.com", "Rr12345$"});
        list.add(new Object[]{"noa@gmail.com", "Nnoa12345$"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        //read from file --> add to list
        BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\QA_Automation\\QA37_Phonebook\\data.csv")));
        String line = reader.readLine();//"noa@gmail.com,Nnoa12345$"
        while (line != null) {
            String[] all = line.split(",");//[noa@gmail.com],[Nnoa12345$]
            list.add(new Object[]{new User().setEmail(all[0]).setPassword(all[1])});
            line=reader.readLine();//"sonya@gmail.com,Ss12345$"   //tirex@gmail.com,Rr12345$   //null

        }

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginModels() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().setEmail("tirex@gmail.com").setPassword("Rr12345$")});
        list.add(new Object[]{new User().setEmail("noa@gmail.com").setPassword("Nnoa12345$")});

        return list.iterator();
    }
}
