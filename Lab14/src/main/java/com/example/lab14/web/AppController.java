package com.example.lab14.web;

import com.example.lab14.domain.Posts;
import com.example.lab14.domain.Users;
import com.example.lab14.infrastructure.PostsRepository;
import com.example.lab14.infrastructure.UsersRepository;
import org.apache.catalina.User;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Set;

@Controller
public class AppController {

    final UsersRepository usersRepository;
    final PostsRepository postsRepository;

    public AppController(UsersRepository usersRepository, PostsRepository postsRepository) {
        this.usersRepository = usersRepository;
        this.postsRepository = postsRepository;
    }

    @GetMapping ("/home")
    public String getHome (HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        String username = session.getAttribute("username").toString();
        String id = session.getAttribute("id").toString();
        model.addAttribute("postSet", postsRepository.findAll());
        model.addAttribute("username", username);
        model.addAttribute("id", id);
        return "home";
    }

    @GetMapping("/login")
    public String getLogin () {
        return "login";
    }

    @GetMapping ("/signup")
    public String getSignup () {
        return "signup";
    }

    @PostMapping ("/login")
    public RedirectView postLogin (HttpServletRequest request, String username, String password){
        Users usernameDB = usersRepository.findByUsername(username);
        if (usernameDB == null || (!BCrypt.checkpw(password, usernameDB.getPassword()))){
            return new RedirectView("/login");
        }
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        session.setAttribute("user", usernameDB);
        session.setAttribute("id",usernameDB.getId());
        return new RedirectView("/home");
    }

    @PostMapping ("/signup")
    public RedirectView postSignup (String username, String password){

        String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
        Users newUser = new Users (username, hashPassword);
        usersRepository.save(newUser);
        return new RedirectView("/login");
    }

    @PostMapping ("/logout")
    public RedirectView logout (HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();

        return new RedirectView("/login");
    }

    @GetMapping ("/post")
    public String getPost (HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        String username = session.getAttribute("username").toString();
        model.addAttribute("username", username);
        return "post";
    }

    @PostMapping ("/post")
    public RedirectView postPost ( HttpServletRequest request, @ModelAttribute Posts posts){
        HttpSession session = request.getSession();
        Long id = (Long) session.getAttribute("id");
        Users users = usersRepository.findById(id).orElseThrow();
        System.out.println(users);
        System.out.println(id);
        posts.setUsers(users);
        postsRepository.save(posts);

        return new RedirectView("/home");

    }
}
