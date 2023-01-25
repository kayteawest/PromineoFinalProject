package com.dmtool.models;

public class GetEncounterResponse {
	
	int campaignId; // ID of the Campaign this Encounter belongs to
	int encounterId; // Encounter ID
	String encounterName; // Encounter name
	int[] playerIds; // List of Player IDs actively in the Encounter
	int[] battleIds; // List of Battles that occurred in the Session -- Stretch Goal

}
