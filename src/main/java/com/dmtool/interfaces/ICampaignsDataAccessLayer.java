package com.dmtool.interfaces;

import com.dmtool.models.Campaign;

public interface ICampaignsDataAccessLayer {

	int insertCampaign(String campaignName, String dungeonMaster);

	Campaign selectCampaignById(int campaignId);

	void updateCampaignById(int campaignId, String campaignName, String dungeonMaster);

	void deleteCampaignById(int campaignId);

}
