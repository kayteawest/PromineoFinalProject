package com.dmtool.models;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class Encounter {

	int encounterId; // Encounter ID
	int campaignId; // ID of the Campaign the Encounter belongs to
	LocalDateTime createdDate; // LocalDateTime the Encounter was created

	public Encounter() {

	}

	public Encounter(int encounterId, int campaignId, LocalDateTime createdDate) {
		this.encounterId = encounterId;
		this.campaignId = campaignId;
		this.createdDate = createdDate;
	}
}
