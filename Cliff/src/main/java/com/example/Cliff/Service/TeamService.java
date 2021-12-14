package com.example.Cliff.Service;

import com.example.Cliff.Model.Team;

import java.util.List;

public interface TeamService {
    List<Team> getAllItem();
    void saveItem(Team item);
    void saveAllItem(List<Team> items);
    Team getItemById(long id);
    void deleteItemById(long id);
}
