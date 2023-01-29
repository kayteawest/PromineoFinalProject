package com.dmtool.models;

import lombok.Getter;

@Getter
public class UpdatePlayerCharacterRequest {

	String playerCharacterName; // New name of the PlayerCharacter - Optional
	int initiativeBonus; // New initiative bonus - Optional

}
