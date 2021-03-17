package strunk.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message {
	
	@Id
	@GeneratedValue
	private int id;
	private int sendingUserId;
	private int receivingUserId;
	private Timestamp sentDate;
	private String originalContent;
	private String translatedContent;
	
	public Message(int sendingUserId, int receivingUserId, Timestamp sentDate, String originalContent,
			String translatedContent) {
		super();
		this.sendingUserId = sendingUserId;
		this.receivingUserId = receivingUserId;
		this.sentDate = sentDate;
		this.originalContent = originalContent;
		this.translatedContent = translatedContent;
	}

	public Message() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public int getSendingUserId() {
		return sendingUserId;
	}

	public void setSendingUserId(int sendingUserId) {
		this.sendingUserId = sendingUserId;
	}

	public int getReceivingUserId() {
		return receivingUserId;
	}

	public void setReceivingUserId(int receivingUserId) {
		this.receivingUserId = receivingUserId;
	}

	public Timestamp getSentDate() {
		return sentDate;
	}

	public void setSentDate(Timestamp sentDate) {
		this.sentDate = sentDate;
	}

	public String getOriginalContent() {
		return originalContent;
	}

	public void setOriginalContent(String originalContent) {
		this.originalContent = originalContent;
	}

	public String getTranslatedContent() {
		return translatedContent;
	}

	public void setTranslatedContent(String translatedContent) {
		this.translatedContent = translatedContent;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", sendingUserId=" + sendingUserId + ", receivingUserId=" + receivingUserId
				+ ", sentDate=" + sentDate + ", originalContent=" + originalContent + ", translatedContent="
				+ translatedContent + "]";
	}
	
}
