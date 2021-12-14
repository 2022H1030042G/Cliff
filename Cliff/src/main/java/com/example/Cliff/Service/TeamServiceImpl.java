package com.example.Cliff.Service;

import com.example.Cliff.Model.Team;
import com.example.Cliff.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService{
    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<Team> getAllItem() {
        return teamRepository.findAll();
    }

    @Override
    public void saveItem(Team item) {
        this.teamRepository.save(item);
    }

    @Override
    @Transactional
    public void saveAllItem(List<Team> items) {
        this.teamRepository.saveAll(items);
        this.teamRepository.flush();
    }

    @Override
    public Team getItemById(long id) {
        Optional<Team> optional = teamRepository.findById(id);
        Team item = null;
        if (optional.isPresent()) {
            item = optional.get();
        } else {
            throw new RuntimeException(" Item not found for id :: " + id);
        }
        return item;
    }

    @Override
    public void deleteItemById(long id) {
        this.teamRepository.deleteById(id);
    }
}
