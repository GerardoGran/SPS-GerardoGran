package com.google.sps.servlets;

import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/random-album")
public class MusicalListServlet extends HttpServlet {

    ArrayList<String> faveMusicals = new ArrayList<>(Arrays.asList("The Book of Mormon", "Hamilton", "Hadestown","In the Heights", "Phantom of the Opera"));

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson gson = new Gson();
        String musicalsJSON = gson.toJson(faveMusicals);

        response.setContentType("application/json;");
        response.getWriter().println(musicalsJSON);
    }
}