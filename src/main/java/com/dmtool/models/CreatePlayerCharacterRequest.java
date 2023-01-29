package com.dmtool.models;

import lombok.Getter;

@Getter
public class CreatePlayerCharacterRequest {

	String characterName; // Character name - Required
	int initiativeBonus; // Initiative roll bonus - Required

}
