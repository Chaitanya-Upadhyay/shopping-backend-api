package com.enveu.ShoppingApi21.service;

import com.enveu.ShoppingApi21.entity.JwtSession;
import com.enveu.ShoppingApi21.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JwtSessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public void tokenSave(String email,String token) throws Exception{
        JwtSession check = sessionRepository.findByEmail(email);
        JwtSession uncheck= new JwtSession();
        String checkEmailId="";
        try {
            checkEmailId=check.getEmail();
        } catch (Exception e){
            System.out.println(e);
            checkEmailId="empty";
        }

        if (email.equals(checkEmailId)) {
            check.setToken(token);
            sessionRepository.save(check);
        }
        else {
            uncheck.setEmail(email);
            uncheck.setToken(token);
            sessionRepository.save(uncheck);
        }
    }


    public String checkToken(String email, String token){
        List<JwtSession> check=sessionRepository.findAllByEmail(email);
        check=(ArrayList<JwtSession>) check.stream().filter(findToken -> findToken.getToken().equals(token)).collect(Collectors.toList());
        JwtSession check1 = sessionRepository.findByEmail(email);
       if (check!=null)
       {
           return "valid";
       }
        return null;
    }

    public void changePasswordMethod(String email, String newPassword, String oldPassword) throws Exception {
        List<JwtSession> deleteFiles = sessionRepository.findAllByEmail(email);
        //delete all token having same email
        if (deleteFiles == null) {
            throw new Exception("Email is not found");
        }
        sessionRepository.deleteAll(deleteFiles);
        JwtSession saveToken = new JwtSession();
        saveToken.setToken(email);
        sessionRepository.save(saveToken);
    }
}
