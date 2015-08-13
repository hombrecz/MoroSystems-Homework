package com.hombre.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.hombre.db.bo.RoleBo;
import com.hombre.db.bo.UserBo;
import com.hombre.db.model.Role;
import com.hombre.db.model.User;
import com.hombre.security.HashCode;

@Controller
public class AdminUsersController {

    @Autowired
    private UserBo userBo;
    
    @Autowired
    private RoleBo roleBo;

    @Autowired
    private HashCode hashCode;

    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(List.class, "role", new CustomCollectionEditor(List.class) {
            @Override
            protected Object convertElement(Object element) {
                String roleName = (String)element;
                Role role = new Role();
                role.setRole(roleName);
                return role;
            }
        });
    }


    @RequestMapping(value = "admin/adminUsers", method = RequestMethod.GET)
    public ModelAndView listUsers(@ModelAttribute("user") User user) {
        ModelAndView model = new ModelAndView("admin/adminUsers");
        List<User> usersList = userBo.listUser();
        model.addObject("userslist", usersList);

        return model;
    }

    @RequestMapping(value = "admin/adminUserDelete", method = RequestMethod.POST)
    public String deleteUser(@ModelAttribute("user") User user) {
        userBo.delete(user);
        return "redirect:/admin/adminUsers";
    }

    @RequestMapping(value = "admin/adminUserAddEdit", method = RequestMethod.GET)
    public String initForm(@ModelAttribute("user") User user) {
        return "admin/adminUserAddEdit";
    }

    @RequestMapping(value = "admin/adminUserAddEdit", method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("user") @Valid User user, BindingResult result, SessionStatus status) {

        if (result.hasErrors()) {
            return "admin/adminUserAddEdit";
        } else {
            status.setComplete();

            if (user.getUserid() == -1) {
                user.setPassword(hashCode.getHashPassword(user.getPassword()));
                userBo.save(user);
                for(Role role:user.getRoles()) {
                    roleBo.save(new Role(user, role.getRole()));
                }
            } else {
                user.setPassword(hashCode.getHashPassword(user.getPassword()));
                userBo.merge(user);
                
                for(Role role:userBo.getUserById(user.getUserid()).getRoles()) {
                    roleBo.delete(role);
                }
                
                for(Role role:user.getRoles()) {
                    roleBo.save(new Role(user, role.getRole()));
                }
            }
            
            return "redirect:/admin/adminUsers";
        }
    }

}
