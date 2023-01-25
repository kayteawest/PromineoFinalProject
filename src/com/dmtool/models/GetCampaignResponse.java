package com.dmtool.models;

public class GetCampaignResponse {
	
	int campaignId; // Campaign ID
	String campaignName; // Campaign Name
	String dungeonMaster; // Name of Dungeon Master currently running the Campaign
	int[] sessionIds; // List of associated Sessions by ID
	int[] playerIds; // List of associated Players across all Sessions by ID

}
