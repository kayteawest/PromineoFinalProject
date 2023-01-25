package com.dmtool.models;

public class CreatePlayerRequest {
	
	String playerName; // Player name - Required
	CreatePlayerCharacterRequest[] characters; // List of initial PlayerCharacters - Optional

}
