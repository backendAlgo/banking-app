package uz.najottalim.bankingapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountsController {

    @GetMapping
    public String accountsController() {
        return "accounts";
    }

    @GetMapping("/{id}")
    public Integer getBalance(@PathVariable Long id) {
        return 100;
    }

//    @GetMapping("/hello")
//    public String hello(HttpServletRequest request) {
//        log.info("path: {}", request.getPathInfo());
//        log.info("request: {}", request.getRequestURI());
//        log.info("cookie: {}", Arrays.stream(request.getCookies())
//                .map(cookie -> cookie.getValue())
//                .collect(Collectors.toList()));
//        return "Hello, Spring Security";
//    }
}
