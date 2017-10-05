package assembly;

public class Packet {
	
	int messageID;
	int packetID;
	int numPackets;
	String message;
	Packet nextPacket;
	
	public Packet (int mID, int pID, int numP, String mess)
	{
		this.messageID = mID;
		this.packetID = pID;
		this.numPackets = numP;
		this.message = mess;
	}
	
	public boolean hasNext()
	{
		if(nextPacket != null)
			return true;
		else
			return false;
	}
	
	public void printToString()
	{
		System.out.println(this.messageID + " " + this.packetID + " " + this.numPackets + " " + this.message);
	}

}
