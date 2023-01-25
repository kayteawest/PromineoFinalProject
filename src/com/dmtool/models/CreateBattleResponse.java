package com.dmtool.models;

public class CreateBattleResponse { // Stretch Goal
	
	int campaignId; // ID of the Campaign this Battle happens under
	int encounterId; // ID of the Encounter this Battle happens under
	int battleId; // Battle ID
	String[] initiativeOrder; // List of PlayerCharacters & Monsters in initiative order -  Monsters are grouped

}
