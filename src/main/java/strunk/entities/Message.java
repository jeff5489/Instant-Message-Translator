package strunk.entities;

import java.sql.Timestamp;

public abstract class Message {
	private int id;
	private int sendingUserId;
	private int receivingUserId;
	private Timestamp sentDate;
}
