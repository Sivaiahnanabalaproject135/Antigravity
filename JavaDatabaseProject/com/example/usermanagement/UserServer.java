package com.example.usermanagement;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;

public class UserServer {
    private static UserDAO userDAO = new UserDAO();
    private static Gson gson = new Gson();

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/users", new UserHandler());
        server.setExecutor(null); // creates a default executor
        System.out.println("Backend Server started at http://localhost:8080/users");
        server.start();
    }

    static class UserHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String method = exchange.getRequestMethod();
            String response = "";
            int statusCode = 200;

            try {
                switch (method) {
                    case "GET":
                        List<User> users = userDAO.selectAllUsers();
                        response = gson.toJson(users);
                        break;
                    case "POST":
                        InputStream is = exchange.getRequestBody();
                        User userToAdd = gson.fromJson(new String(is.readAllBytes()), User.class);
                        userDAO.insertUser(userToAdd);
                        response = "User added successfully";
                        statusCode = 201;
                        break;
                    default:
                        response = "Method not allowed";
                        statusCode = 405;
                }
            } catch (Exception e) {
                e.printStackTrace();
                response = "Internal Server Error: " + e.getMessage();
                statusCode = 500;
            }

            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(statusCode, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
