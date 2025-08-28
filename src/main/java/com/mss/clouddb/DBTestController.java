package com.mss.clouddb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;

@RestController
public class DBTestController {
    @Autowired
    private DataSource dataSource;


    @GetMapping("/test")
    public String getConnection(){

        try (Connection conn = dataSource.getConnection()) {
            return "✅ DB Connected: " + conn.getMetaData().getURL();
        } catch (Exception e) {
            return "❌ DB Connection Failed: " + e.getMessage();
        }
    }
}
