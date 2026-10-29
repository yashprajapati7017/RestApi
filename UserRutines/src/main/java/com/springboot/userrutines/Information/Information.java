package com.springboot.userrutines.Information;

import com.springboot.userrutines.UserEntity.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Information {

    UserDetails userDetails =new UserDetails();

    static List<UserDetails> list = new ArrayList<>();

    static{
         list.add(new UserDetails(9, "java", false));
        list.add(new UserDetails(11,"test",false));
        list.add(new UserDetails(12,"checkAllQuestion",false));
        list.add(new UserDetails(13,"rest",false));
        list.add(new UserDetails(14,"lunch",false));
        list.add(new UserDetails(15,"java pratice",false));
        list.add(new UserDetails(18,"play",false));
    }

    public List<UserDetails> getUserDetails() {
        return list;
    }

    public UserDetails getUserDetailsById(int userTime) {
        userDetails =null;
        userDetails=list.stream().filter(e->e.getTime()==userTime).findFirst().get();
        return userDetails;
    }

    public UserDetails postUserDetails(UserDetails userDetails) {
        list.add(userDetails);
        return userDetails;
    }

    public void setUserDetails(int id){
        list=list.stream().filter(e->e.getTime()!=id).collect(Collectors.toList());
    }

    public void updateUserDetails(UserDetails userDetails, int id) {
        list.stream().map(e->{
            if(e.getTime()==id){
                e.setWork(userDetails.getWork());
                e.setWorkSuccesfull(userDetails.isWorkSuccesfull());
                return e;
            }
            else{
                return null;
            }
        }).collect(Collectors.toList());
    }

}
