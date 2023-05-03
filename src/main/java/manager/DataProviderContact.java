package manager;

import models.Contact;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContact {

    @DataProvider
    public Iterator<Object[]> contactSuccess(){
        List<Object[]> list = new ArrayList<>();
        //fill collection
        list.add(new Object[]{Contact.builder()
                .name("Ron")
                .lastName("Zak")
                .phone("65894757421")
                .email("ron@gmail.com")
                .address("TA")
                .description("all fields")
                .build()});
        list.add(new Object[]{Contact.builder()
                .name("RonReq")
                .lastName("Zak")
                .phone("87456982479")
                .email("ron@gmail.com")
                .address("TA")
                .description("description")
                .build()});
        return  list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> contactWrongPhone(){
        List<Object[]> list = new ArrayList<>();
        //fill collection
        list.add(new Object[]{Contact.builder()
                .name("John")
                .lastName("Wick")
                .email("john@hmail.com")
                .address("NY")
                .phone("41523")
                .description("Friend").build()});
        list.add(new Object[]{Contact.builder()
                .name("John")
                .lastName("Wick")
                .email("john@hmail.com")
                .address("NY")
                .phone("4152358994125478993221")
                .description("Friend").build()});
        list.add(new Object[]{Contact.builder()
                .name("John")
                .lastName("Wick")
                .email("john@hmail.com")
                .address("NY")
                .phone("fghyefdvnjki")
                .description("Friend").build()});
        list.add(new Object[]{Contact.builder()
                .name("John")
                .lastName("Wick")
                .email("john@hmail.com")
                .address("NY")
                .phone("")
                .description("Friend").build()});

        return  list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> contactCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\QA_Automation\\QA37_Phonebook\\src\\test\\resources\\contact.csv")));
        String line = reader.readLine();
        while (line != null){
            String[] all = line.split(",");
            list.add(new Object[]{Contact.builder()
                    .name(all[0])
                    .lastName(all[1])
                    .email(all[2])
                    .phone(all[3])
                    .address(all[4])
                    .description(all[5])
                    .build()});
            line = reader.readLine();
        }

        return list.iterator();
    }
}
