package com.dmtool.models;

import java.time.LocalDateTime;

public class PlayerCharacters {
	
	int characterId; // PlayerCharacter ID
	int playerId; // ID of the Player this PlayerCharacter belongs to
	String characterName; // PlayerCharacter name
	LocalDateTime createdDate; // LocalDateTime the PlayerCharacter was created
	int initiativeBonus; // Initiative roll bonus

}
