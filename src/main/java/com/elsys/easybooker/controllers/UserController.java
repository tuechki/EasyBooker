package com.elsys.easybooker.controllers;

import com.elsys.easybooker.models.UserTry;
import com.elsys.easybooker.models.User;
import com.elsys.easybooker.models.UserDao;
import com.elsys.easybooker.models.UserTry;
import com.elsys.easybooker.models.UserTryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to test interactions with the MySQL database using the UserDao class.
 *
 * @author netgloo
 */
@Controller
public class UserController {

    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List<UserTry> getAllUsers() {
        List<UserTry> users = null;
        try {
            users = (List) userTryDao.findAll();

        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return users;
    }




    /**
     * /create  --> Create a new user and save it in the database.
     *
     */

    @RequestMapping(value="/create", method=RequestMethod.POST)
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody UserTry request) {

        try {

            System.out.print(request.getUsername());
            System.out.print(request.getPassword());

            userTryDao.save(new UserTry(request.getUsername(), request.getPassword()));

        }
        catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


//        User user = null;
//        try {
//            user.setFirstName("Daniel");
//            user.setLastName("Tuechki");
//            user.setUsername(request.getUsername());
//            user.setPassword(request.getPassword());
//            user.setEmail("dtuechki@gmail.com");
//            user.setNumber("0867128736");
//            user.setGender("Male");
//            userDao.save(user);
//        }
//        catch (Exception ex) {
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//       }
//            return new ResponseEntity<>(null, HttpStatus.OK);
//    }

//    @RequestMapping(value = "/create", method = RequestMethod.POST
//            //consumes = MimeTypeUtils.APPLICATION_JSON_VALUE
//            )
//    @ResponseStatus(value = HttpStatus.OK)
//    @ResponseBody
//    public String create(String firstName, String lastName, String username, String password,
//                String email, String number, String gender) {
//        User user = null;
//        try {
//            user = new User(firstName, lastName, username, password, email, number, gender);
//            userDao.save(user);
//        }
//        catch (Exception ex) {
//            return "Error creating the user: " + ex.toString();
//        }
//        return "User succesfully created! (id = " + user.getId() + ")";
//    }

    /**
     * /delete  --> Delete the user having the passed id.
     *
     * @param id The id of the user to delete
     * @return A string describing if the user is successfully deleted or not.
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(long id) {
        try {
            User user = new User(id);
            userDao.delete(user);
        }
        catch (Exception ex) {
            return "Error deleting the user: " + ex.toString();
        }
        return "User successfully deleted!";
    }

    /**
     * /get-by-email  --> Return the id for the user having the passed email.
     *
     * @param email The email to search in the database.
     * @return The user id or a message error if the user is not found.
     */
    @RequestMapping("/get-by-email")
    @ResponseBody
    public String getByEmail(String email) {
        String userId;
        try {
            User user = userDao.findByEmail(email);
            userId = String.valueOf(user.getId());
        }
        catch (Exception ex) {
            return "User not found";
        }
        return "The user id is: " + userId;
    }

    /**
     * /update  --> Update the email and the name for the user in the database
     * having the passed id.
     *
     * @param id The id for the user to update.
     * @param email The new email.
     * @param name The new name.
     * @return A string describing if the user is successfully updated or not.
     */
    @RequestMapping("/update")
    @ResponseBody
    public String updateUser(long id, String email, String name) {
        try {
            User user = userDao.findOne(id);
            user.setEmail(email);
            userDao.save(user);
        }
        catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User successfully updated!";
    }

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserTryDao userTryDao;

} // class UserController
