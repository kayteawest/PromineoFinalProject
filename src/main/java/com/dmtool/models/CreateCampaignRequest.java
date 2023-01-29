package com.dmtool.models;

import lombok.Getter;

@Getter
public class CreateCampaignRequest {

	String dungeonMaster; // Name of the Dungeon Master running the Campaign - Optional
	String campaignName; // Name of the Campaign (Ex: The Curse of Strahd) - Optional

}
