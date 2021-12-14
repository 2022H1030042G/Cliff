package com.example.Cliff.Controller;

import com.example.Cliff.Model.Team;
import com.example.Cliff.Repository.PlayerRepository;
import com.example.Cliff.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class TeamController {
    @Autowired
    private TeamService teamService;
    @Autowired
    private PlayerRepository repo1;

    public TeamController(TeamService itemService) {
        this.teamService = teamService;
    }

    // display list of Teams
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listItem", teamService.getAllItem());
        model.addAttribute("listSavings", repo1.findAll());
        return "index";
    }
    // Create a Team
    @GetMapping("/showNewTeamForm")
    public String showNewItemForm(Model model) {
        // create model attribute to bind form data
        Team item = new Team();
        model.addAttribute("item", item);
        return "new_item";
    }
    // Save a team
    @PostMapping("/saveItem")
    public String saveItem(@ModelAttribute("item") Team item, @Valid Team itemValid, Errors error) {
        // save item to database
        if(error.hasErrors())
            return "new_item";
        teamService.saveItem(item);
        return "redirect:/";
    }
    //Delete a Team
    @GetMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable(value = "id") long id) {

        // call delete item method
        this.teamService.deleteItemById(id);
        return "redirect:/";
    }
    //Update a Team
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor=Exception.class)
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {

        // get item from the service
        Team item = teamService.getItemById(id);

        // set item as a model attribute to pre-populate the form
        model.addAttribute("item", item);
        return "update_item";
    }
}