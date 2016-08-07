package com.dyrda.controller;

import com.dyrda.entity.User;
import com.dyrda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Segiy on 01.08.2016.
 */

@Controller
public class UserController {
    private static final int ROWS_PER_PAGE = 5;

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("userValidator")
    private Validator validator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @RequestMapping(value = "addUser")
    public ModelAndView addUser(@ModelAttribute User user) {
        return new ModelAndView("userForm");
    }

    @RequestMapping("editUser")
    public ModelAndView editUser(@RequestParam long id, @ModelAttribute User user,
                                 @RequestParam (value = "page", required = false) Integer page) {
        user = userService.getUserById(id);

        ModelAndView modelAndView = new ModelAndView("userForm", "userObject", user);

        modelAndView.addObject("page", page);
        return modelAndView;
    }

    @RequestMapping("saveUser")
    public ModelAndView saveUser(@Validated @ModelAttribute User user,
                                 BindingResult result) {

        if (result.hasErrors())
            return new ModelAndView("userForm");

        if (user.getId() == 0)
            userService.createUser(user);
        else
            userService.updateUser(user);

        Integer page = user.getPage();
        if (page == null)
            return new ModelAndView("redirect:getAllUsers");

            return new ModelAndView("redirect:getUsersPerPage?page=" + page);
    }

    @RequestMapping("deleteUser")
    public ModelAndView deleteUser(@RequestParam long id,
                                   @RequestParam (value = "page", required = false) Integer page) {
        userService.deleteUser(id);

        if (page == null)
            return new ModelAndView("redirect:getAllUsers");

        return new ModelAndView("redirect:getUsersPerPage?page=" + page);
    }

    @RequestMapping(value = {"getAllUsers", "/"})
    public ModelAndView getAllUsers() {
        ModelAndView modelAndView = new ModelAndView("redirect:getUsersPerPage?page=0");

        return modelAndView;
    }

    @RequestMapping("getUsersPerPage")
    public ModelAndView pageOfUsers(@RequestParam("page") Integer page) {
        List<User> userList = userService.getAllUsers();

        ModelAndView modelAndView = getPagedModelAndView(page, userList, false, null);

        return modelAndView;
    }

    @RequestMapping("searchUser")
    public ModelAndView searchUser(@RequestParam String searchName,
                                   @RequestParam(required = false) Integer page) {

        if (searchName.equals("all")) return new ModelAndView("redirect:getAllUsers");

        List<User> userList = userService.getUsersByName(searchName);

        ModelAndView pagedModelAndView;
        if (page == null) {
            pagedModelAndView = getPagedModelAndView(0, userList, true, searchName);
        } else {
            pagedModelAndView = getPagedModelAndView(page, userList, true, searchName);
        }

        return pagedModelAndView;
    }

    private ModelAndView getPagedModelAndView(Integer page, List<User> userList, boolean search, String searchName) {
        PagedListHolder<User> pagedListHolder = new PagedListHolder<>();
        pagedListHolder.setSource(userList);
        pagedListHolder.setPageSize(ROWS_PER_PAGE);
        pagedListHolder.setPage(page);

        int startPage = Math.max(1, ((page - ROWS_PER_PAGE) >= 5 ? 5 : (page - ROWS_PER_PAGE)));
        int endPage = Math.min(startPage + 5, pagedListHolder.getPageCount());

        ModelAndView modelAndView;
        if (search) {
            modelAndView = new ModelAndView("searchUserList");
            modelAndView.addObject("searchName", searchName);
        } else {
            modelAndView = new ModelAndView("userList");
        }

        modelAndView.addObject("userList", pagedListHolder.getPageList());

        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("startPage", startPage);
        modelAndView.addObject("endPage", endPage);
        return modelAndView;
    }

}
