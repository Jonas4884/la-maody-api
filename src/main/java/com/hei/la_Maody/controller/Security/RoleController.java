package com.hei.la_Maody.controller.Security;

import com.hei.la_Maody.model.User.Role;
import com.hei.la_Maody.service.securityService.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class RoleController {
    private RoleService roleService;

    @PostMapping("/roles")
    public Role addRole (@RequestBody Role role){
        return roleService.save(role);
    }

    @GetMapping("/roles")
    public List<Role> getAll(){
        return roleService.getAll();
    }
}
