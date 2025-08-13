package in.sp.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import in.sp.main.entities.Course;
import in.sp.main.entities.User;
import in.sp.main.entities.user.UserRepository;
import in.sp.main.services.CourseService;
import in.sp.main.services.UserService;
import jakarta.validation.Valid;

@Controller
@SessionAttributes("sessionUser")   // session me attribute store karega
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CourseService courseService;
    

    // ----------------- HOME -----------------
    @GetMapping({"/", "/index"})
    public String openIndexPage(Model model) {

        List<Course> coursesList = courseService.getAllCourseDetailsList();
        model.addAttribute("coursesList", coursesList);

        return "index";
    }
    
    // ----------------- LOGIN GET -----------------
    @GetMapping("/login")
    public String openLoginPage(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    // ----------------- LOGIN POST -----------------
    @PostMapping("/loginForm")
    public String handleLoginform(@ModelAttribute("user") User user, Model model) {

        boolean isAuthenticated = userService.loginUserService(user.getEmail(), user.getPassword());

        if (isAuthenticated) {
            // DB se authenticated user nikal lo
            User authenticatedUser = userRepository.findByEmail(user.getEmail());

            // session attribute set
            model.addAttribute("sessionUser", authenticatedUser);

            // login hone ke baad profile page
            return "user-profile";
        } else {
            model.addAttribute("errorMsg", "Incorrect Email id or password");
            return "login"; // login page wapas
        }
    }

    // ----------------- REGISTER GET -----------------
    @GetMapping("/register")
    public String openRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // ----------------- REGISTER POST -----------------
    @PostMapping("/regForm")
    public String handleRegForm(@Valid @ModelAttribute("user") User user,
                                BindingResult result,
                                Model model) {
        if (result.hasErrors()) {
            return "register";
        }

        try {
            userService.registerUserService(user);
            model.addAttribute("successMsg", "Registered Successfully!");
            return "register";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg", "Registration failed");
            return "error";
        }
    }

    // ----------------- LOGOUT -----------------
    @GetMapping("/logout")
    public String logout(SessionStatus status) {
        // Logout par session clear karna
        status.setComplete();
        return "redirect:/index";  // logout hone ke baad home page par
    }
    
    @GetMapping("/userProfile")
    public String openUserProfile() {
        
        return "user-profile"; 
    }
    
    @GetMapping("/myCourses")
    public String myCoursesPage() {
        
        return "my-courses"; 
    }
}
