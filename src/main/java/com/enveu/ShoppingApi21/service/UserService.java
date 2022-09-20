package com.enveu.ShoppingApi21.service;

import com.enveu.ShoppingApi21.dto.UserDetailsDTO;
import com.enveu.ShoppingApi21.entity.Customer;
import com.enveu.ShoppingApi21.entity.JwtSession;
import com.enveu.ShoppingApi21.entity.Role;
import com.enveu.ShoppingApi21.repository.CustomerRepository;
import com.enveu.ShoppingApi21.repository.RoleRepository;
import com.enveu.ShoppingApi21.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    SessionRepository sessionRepository;

//    public String login(String email, String password) {
//        //check in id if these credential exists
//        return "saurabh@gmail.com";
//    }


//    public Customer save(Customer user) {
//        Customer newUser = new Customer();
//        newUser.setFirstName(user.getFirstName());
//        newUser.setLastName(user.getLastName());
//        newUser.setEmail(user.getEmail());
//        newUser.setPhoneNo(user.getPhoneNo());
//        newUser.setPassword(user.getPassword());
//        newUser.setAddress(user.getAddress());
//        newUser.setPostCode(user.getPostCode());
//        newUser.setCity(user.getCity());
//        return customerRepository.save(newUser);
//    }

    public Customer find(String s) {
        return customerRepository.findByEmail(s);
    }

    public String loginCheck(String email, String password) {
        Customer s = customerRepository.findByEmail(email);
        if (email.equals(s.getEmail()) && password.equals(s.getPassword())) {
            return s.getEmail();
        } else {
            return "Id not found";
        }
    }

    public Customer addCst(Customer customer) {
//        employee.setCommunityList(communityRepo.saveAll(employee.getCommunityList()));
       customer.setRole(roleRepository.save(customer.getRole()));
        return customerRepository.save(customer);
    }


    public List<Customer> listCst(String email)
    {
//       Role role1=roleRepository.findById().get();

        return customerRepository.findAll();
    }

    public Customer updateCs(Customer customer) {
        Customer customer1 = customerRepository.findById(customer.getId()).get();
        customer1.setFirstName(checkNull(customer1.getFirstName(), customer.getFirstName()));
        customer1.setLastName(checkNull(customer1.getLastName(),customer.getLastName()));
        customer1.setEmail(checkNull(customer1.getEmail(),customer.getEmail()));
        customer1.setPhoneNo(checkNull(customer1.getPhoneNo(),customer.getPhoneNo()));
//        customer1.setPassword(checkNull(customer1.getPassword(),customer.getPassword()));
        customer1.setAddress(checkNull(customer1.getAddress(),customer.getAddress()));
        customer1.setPostCode(checkNull(customer1.getPostCode(),customer.getPostCode()));
        customer1.setCity(checkNull(customer1.getCity(),customer.getPostCode()));
        return customerRepository.save(customer1);
    }

    private String checkNull(String customer1,String customer)
    {
        if(customer==null)
            return customer1;
        return customer;
    }



//
//    public Customer updatePassword(Customer customer) {
//        Customer customer1 = customerRepository.findById(customer.getId()).get();
//       customer1.setPassword(customer.getPassword());
//        return customerRepository.save(customer1);
//    }

//    public String changePasswordMethod(String email, String newPassword, String oldPassword) throws Exception {
//        List<JwtSession> deleteFiles = sessionRepository.findAllByEmail(email);
//        //delete all token having same email
//        if (deleteFiles == null) {
//            throw new Exception("Email is not found");
//        }
//        sessionRepository.deleteAll(deleteFiles);
//        JwtSession saveToken = new JwtSession();
//        saveToken.setToken(email);
//        sessionRepository.save(saveToken);
//    }
//        Customer s= customerRepository.findByEmail(email);
//        if (oldPassword.equals(s.getPassword())){
//            s.setPassword(newPassword);
//            customerRepository.save(s);
//            return s.getEmail();
//        }
//        return null;




    public UserDetailsDTO profileView(String email)
    {
        Customer customer1=customerRepository.findByEmail(email);
        UserDetailsDTO userDetailsDTO=new UserDetailsDTO();
        userDetailsDTO.setFirstName(customer1.getFirstName());
        userDetailsDTO.setLastName(customer1.getLastName());
        userDetailsDTO.setEmail(customer1.getEmail());
        userDetailsDTO.setPhoneNo(customer1.getPhoneNo());
        userDetailsDTO.setAddress(customer1.getAddress());
        userDetailsDTO.setPostCode(customer1.getPostCode());
        userDetailsDTO.setCity(customer1.getCity());
        return userDetailsDTO;

    }

    public String changePassword(String email, String newPassword, String oldPassword) {
        Customer s=customerRepository.findByEmail(email);
        if(oldPassword.equals(s.getPassword()))
        {
            s.setPassword(newPassword);
            customerRepository.save(s);
            return s.getEmail();
        }
        return null;
    }


//
//   public String update(Customer customer){
//        Customer oldCustomer = customerRepository.findByEmail(customer.getEmail());
//        customer.setPassword(oldCustomer.getPassword());
//       System.out.println(oldCustomer.getPassword());
//        return "Password updated";
//   }


}
