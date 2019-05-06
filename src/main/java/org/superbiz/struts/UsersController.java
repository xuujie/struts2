package org.superbiz.struts;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsersController {


    private final UserRepository userRepository;

    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/addUser")
    public String addUserForm() {
        return "addUserForm";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam("id") Long id,
                          @RequestParam("firstName") String firstName,
                          @RequestParam("lastName") String lastName, Model model) {
        if (id == null) {
            model.addAttribute("errorMessage", "id must be provided");
            return "addUserForm";
        }
        if (StringUtils.isEmpty(firstName)) {
            model.addAttribute("errorMessage", "first name must be provided");
            return "addUserForm";
        }
        if (StringUtils.isEmpty(lastName)) {
            model.addAttribute("errorMessage", "last name must be provided");
            return "addUserForm";
        }
        userRepository.save(new User(id, firstName, lastName));
        return "addedUser";
    }

    @GetMapping("/findUser")
    public String findUserForm() {
        return "findUserForm";
    }

    @PostMapping("/findUser")
    public String findUser(@RequestParam long id, Model model) {
        User user = userRepository.findById(id);

        if (user == null) {
            model.addAttribute("errorMessage", "User not found");
            return "findUserForm";
        }

        model.addAttribute("user", user);
        return "displayUser";
    }

    @GetMapping("/list")
    public String listUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "displayUsers";
    }
}
