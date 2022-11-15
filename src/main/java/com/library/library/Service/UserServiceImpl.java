package com.library.library.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.library.Model.PreviousId;
import com.library.library.Model.User;
import com.library.library.Repository.PreviousIdRepository;
import com.library.library.Repository.UserRepository;

@Component
public class UserServiceImpl implements UserServiceInterface{
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PreviousIdRepository  previousIdRepository;

    @Override
        public List<User> viewUsers(){
            return userRepository.findAll();
        }

    @Override
    public User signUp(User userDetails){
        User user = userRepository.findByEmail(userDetails.getEmail());

        if(user != null){
            return null;
        }
        
        PreviousId previousId = previousIdRepository.findByType("user");

        Integer previousUserId = previousId.getPreviousId();

        if(previousUserId<9){
            userDetails.setId("UN00" + ++previousUserId);
        }
        else{
            userDetails.setId("UN0" + ++previousUserId);
        }
       
        previousId.setPreviousId(previousUserId);
        previousIdRepository.save(previousId);
        return userRepository.save(userDetails);

        }
        @Override
        public User logIn(User userDetails){
            User user = userRepository.findByEmailAndPassword(userDetails.getEmail(), userDetails.getPassword());
            if(user == null){
                return null;
            }
            return user;
        }

        @Override
        public User singleUser(String UserId){
            Optional<User> optionalUser = userRepository.findById(UserId);

            if(!optionalUser.isPresent()){
                return null;
            }
            return optionalUser.get();
        }
    }

