package myApp.controller;

import myApp.userAction.UserAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import myApp.DTO.CreateUser;


@Controller
@RequestMapping("/user")
public class UserController {
    private String page;
    public UserAction userAction;

    @Autowired
    public ActionUserController(UserAction userAction) {
        this.userAction = userAction;
    }


    @GetMapping("/create")
    public String showingCreatingUserPage() {
        return "createBT";
    }


    @PostMapping("/create")
    public String creatingUser(CreateUser user) {
        if (userAction.creatingUser(user)) page = "createUser";
        else page = "errorPage";
        return page;
    }


    @GetMapping("/get")
    public String showingGettingUserPage() {
        return "getBT";
    }


    @PostMapping("/get")
    public String gettingUser(@RequestParam(name = "id", required = false) int id, Model model) {
        if (userAction.gettingUser(id, model)) page = "dataUserDB";
        else page = "errorPage";
        return page;
    }

    @GetMapping("/delete")
    public String showingDeletingUserPage() {
        return "deleteBT";
    }

    @PostMapping("/delete")
    public String deletingUser(@RequestParam(value = "id", required = false) int id, Model model) {
        if (userAction.deletingUser(id, model)) page = "deleteUser";
        else page = "errorPage";
        return page;
    }

    @GetMapping("/change-login")
    public String showingUpdatingUserPage() {
        return "updateBT";
    }

    @PostMapping("/change-login")
    public String updatingUser(@RequestParam(value = "id", required = false) int id, @RequestParam(value = "login", required = false) String name) {
        if (userAction.updatingUser(id, name)) page = "updateUser";
        else page = "errorPage";
        return page;
    }

}
