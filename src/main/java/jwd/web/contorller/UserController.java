package jwd.web.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import jwd.model.User;
import jwd.service.UserService;
import jwd.support.UserDTOToUser;
import jwd.support.UserToUserDTO;
import jwd.web.dto.UserDTO;
import jwd.web.dto.UserRegistrationDTO;

/**
 * Created by Dusan on 5/24/2017.
 */
@Controller
@RequestMapping(value = "/users")
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private UserDTOToUser toUser;

  @Autowired
  private UserToUserDTO toDto;


  @RequestMapping(method=RequestMethod.GET)
  ResponseEntity<List<UserDTO>> getUser(@RequestParam (defaultValue = "ASC")String smer){
    Page<User> users = userService.findAll(smer);

    if(users == null || users.getSize()==0){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    List<User> userList = users.getContent();

    return new ResponseEntity<>(toDto.convert(userList), HttpStatus.OK);
  }


  @RequestMapping(value="/{id}", method=RequestMethod.GET)
  ResponseEntity<UserDTO> getUser(@PathVariable Long id)
//                                  @RequestParam (value = "firstName")String firstName,
//                                  @RequestParam (value = "lastName")String lastName,
//                                  @RequestParam (value = "email")String email)
  {
//    User user = null;
//    if (firstName!=null){
//      user = userService.findByFirstName(firstName);
//    }else if (lastName!=null){
//      user = userService.findByLastName(lastName);
//    }else if (email!=null){
//      user = userService.findByEmail(email);
//    }

    User user = userService.findOne(id);
    if(user==null){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(
        toDto.convert(user),
        HttpStatus.OK);
  }

  @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
  ResponseEntity<User> delete(@PathVariable Long id){
    userService.delete(id);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @RequestMapping(method=RequestMethod.POST,
      consumes="application/json")
  public ResponseEntity<UserDTO> add(@RequestBody UserRegistrationDTO newUser){
    if(newUser.getPassword()==null
        || newUser.getPassword().isEmpty()
        || !newUser.getPassword().equals(newUser.getPasswordConfirm())){
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    User user = new User();
    user.setEmail(newUser.getEmail());
    user.setPassword(newUser.getPassword());
    user.setFirstName(newUser.getFirstName());
    user.setLastName(newUser.getLastName());

    User savedUser = userService.save(user);

    return new ResponseEntity<>(
        toDto.convert(savedUser),
        HttpStatus.CREATED);
  }


  @RequestMapping(method=RequestMethod.PUT,
      value="/{id}",
      consumes="application/json")
  public ResponseEntity<UserDTO> edit(
      @RequestBody UserDTO user,
      @PathVariable Long id){

    if(id!=user.getId()){
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    User persisted = userService.save(toUser.convert(user));

    return new ResponseEntity<>(
        toDto.convert(persisted),
        HttpStatus.OK);
  }


}
