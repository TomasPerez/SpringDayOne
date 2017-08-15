package com.guenther.spring2.util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.*;
import java.util.ArrayList;

@Controller
public class HomeController {

    @RequestMapping("/")
    public ModelAndView helloWorld() {
        ModelAndView mv = new
                ModelAndView("welcome");
        mv.addObject("message", "Hello there what would like today?!");
        mv.addObject("title", "Welcome to the GC cafe!");
        return mv;
    }

    @RequestMapping("/userform")
    public ModelAndView userform() {
        return new ModelAndView("form", "inst",
                "Please enter info: ");
    }

    @RequestMapping("/formhandler")
    public ModelAndView formhandler(@RequestParam("name") String name,
                                    @RequestParam("email") String email,
                                    @RequestParam("address") String address,
                                    @RequestParam("city") String city,
                                    @RequestParam("state") String state,
                                    @RequestParam("gender") String gender
    ) {
        ModelAndView mv = new ModelAndView("formresponse");
        mv.addObject("name", name);
        mv.addObject("email", email);
        mv.addObject("address", address);
        mv.addObject("city", city);
        mv.addObject("state", state);
        mv.addObject("gender", gender);
        return mv;
    }

    @RequestMapping(value = "getAllCustomers")
    public ModelAndView getAllCustomers() throws SQLException, ClassNotFoundException {
        // define the data for the connection
        String dbAddress = "jdbc:mysql://localhost:3306/CoffeeShopDB";
        String username = "root";
        String password = "my2angels";

        try {
            Class.forName("com.mysql.jdbc.Driver");

                    Connection mysqlConnection = DriverManager.getConnection(dbAddress, username, password);

            String readCustomersCommand = "select name, description,quantity, price from items";
            Statement readCustomers = mysqlConnection.createStatement();
            ResultSet results = readCustomers.executeQuery(readCustomersCommand);

            ArrayList<Items> inventory = new ArrayList<Items>();
            //map from ResultSet to the ArrayList
            while (results.next()) {
                Items temp = new Items(results.getString(1),
                        results.getString(2), results.getInt(3),
                        results.getFloat(4));
                inventory.add(temp);

            }
            return new ModelAndView("welcome", "cList", inventory);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;

    }
}