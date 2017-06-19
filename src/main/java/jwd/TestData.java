package jwd;

import javax.annotation.PostConstruct;

import jwd.model.Author;
import jwd.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Calendar;
import jwd.model.Ad;
import jwd.model.Category;

@Component
public class TestData {

  @Autowired
  private UserService userService;

  @Autowired
  private AddressService addressService;

  @Autowired
  CategoryService categoryService;

  @Autowired
  AdService adService;

  @Autowired
  AuthorService authorService;

  @PostConstruct
  public void init(){

    for(int i=0; i<6; i++){
      Category category = new Category();
      category.setName("cat name "+i);
      category.setDescription("description "+i);
      categoryService.save(category);

      Author author = new Author();
      author.setName("author name "+i);
      author.setEmail("author email "+i);
      author.setPhone("author phone "+i);
      authorService.save(author);

      for (int j = -1; j <= 4; j++) {
        Ad ad = new Ad();
        ad.setName(j + " ad name");
        ad.setText("ad text "+j);
        ad.setCategory(category);
        ad.setAuthor(author);

        Date today = new Date(Calendar.getInstance().getTime().getTime());
        ad.setPostedDate(today);
          ad.setExpiryDate(new Date(today.getTime() + j*(1000 * 60 * 60 * 24)));

        adService.save(ad);
      }


    }




    //    for (int i = 1; i <= 7; i++) {
//      User user = new User();
//      user.setFirstName("First name " + i);
//      user.setLastName("Last name " + i);
//      user.setEmail("email" + i + "@example.com");
//      user.setPassword("123");
//      userService.save(user);
//
//      for (int j = 1; j <= 3; j++) {
//        Address address = new Address();
//        address.setNumber(j + "c/7");
//        address.setStreat("Narodnog fronta");
//
//        address.setUser(user);
//        user.addAddress(address);
//        addressService.save(address);
//      }
//    }
  }
}
