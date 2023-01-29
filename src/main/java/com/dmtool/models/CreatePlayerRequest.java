package com.dmtool.models;

import lombok.Getter;

@Getter
public class CreatePlayerRequest {

	String playerName; // Player name - Required
	CreatePlayerCharacterRequest[] characters; // List of initial PlayerCharacters - Optional

}
