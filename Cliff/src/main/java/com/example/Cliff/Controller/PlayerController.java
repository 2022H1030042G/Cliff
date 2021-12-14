package com.example.Cliff.Controller;

import com.example.Cliff.Model.Player;
import com.example.Cliff.Model.Team;
import com.example.Cliff.Repository.PlayerRepository;
import com.example.Cliff.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PlayerController {
    @Autowired
    private PlayerRepository microsRepo;
    @Autowired
    private TeamRepository itemRepo;
    //List of Players
    @GetMapping("/ListPlayers")
    public String ListPlayers(Model model) {
        List<Player> savingsList = microsRepo.findAll();
        model.addAttribute("savingsList", savingsList);
        return "list_MicroSavings";
    }
    //Create a Player
    @GetMapping("/showNewPlayersForm")
    public String showNewPlayersForm(Model model) {
        // create model attribute to bind form data
        List<Team> itemList = itemRepo.findAll();

        model.addAttribute("micro_savings", new Player());
        model.addAttribute("itemList", itemList);

        return "new_microSavings";
    }
    //Save a Player
    @PostMapping("/savePlayers")
    public String savePlayers(@ModelAttribute("micro_savings") Player savings, Model model) {
       Player save = microsRepo.save(savings);
        return "redirect:/";
    }

}
