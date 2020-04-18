package endpoints;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/upper")
public class UpperEndPoint {

	@OnMessage
	public void onMessage(Session session, String message) {
		try {
			// System.out.println("message received :" + message);
			session.getBasicRemote().sendText(message.toUpperCase());
		} catch (Exception ex) {
		}
	}
}