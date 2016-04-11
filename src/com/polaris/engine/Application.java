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

	public void update(double delta)
	{
		if(network != null)
		{
			this.network.update(delta);
		}
		super.update(delta);
	}

	public ClientNetwork getNetwork()
	{
		return network;
	}

}
