package com.dmtool.models;

import java.time.LocalDateTime;

public class PlayerCharacters {
	
	int characterId; // PlayerCharacter ID
	int playerId; // Player ID
	String characterName; // Character name
	LocalDateTime createdDate; // LocalDateTime the PlayerCharacter was created
	int initiativeBonus; // Character initiative bonus - Optional

}
