package com.dmtool.models;

public class CreateEncounterRequest {
	
	  int campaignId; // ID of the Campaign to create the Encounter under - Required
	  int[] playerCharacterIds; // Initial set of PlayerCharacters by ID involved in the Encounter - Required

}
