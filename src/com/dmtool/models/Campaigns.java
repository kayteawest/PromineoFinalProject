package com.dmtool.models;

import java.time.LocalDateTime;

public class Campaigns {
	
	int campaignId; // Campaign ID
	LocalDateTime createdDate; // LocalDateTime the Campaign was created
	String campaignName; // Campaign name - Optional
	String dungeonMaster; // Dungeon master name - Optional
	LocalDateTime lastEncounterDate; // LocalDateTime of the last Encounter - Optional

}
