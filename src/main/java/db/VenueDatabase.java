/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author kelvinleung
 */
public class VenueDatabase extends BaseDatabase {

    public VenueDatabase(String url, String username, String password) {
        super(url, username, password);
    }

    public void init_tables() {
        String sql
                = "CREATE TABLE `account` (\n"
                + "  `account_id` int(10) unsigned NOT NULL AUTO_INCREMENT,\n"
                + "  `name` text NOT NULL,\n"
                + "  `permission_level` tinyint(3) unsigned NOT NULL,\n"
                + "  PRIMARY KEY (`account_id`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;\n"
                + "CREATE TABLE `account_guest` (\n"
                + "  `account_id` int(10) unsigned NOT NULL,\n"
                + "  `guest_id` int(10) unsigned NOT NULL,\n"
                + "  KEY `account_id` (`account_id`),\n"
                + "  KEY `guest_id` (`guest_id`),\n"
                + "  CONSTRAINT `account_guest_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`),\n"
                + "  CONSTRAINT `account_guest_ibfk_2` FOREIGN KEY (`guest_id`) REFERENCES `guest` (`guest_id`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;\n"
                + "CREATE TABLE `booking` (\n"
                + "  `booking_id` int(10) unsigned NOT NULL AUTO_INCREMENT,\n"
                + "  `account_id` int(10) unsigned NOT NULL,\n"
                + "  `booking_datetime` timestamp NOT NULL DEFAULT current_timestamp(),\n"
                + "  `recipt` mediumblob DEFAULT NULL,\n"
                + "  `is_approved` tinyint(1) NOT NULL DEFAULT 0,\n"
                + "  PRIMARY KEY (`booking_id`),\n"
                + "  KEY `account_id` (`account_id`),\n"
                + "  CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;\n"
                + "CREATE TABLE `booking_guest` (\n"
                + "  `booking_id` int(10) unsigned NOT NULL,\n"
                + "  `guest_id` int(10) unsigned NOT NULL,\n"
                + "  KEY `booking_id` (`booking_id`),\n"
                + "  KEY `guest_id` (`guest_id`),\n"
                + "  CONSTRAINT `booking_guest_ibfk_1` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`booking_id`),\n"
                + "  CONSTRAINT `booking_guest_ibfk_2` FOREIGN KEY (`guest_id`) REFERENCES `guest` (`guest_id`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;\n"
                + "CREATE TABLE `booking_venue` (\n"
                + "  `booking_id` int(10) unsigned NOT NULL,\n"
                + "  `venue_id` int(10) unsigned NOT NULL,\n"
                + "  `start_session` timestamp NOT NULL,\n"
                + "  `end_session` timestamp NOT NULL,\n"
                + "  KEY `booking_id` (`booking_id`),\n"
                + "  KEY `venue_id` (`venue_id`),\n"
                + "  CONSTRAINT `booking_venue_ibfk_1` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`booking_id`),\n"
                + "  CONSTRAINT `booking_venue_ibfk_2` FOREIGN KEY (`venue_id`) REFERENCES `venue` (`venue_id`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;\n"
                + "CREATE TABLE `guest` (\n"
                + "  `guest_id` int(10) unsigned NOT NULL AUTO_INCREMENT,\n"
                + "  `name` text NOT NULL,\n"
                + "  `email` text NOT NULL,\n"
                + "  PRIMARY KEY (`guest_id`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;\n"
                + "CREATE TABLE `notification` (\n"
                + "  `notification_id` int(10) unsigned NOT NULL AUTO_INCREMENT,\n"
                + "  `account_id` int(10) unsigned NOT NULL,\n"
                + "  `message` text NOT NULL,\n"
                + "  `is_read` tinyint(1) NOT NULL DEFAULT 0,\n"
                + "  `receive_timedate` timestamp NOT NULL DEFAULT current_timestamp(),\n"
                + "  PRIMARY KEY (`notification_id`),\n"
                + "  KEY `account_id` (`account_id`),\n"
                + "  CONSTRAINT `notification_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;\n"
                + "CREATE TABLE `venue` (\n"
                + "  `venue_id` int(10) unsigned NOT NULL AUTO_INCREMENT,\n"
                + "  `image_path` text NOT NULL,\n"
                + "  `name` text NOT NULL,\n"
                + "  `type` text NOT NULL,\n"
                + "  `capacity` text NOT NULL,\n"
                + "  `location` text NOT NULL,\n"
                + "  `description` text NOT NULL,\n"
                + "  `booking_fee` float NOT NULL,\n"
                + "  `person_in_charge` int(10) unsigned NOT NULL,\n"
                + "  PRIMARY KEY (`venue_id`),\n"
                + "  KEY `person_in_charge` (`person_in_charge`),\n"
                + "  CONSTRAINT `venue_ibfk_1` FOREIGN KEY (`person_in_charge`) REFERENCES `account` (`account_id`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;";

        try (Connection conn = getConnection(); Statement stmnt = conn.createStatement();) {
            stmnt.execute(sql);
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
