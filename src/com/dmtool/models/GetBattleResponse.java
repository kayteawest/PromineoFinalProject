package com.dmtool.models;

public class GetBattleResponse { // Stretch Goal
	
	int campaignId; // ID of the Campaign the Battle happens under
	int encounterId; // ID of the Encounter the Battle happens under
	int battleId; // Battle ID
	int[] playerCharacterIds; // List of PlayerCharacters by ID involved in the Battle
	int[] monsterIds; // List of Monsters by ID involved in the Battle
	String[] initiativeOrder; // List of PlayerCharacters and Monsters in initiative order - Monsters are grouped

}
