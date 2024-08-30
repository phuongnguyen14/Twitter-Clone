package org.example.twitterback.dto.mapper;

import org.example.twitterback.dto.UserDto;
import org.example.twitterback.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDtoMapper {

    public static UserDto toUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setFullName(user.getFullName());
        userDto.setImage(user.getImage());
        userDto.setBackgroundImage(user.getBackgroundImage());
        userDto.setBio(user.getBio());
        userDto.setBirthDate(user.getBirthDate());
        userDto.setFollowers(toUserDtos(user.getFollowers()));
        userDto.setFollowing(toUserDtos(user.getFollowing()));
        userDto.setLogin_google(user.isLogin_google());
        userDto.setLocation(user.getLocation());
//            userDto.setVerified(false);


        return userDto;
    }

    private static List<UserDto> toUserDtos(List<User> followers) {
        List<UserDto> userDtos= new ArrayList<>();
        for(User user: followers){
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setEmail(user.getEmail());
            userDto.setFullName(user.getFullName());
            userDto.setImage(user.getImage());
            userDtos.add(userDto);

        }

        return userDtos;
    }

}
