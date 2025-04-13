package com.example.todo_app_for_spring.utility;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageUtility {

	private static MessageSource messageSource;
	
	public MessageUtility(MessageSource messageSource) {
		MessageUtility.messageSource = messageSource;
	}
	
	/**
	 * メッセージを取得します。
	 * 
	 * @param messageId
	 * @param args
	 * @return
	 */
	public static String getMessage(String messageId, Object... args) {
		return messageSource.getMessage(messageId, args, null);
	}
}
