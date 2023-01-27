package com.dmtool.interfaces;

import com.dmtool.models.PlayerCharacters;

public interface IPlayerCharactersDataAccessLayer {
	
	int insertPlayerCharacter(int playerId, String characterName, int initiativeBonus);
	PlayerCharacters selectPlayerCharacterById(int characterId);
	void updatePlayerCharacterById(int characterId, String characterName, int initiativeBonus);
	void deletePlayerCharacterById(int characterId);

}
