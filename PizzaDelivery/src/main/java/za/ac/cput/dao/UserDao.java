//package za.ac.cput.dao;

//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Repository;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//@Repository
//public class UserDao {
//    private final static List<UserDetails> APPLICATION_USERS = Arrays.asList(
//            new User(
//                    "bouali.social@gmail.com",
//                    "password",
//                    Collections.singleton(new SimpleGrantedAuthority("ROLE ADMIN"))
//            ),
//            new User(
//                    "USER@gmail.com",
//                    "password",
//                    Collections.singleton(new SimpleGrantedAuthority("ROLE USER"))
//            ),
//            new User(
//                    "ahzar@gmail.com",
//                            "12345678",
//                    Collections.singleton(new SimpleGrantedAuthority("ROLE USER"))
//            )
//    );
//
//    public UserDetails findUserByEmail(String email){
//       return APPLICATION_USERS
//                .stream()
//                //.filter(u -> u.getUsername().equals(email))
//                .filter(userDetails -> userDetails.getUsername().equals(email))
//                .findFirst()
//                .orElseThrow(() -> new UsernameNotFoundException("user not found"))
//        ;
//    }
//}
