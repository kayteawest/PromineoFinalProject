package com.dmtool.interfaces;

import com.dmtool.models.Campaigns;

public interface ICampaignsDataAccessLayer {
	
	  int insertCampaign(String campaignName, String dungeonMaster);
	  Campaigns selectCampaignById(int campaignId);
	  void updateCampaignById(int campaignId, String campaignName, String dungeonMaster);
	  void deleteCampaignById(int campaignId);

}
