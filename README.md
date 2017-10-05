[2017-09-26] Challenge #333 [Easy] Packet Assembler
https://www.reddit.com/r/dailyprogrammer/comments/72ivih/20170926_challenge_333_easy_packet_assembler/

Description

When a message is transmitted over the internet, it is split into multiple packets, each packet is transferred individually, and the packets are reassembled into the original message by the receiver. Because the internet exists in the real world, and because the real world can be messy, packets do not always arrive in the order in which they are sent. For today's challenge, your program must collect packets from stdin, assemble them in the correct order, and print the completed messages to stdout.
The point of reading from stdin is to simulate incoming packets. For the purposes of this challenge, assume there is a potentially unlimited number of packets. Your program should not depend on knowing how many packets there are in total. Simply sorting the input in its entirety would technically work, but defeats the purpose of this exercise.
Input description

Each line of input represents a single packet. Each line will be formatted as X Y Z some_text, where X Y and Z are positive integer and some_text is an arbitrary string. X represents the message ID (ie which message this packet is a part of). Y represents the packet ID (ie the index of this packet in the message) (packets are zero-indexed, so the first packet in a message will have Y=0, the last packet in a message will have Y=Z-1). Z represents the total number of packets in the message.
It is guaranteed that there will be no duplicate packets or message IDs.
