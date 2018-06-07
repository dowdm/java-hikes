

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.Sql2oCommentDao;
import dao.Sql2oHikeDao;
import dao.Sql2oUserDao;
import models.User;
import models.Comment;
import models.Hike;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;


public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");
        String connectionString = "jdbc:h2:~/hikelist.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        Sql2oUserDao userDao = new Sql2oUserDao(sql2o);
        Sql2oCommentDao commentDao = new Sql2oCommentDao(sql2o);
        Sql2oHikeDao hikeDao = new Sql2oHikeDao(sql2o);

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Hike> allHikes = hikeDao.getAll();
            List<User> allUsers = userDao.getAll();
            model.put("hikes", allHikes);
            model.put("users", allUsers);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/hikes/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Hike> hikes = hikeDao.getAll();
            model.put("hikes", hikes);
            return new ModelAndView(model, "hike-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/hikes", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            int length = Integer.parseInt(request.queryParams("length"));
            int elevationGain = Integer.parseInt(request.queryParams("elevationGain"));
            String state = request.queryParams("state");
            String imageUrl = request.queryParams("imageUrl");
            Hike newHike = new Hike(name, length, elevationGain, state, imageUrl);
            hikeDao.add(newHike);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        get("/hikes/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHikeToFind = Integer.parseInt(request.params("id"));
            Hike foundHike = hikeDao.findById(idOfHikeToFind);
            model.put("hike", foundHike);
            List<Comment> allCommentsByHike = hikeDao.getAllCommentsByHike(idOfHikeToFind);
            model.put("comments", allCommentsByHike);
            List<User> allUsers = userDao.getAll();
            model.put("users", allUsers);
            return new ModelAndView(model, "hike-detail.hbs");
        }, new HandlebarsTemplateEngine());

        get("/hikes/:id/edit", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("editHike", true);
            Hike hike = hikeDao.findById(Integer.parseInt(request.params("id")));
            model.put("hike", hike);
            return new ModelAndView(model, "hike-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/hikes/:id/edit", (request, response) -> {
            int idOfHikeToEdit = Integer.parseInt(request.params("id"));
            String name = request.queryParams("name");
            int length = Integer.parseInt(request.queryParams("length"));
            int elevationGain = Integer.parseInt(request.queryParams("elevationGain"));
            String state = request.queryParams("state");
            String imageUrl = request.queryParams("imageUrl");
            hikeDao.update(idOfHikeToEdit, name, length, elevationGain, state, imageUrl);
            response.redirect("/hikes/" + idOfHikeToEdit);
            return null;
        }, new HandlebarsTemplateEngine());

        post("/hikes/:id/comments", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHikeToFind = Integer.parseInt(request.params("id"));
            String content = request.queryParams("content");
            int userId = Integer.parseInt(request.queryParams("userName"));
            Comment userComment = new Comment(userId, content, idOfHikeToFind); // add dropdown of users for authentication
            commentDao.add(userComment);
            List<Comment> comments = hikeDao.getAllCommentsByHike(idOfHikeToFind);
            model.put("comments", comments);
            response.redirect("/hikes/" + idOfHikeToFind);
            return null;
        }, new HandlebarsTemplateEngine());


        get("/users/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<User> users = userDao.getAll();
            model.put("users", users);
            return new ModelAndView(model, "user-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/users", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<User> allUsers = userDao.getAll();
            model.put("users", allUsers);
            String name = request.queryParams("name");
            User newUser = new User(name);
            userDao.add(newUser);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        get("/users/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfUserToFind = Integer.parseInt(request.params("id"));
            User foundUser = userDao.findById(idOfUserToFind);
            model.put("user", foundUser);
            return new ModelAndView(model, "user-detail.hbs");
        }, new HandlebarsTemplateEngine());

        get("users/:id/edit", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            User user = userDao.findById(Integer.parseInt(request.params("id")));
            model.put("user", user);
            model.put("editUser", true);
            return new ModelAndView(model, "user-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/users/:id", (request, response) -> {
            String newName = request.queryParams("name");
            int idOfUserToEdit = Integer.parseInt(request.params("id"));
            userDao.update(idOfUserToEdit, newName);
            response.redirect("/users/" + idOfUserToEdit);
            return null;
        }, new HandlebarsTemplateEngine());


        get("/users/:id/delete", (request, response) -> {
            int idOfUserToDelete = Integer.parseInt(request.params("id"));
            userDao.deleteById(idOfUserToDelete);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());


    }
}

