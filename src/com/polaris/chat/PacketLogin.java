package com.polaris.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import com.polaris.engine.network.Network;
import com.polaris.engine.network.Packet;

public class PacketLogin extends Packet
{
	
	private String user;
	private String pass;
	
	public PacketLogin() {}
	
	public PacketLogin(String username, String password)
	{
		 
	}

	@Override
	public void writeData(DataOutputStream output) throws IOException
	{
		
	}

	@Override
	public void copy(DataInputStream data) throws IOException
	{
		
	}

	@Override
	public void handle(Network network)
	{
		
	}

}
