package dev.danvega.jte_login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication, Model model) {

        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();

            if (principal instanceof UserDetails userDetails) {
                model.addAttribute("username", userDetails.getUsername());
                model.addAttribute("authorities", userDetails.getAuthorities());
            } else if (principal instanceof OAuth2User oauth2User) {
                model.addAttribute("username", oauth2User.getAttribute("name"));
                model.addAttribute("email", oauth2User.getAttribute("email"));
                model.addAttribute("authorities", oauth2User.getAuthorities());
            }
        }

        return "pages/dashboard";
    }
}
