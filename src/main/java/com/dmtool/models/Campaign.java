package com.dmtool.models;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class Campaign {

	int campaignId; // Campaign ID
	LocalDateTime createdDate; // LocalDateTime the Campaign was created
	String campaignName; // Campaign name - Optional
	String dungeonMaster; // Dungeon master - Optional
	LocalDateTime lastEncounterDate; // LocalDateTime of the last Encounter - Optional

	public Campaign() {

	}

	public Campaign(int campaignId, LocalDateTime createdDate, String campaignName, String dungeonMaster,
			LocalDateTime lastEncounterDate) {
		this.campaignId = campaignId;
		this.createdDate = createdDate;
		this.campaignName = campaignName;
		this.dungeonMaster = dungeonMaster;
		this.lastEncounterDate = lastEncounterDate;
	}
}
