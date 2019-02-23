package com.leo.henry.messenger.lecture.generics;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Team<T extends Player> implements Comparable<Team<T>>{
    private String name;
    private int played = 0;
    private int won = 0;
    private int lost =0;
    private int tied =0;

    public Team(String name) {
        this.name = name;
    }

    private ArrayList<T> members = new ArrayList<>();

    public boolean addPlayer(T player)
    {
        if (members.contains(player))
        {
            System.out.println(player.getName()+" is already a member");
            return false;
        }else {
            members.add(player);
            System.out.println(player.getName()+" picked for team "+this.name);
            return true;
        }
    }
    public int numPlayers(){
        return this.members.size();
    }
    public void matchResult(Team<T> opponent, int ourScore, int theirScore){
        String message;
        if (ourScore > theirScore){
            won++;
            message =" beat ";
        }
        else if (ourScore == theirScore)
        {
            tied++;
            message = " draw with ";
        }
        else
        {
            lost++;
            message = " lost to ";
        }
        played++;
        if (opponent !=null){
            System.out.println(this.getName()+message+opponent.getName());
            opponent.matchResult(null,theirScore,ourScore);
        }
    }
    public int ranking (){
        return (won*2)+tied;
    }
    @Override
    public int compareTo(Team<T> team) {
        if (this.ranking()>team.ranking())
             return -1;
        else if (this.ranking()<team.ranking())
             return 1;

        else return 0;
    }
}
