package com.dmtool.interfaces;

import com.dmtool.models.Player;

public interface IPlayersDataAccessLayer {

	int insertPlayer(String playerName);

	Player selectPlayerById(int playerId);

	void updatePlayerById(int playerId, String playerName);

	void deletePlayerById(int playerId);

}
