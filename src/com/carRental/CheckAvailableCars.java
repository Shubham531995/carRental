package com.carRental;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/avaialable"})
public class CheckAvailableCars extends HttpServlet {
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException {
        doPost(httpServletRequest, httpServletResponse);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        response.setContentType("application/json");
        ConnectionPool connectionPool = new ConnectionPool();
        Connection connection = null;
        try {
            connection = connectionPool.getCon();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String location = request.getParameter(Constants.LOCATION);
        String startDate = request.getParameter(Constants.DATE);
        System.out.println("location: "+location+" date: "+startDate);
        String query = "select a.carid, a.carname, a.location, (case when b.datetime = ? then 1 else 0 END) as status from cardetails a left join bookingdetails b on a.carid = b.carid and location = ?";
        PreparedStatement pstmt = null;
        ResultSet res = null;
        try {
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, startDate);
            pstmt.setString(2,location);
            System.out.println(pstmt.toString());
            res = pstmt.executeQuery();
            List<String> list = new ArrayList<>();
            List<List<String>> resList = new ArrayList<>();
            JSONObject json = new JSONObject();
            JSONArray array = new JSONArray();
            while(res.next()) {
                JSONObject object = new JSONObject();
                object.put("CARID", res.getString("CARID"));
                object.put("CARNAME", res.getString("CARNAME"));
                object.put("LOCATION", res.getString("LOCATION"));
                object.put("STATUS", String.valueOf(res.getInt("STATUS")));
                array.put(object);
            }
            json.put("CARS", array);
            PrintWriter printWriter = response.getWriter();
            printWriter.write(json.toString());
        } catch (SQLException | IOException | JSONException e) {
            e.printStackTrace();
        }

    }
}