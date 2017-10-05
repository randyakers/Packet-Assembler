package assembly;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Assembler {
	
	public static void main(String[] args)
	{
        File text = new File("packets.txt");
        int messageID;
        int packetID;
        int numPackets;
        String message;
        Packet firstPacket;
        Packet currentPacket;
        Set<Integer> uniqueMessageIDs;
        final int maxPacketID = 20; //this is the highest expected value for packetID
        
      
        Scanner scnr = new Scanner(System.in);
		try {
			scnr.close();
			scnr = new Scanner(text);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		messageID = scnr.nextInt();
        packetID = scnr.nextInt();
        numPackets = scnr.nextInt();
        message = scnr.nextLine();
        
        firstPacket = new Packet(messageID, packetID, numPackets, message);
        currentPacket = firstPacket;
      
        while(scnr.hasNextLine())
        {
            messageID = scnr.nextInt();
            packetID = scnr.nextInt();
            numPackets = scnr.nextInt();
            message = scnr.nextLine();
            currentPacket.nextPacket = new Packet(messageID, packetID, numPackets, message);//creates a "linked list" of packets
            currentPacket = currentPacket.nextPacket;
        }
        
        uniqueMessageIDs = new HashSet<Integer>();
        
        currentPacket = firstPacket;
        
        while(currentPacket.hasNext())
        {
        	uniqueMessageIDs.add(currentPacket.messageID);
        	currentPacket = currentPacket.nextPacket;
        }
        
        Iterator<Integer> iterator = uniqueMessageIDs.iterator();
        
        currentPacket = firstPacket;
        
        int id;
        int index = 0;
        
        while(iterator.hasNext())
        {
        	id = iterator.next();
        	while(index < maxPacketID)
        	{
        		while(currentPacket.hasNext())
        		{
        			if(currentPacket.messageID == id && currentPacket.packetID == index)
        			{
        				currentPacket.printToString();
        			}
        			currentPacket = currentPacket.nextPacket;
        		}
        		currentPacket = firstPacket;
        		index++;
        	}
        	index = 0;
        }
        if(scnr!=null)
            scnr.close();
    }
}

