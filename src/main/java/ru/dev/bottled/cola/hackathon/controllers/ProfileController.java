package ru.dev.bottled.cola.hackathon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dev.bottled.cola.hackathon.dto.ProfileInfo;
import ru.dev.bottled.cola.hackathon.models.Profile;
import ru.dev.bottled.cola.hackathon.models.User;
import ru.dev.bottled.cola.hackathon.security.details.UserDetailsImpl;
import ru.dev.bottled.cola.hackathon.services.templates.UsersService;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/me")
    public String getMyProfilePage(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return "redirect:/profile/" + userDetails.getUsername();
    }

    @GetMapping("/{username}")
    public String getProfilePage(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                 @PathVariable("username") String userUsername,
                                 Model model) {
        model.addAttribute("myUsername", userDetails.getUsername());
//        var currentUserId = userDetails.getUser().getId();
        var user = usersService.getUser(userUsername);
        if (user == null) {
            return "redirect:/error";
        }
        var me = user.getUsername().equals(userDetails.getUsername());
        if (me) {
            model.addAttribute("me", userDetails.getUsername());
        }
        model.addAttribute("user", user);
        var profile = user.getProfile();
        if (profile == null) {
            profile = new Profile(user);
            user.setProfile(profile);
            if (me) {
                usersService.updateUser(user);
            }
        }
        model.addAttribute("profile", profile);
        return "profile_page";
    }

    @GetMapping("/settings")
    public String getSettingsPage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        var user = getUser(userDetails, model);
        if (user != null) {
            var profile = user.getProfile();
            model.addAttribute("profile", profile);
        }
        return "settings_page";
    }

    @PostMapping("/settings")
    public String updateProfile(@AuthenticationPrincipal UserDetailsImpl userDetails, ProfileInfo profileInfo) {
        profileInfo.setId(userDetails.getUser().getId());
        usersService.updateProfile(profileInfo);
        return "redirect:/profile/me";
    }

    private User getUser(UserDetailsImpl userDetails, Model model) {
        var result = usersService.getUser(userDetails.getUsername());
        model.addAttribute("user", result);
        return result;
    }
}
