package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {
    @DataProvider
    public Iterator<Object[]> loginData(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"tirex@gmail.com","Rr12345$"});
        list.add(new Object[]{"noa@gmail.com","Nnoa12345$"});
        return  list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> example(){
        List<Object[]> list = new ArrayList<>();
        //fill collection
        return  list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> loginModels(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().setEmail("tirex@gmail.com").setPassword("Rr12345$")});
        list.add(new Object[]{new User().setEmail("noa@gmail.com").setPassword("Nnoa12345$")});

        return  list.iterator();
    }
}
