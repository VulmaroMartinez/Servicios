package mx.edu.utez.IntegradoraServicios.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login/oauth2")
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/index")
    public String index(HttpServletRequest request) {
        if (request.getUserPrincipal() != null) {
            // El usuario está autenticado, redirigir a la página deseada (por ejemplo, "index")
            return "redirect:/index";
        } else {
            // El usuario no está autenticado, mostrar página de error o manejar de acuerdo a tus necesidades
            return "redirect:/login/oauth2/login";
        }
    }
}
