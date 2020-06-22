package com.tsky.dsign.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class ConnectToServer {
	public static Logger logger = LogManager.getLogger(ConnectToServer.class);

	public void Execute(String command) {

		String hostName = ResourceReader.readConfigProps("server.host");
		String userName = ResourceReader.readConfigProps("server.username");
		String password = ResourceReader.readConfigProps("server.password");
		ChannelExec channel = null;
		
		//String khfile = ResourceReader.getValueFromPropertiesBundle(Constant.PUBLIC_KEY_LOCATION);
		//String identityfile = ResourceReader.getValueFromPropertiesBundle(Constant.PRIVATE_KEY_LOCATION);

		JSch jsch = null;
		Session session = null;
		
		try {
			jsch = new JSch();
			session = jsch.getSession(userName, hostName, 22);
			session.setPassword(password);
			//jsch.setKnownHosts(khfile);
			//jsch.addIdentity(identityfile);

			java.util.Properties config = new java.util.Properties(); 
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			logger.info("Trying to connect to the server "+hostName);
			session.connect();
			logger.info("Successfully connected to the server "+hostName);
			channel = (ChannelExec) session.openChannel("exec");
			// Set the command to execute on the channel and execute the command
            channel.setCommand("sh /home/digisign/profile1/runShell.sh");
            channel.connect();

            // Get an InputStream from this channel and read messages, generated 
            // by the executing command, from the remote side.
            InputStream in = channel.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null) {
                logger.info(line);
            }

            // Command execution completed here.

            // Retrieve the exit status of the executed command
            int exitStatus = channel.getExitStatus();
            if (exitStatus > 0) {
                logger.info("Remote script exec error! " + exitStatus);
            }
            //Disconnect the Session
            session.disconnect();

		} catch (Exception e) { 	
			e.printStackTrace();
		} finally {
			if(session!=null) {
				session.disconnect();
			}

		}

	}

	/*private void createRemoteFolder(Session session,String folder){
		ChannelExec channelExec=null;
		InputStream in=null;
		try {
			channelExec = (ChannelExec)session.openChannel("exec");
			in = channelExec.getInputStream();
		} catch (JSchException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		channelExec.setCommand("mkdir -p "+folder);
		try {
			channelExec.connect();
		} catch (JSchException e) {
			e.printStackTrace();
		}

		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line;
		int index = 0;
		try {
			while ((line = reader.readLine()) != null) {
				logger.info(++index + " : " + line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		int exitStatus = channelExec.getExitStatus();
		channelExec.disconnect();
	}*/
		
}