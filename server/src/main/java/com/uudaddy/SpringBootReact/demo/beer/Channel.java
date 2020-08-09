package com.uudaddy.SpringBootReact.demo.beer;

import java.util.ArrayList;

public class Channel {
	long channelid;
	
	
	ArrayList<Long> consumeridlist = new ArrayList<Long>();

	public void addConsumer(long consumerid)
	{
		consumeridlist.add(consumerid);
	}
	/*
	public void publish(long consumerid)
	{
		// loop 
		for(int ii=0; ii<channelidset.size(); ii++)
		{
			System.out.println("from: " + channelidset.get(ii)  + " to: " + consumerid);
		}
	}
	*/
}
