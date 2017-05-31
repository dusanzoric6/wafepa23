package jwd.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import jwd.model.User;
import jwd.web.dto.UserDTO;

/**
 * Created by Dusan on 5/24/2017.
 */
@Component
public class UserToUserDTO implements Converter<User, UserDTO>{

  @Override
  public UserDTO convert(User user) {
    UserDTO dto = new UserDTO();

    dto.setId(user.getId());
    dto.setFirstName(user.getFirstName());
    dto.setLastName(user.getLastName());
    dto.setEmail(user.getEmail());

    return dto;
  }

  public List<UserDTO> convert(List<User> users){
    List<UserDTO> ret = new ArrayList<>();

    for(User user : users){
      ret.add(convert(user));
    }

    return ret;
  }
}
