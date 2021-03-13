package com.google.sps.servlets;

import java.util.ArrayList;
import com.google.gson.Gson;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/random-album")
public class MusicalListServlet extends HttpServlet {

    ArrayList<String> faveMusicals;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        faveMusicals = getFaveMusicals();
        Gson gson = new Gson();
        String musicalsJSON = gson.toJson(faveMusicals);

        response.setContentType("application/json;");
        response.getWriter().println(musicalsJSON);
    }

    public ArrayList<String> getFaveMusicals() {
        ArrayList<String> faveMusicals = new ArrayList<String>();
        faveMusicals.add("The Book of Mormon");
        faveMusicals.add("Hamilton");
        faveMusicals.add("Hadestown");
        faveMusicals.add("In the Heights");
        faveMusicals.add("Phantom of the Opera");
        return faveMusicals;
    }

}
