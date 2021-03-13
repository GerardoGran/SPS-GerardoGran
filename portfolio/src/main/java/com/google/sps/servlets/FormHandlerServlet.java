package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import java.security.KeyFactorySpi;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Get the value entered in the form.
    String messageText = request.getParameter("text-input");
    long timestamp = System.currentTimeMillis();

    //Declare datatore-related objects and store message.
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Message");
    FullEntity messageEntity =
      Entity.newBuilder(keyFactory.newKey())
        .set("messageText", messageText)
        .set("timestamp", timestamp)
        .build();
    datastore.put(taskEntity);
    
    response.sendRedirect("/index.html");

    // Write the value to the response so the user can see it.
    response.getWriter().println("You submitted: " + textValue);
  }
}