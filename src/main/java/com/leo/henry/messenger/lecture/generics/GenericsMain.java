package com.leo.henry.messenger.lecture.generics;

public class GenericsMain {
    public static void main(String[] args) {
        FootBallPlayer aguero = new FootBallPlayer("Aguero");
        FootBallPlayer williams = new FootBallPlayer("Williams");
        FootBallPlayer sallah = new FootBallPlayer("M.Sallah");
        FootBallPlayer sanchez = new FootBallPlayer("Sanchez");
        FootBallPlayer kaka = new FootBallPlayer("Kaka");
        BaseBallPlayer pat = new BaseBallPlayer("Pat");
        SoccerPlayer beckhan = new SoccerPlayer("Beckham");

        Team<FootBallPlayer> manCity = new Team<>("Manchester City");
        Team<FootBallPlayer> manUnited = new Team<>("Manchester United");
        Team<FootBallPlayer> chelsea = new Team<>("Chelsea");
        Team<FootBallPlayer> liverpool = new Team<>("Liverpool");
        Team<FootBallPlayer> arsenal = new Team<>("Arsenal");
        manCity.addPlayer(aguero);
        manUnited.addPlayer(sanchez);
        chelsea.addPlayer(williams);
        liverpool.addPlayer(sallah);
        arsenal.addPlayer(kaka);

        Team<BaseBallPlayer> baseBallTeam = new Team<>("Leo Gold");
        baseBallTeam.addPlayer(pat);

        Team<SoccerPlayer> soccerTeam = new Team<>("Enugu Ranger");
        soccerTeam.addPlayer(beckhan);
        Team<SoccerPlayer> abaBoys = new Team<>("Aba Boys");

        manCity.matchResult(manUnited,2,1);
        chelsea.matchResult(manCity,0,4);
        liverpool.matchResult(chelsea,2,1);
        arsenal.matchResult(liverpool,1,3);
        manUnited.matchResult(arsenal,1,2);


        soccerTeam.matchResult(abaBoys,1,1);
        System.out.println("Rankings ");


        League<Team<FootBallPlayer>> FBLeague = new League<>("EPL");
        FBLeague.add(manCity);
        FBLeague.add(manUnited);
        FBLeague.add(liverpool);
        FBLeague.add(chelsea);
        FBLeague.add(arsenal);
        FBLeague.showLeagueTable();
    }
}
