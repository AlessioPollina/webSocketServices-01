package co.devlhope.webSocketServices01.Controller;

import co.devlhope.webSocketServices01.Entities.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationDTO {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping("/broadcast") //Server to Client(page Google Web Socket)
    @SendTo("/broadcast-message")
    public void handleMessageFromWebSocket(@RequestBody MessageDTO message) {
        simpMessagingTemplate.convertAndSend("/topic/broadcast", message);
    }
}
