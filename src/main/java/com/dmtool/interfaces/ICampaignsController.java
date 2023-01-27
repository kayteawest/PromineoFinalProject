package com.dmtool.interfaces;

import org.springframework.web.bind.annotation.RequestMapping;

import com.dmtool.models.CreateCampaignRequest;

@RequestMapping("/campaigns")

public interface ICampaignController {
	
	int createCampaign( CreateCampaignRequest createCampaignRequest);

}
