package manager;

import models.Contact;
import org.testng.annotations.DataProvider;

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
}
