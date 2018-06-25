package com.giacom.demo.tdc.v1.converter;

import java.util.ArrayList;
import java.util.List;

import com.giacom.demo.tdc.domain.SampleUser;
import com.giacom.demo.tdc.v1.dto.UserDTO;

public class UserConverter {

    public static Iterable<UserDTO> toUserDTO(Iterable<SampleUser> sampleUser) {
        List<UserDTO> userDTOS = new ArrayList<>();
        for (SampleUser user : sampleUser) {
            userDTOS.add(toUserDTO(user));
        }
        return userDTOS;
    }

    public static UserDTO toUserDTO(SampleUser sampleUser) {
        UserDTO userDTO = new UserDTO();
        userDTO.setAge(sampleUser.getAge());
        userDTO.setId(sampleUser.getId());
        userDTO.setLastName(sampleUser.getLastName());
        userDTO.setName(sampleUser.getName());
        return userDTO;
    }

    public static SampleUser toSampleUser(UserDTO userDTO) {
        SampleUser sampleUser = new SampleUser();
        sampleUser.setId(userDTO.getId());
        sampleUser.setAge(userDTO.getAge());
        sampleUser.setLastName(userDTO.getLastName());
        sampleUser.setName(userDTO.getName());
        return sampleUser;
    }


}
