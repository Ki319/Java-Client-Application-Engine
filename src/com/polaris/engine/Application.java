package com.polaris.engine;

import com.polaris.engine.network.ClientNetwork;

public abstract class Application extends App
{
	private ClientNetwork network = null;
	
	public Application() {}
	
	public Application(ClientNetwork sidedNetwork)
	{
		network = sidedNetwork;
		network.setApplication(this);
	}
	
	public ClientNetwork getNetwork()
	{
		return network;
	}

}
