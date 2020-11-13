package com.choicemanager.service;

import com.choicemanager.domain.Goal;
import com.choicemanager.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;
   // @Override
    public boolean AddGoal(Goal goal)
    {
        if(goalRepository.findByName(goal.getName()) != null) {
            return false;
        }
        goal.setName(goal.getName());
        goal.setCategory(goal.getCategory());
        goal.setExplanation(goal.getExplanation());
        goalRepository.save(goal);
        return true;

    }

    public boolean DeleteGoal(Goal goal)
    {
        goalRepository.delete(goal);
        return true;
    }

    public Iterable<Goal> GetGoals() {
        return goalRepository.findAll();
    }

}
