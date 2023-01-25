package com.dmtool.models;

public class GetPlayerResponse {
	
	int playerId; // Player ID
	String playerName; // Player name
	int[] characterIds; // List of PlayerCharacter IDs associated with the Player
	int[] campaignIds; // List of Campaign IDs the Player actively belongs to
	int[] encoutnerIds; // List of Encounter IDs the Player actively belongs to
	int[] battleIds; // List of Battles by ID the Player took part in - Stretch Goal

}
