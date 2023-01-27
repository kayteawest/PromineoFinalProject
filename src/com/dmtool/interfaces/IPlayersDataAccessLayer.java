package com.dmtool.interfaces;

import com.dmtool.models.Players;

public interface IPlayersDataAccessLayer {
	
	int insertPlayer(String playerName);
	Players selectPlayerById(int playerId);
	void updatePlayerById(int playerId, String playerName);
	void deletePlayerById(int playerId);

}
