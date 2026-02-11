package com.example.usermanagement;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        System.out.println("Starting Application...");

        try {
            // 1. Add a new user
            System.out.println("\n--- Adding new user ---");
            User newUser = new User("Alice Smith", "alice.smith@example.com");
            userDAO.insertUser(newUser);
            System.out.println("User added successfully.");

            // 2. Retrieve and print all users
            System.out.println("\n--- All Users ---");
            List<User> allUsers = userDAO.selectAllUsers();
            allUsers.forEach(System.out::println);

            // Get the ID of the last added user (assuming it's the last one for demo
            // purposes)
            // Ideally, the insert method should return the generated ID, but for simplicity
            // we'll just pick from list
            if (!allUsers.isEmpty()) {
                User lastUser = allUsers.get(allUsers.size() - 1);
                int userId = lastUser.getId();

                // 3. Update user's name by ID
                System.out.println("\n--- Updating user with ID: " + userId + " ---");
                lastUser.setName("Alice Cooper");
                userDAO.updateUser(lastUser);

                // Verify update
                User updatedUser = userDAO.selectUser(userId);
                System.out.println("Updated User: " + updatedUser);

                // 4. Delete user by ID
                System.out.println("\n--- Deleting user with ID: " + userId + " ---");
                userDAO.deleteUser(userId);
                System.out.println("User deleted.");
            }

            // Final check
            System.out.println("\n--- Final User List ---");
            userDAO.selectAllUsers().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
