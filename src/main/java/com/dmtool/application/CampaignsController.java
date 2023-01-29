package com.dmtool.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.dmtool.interfaces.ICampaignsController;
import com.dmtool.interfaces.ICampaignsDataAccessLayer;
import com.dmtool.models.Campaign;
import com.dmtool.models.CreateCampaignRequest;
import com.dmtool.models.UpdateCampaignRequest;

@RestController
public class CampaignsController implements ICampaignsController {

	@Autowired
	private ICampaignsDataAccessLayer campaignsDataAccess;

	@Override
	public int createCampaign(CreateCampaignRequest createCampaignRequest) {

		return campaignsDataAccess.insertCampaign(createCampaignRequest.getCampaignName(),
				createCampaignRequest.getDungeonMaster());

	}

	@Override
	public Campaign getCampaign(int campaignId) {

		return campaignsDataAccess.selectCampaignById(campaignId);

	}

	@Override
	public void updateCampaign(int campaignId, UpdateCampaignRequest updateCampaignRequest) {

		campaignsDataAccess.updateCampaignById(campaignId, updateCampaignRequest.getCampaignName(),
				updateCampaignRequest.getDungeonMaster());

	}

	@Override
	public void deleteCampaign(int campaignId) {

		campaignsDataAccess.deleteCampaignById(campaignId);

	}

}
