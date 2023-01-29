package com.dmtool.models;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class PlayerCharacter {

	int characterId; // PlayerCharacter ID
	int playerId; // ID of the Player this PlayerCharacter belongs to
	String characterName; // PlayerCharacter name
	LocalDateTime createdDate; // LocalDateTime the PlayerCharacter was created
	int initiativeBonus; // Initiative roll bonus

	public PlayerCharacter() {

	}

	public PlayerCharacter(int characterId, int playerId, String characterName, LocalDateTime createdDate,
			int initiativeBonus) {
		super();
		this.characterId = characterId;
		this.playerId = playerId;
		this.characterName = characterName;
		this.createdDate = createdDate;
		this.initiativeBonus = initiativeBonus;
	}

}
