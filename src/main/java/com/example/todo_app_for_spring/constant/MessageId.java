package com.example.todo_app_for_spring.constant;

/**
 * メッセージID定義クラスです。<br>
 * メッセージIDを定義します。<br>
 * メッセージIDは、メッセージプロパティファイルのキーとして使用されます。<br>
 * メッセージIDは、アプリケーション全体で一意である必要があります。<br>
 * メッセージIDは、"M + 数字4桁 + I,W,Eのいづれか1文字"形式です。<br>
 * 数字4桁は、メッセージIDのシーケンス番号です。<br>
 * Iは情報、Wは警告、Eはエラーを表します。<br>
 * メッセージの内容は、メッセージプロパティファイルに定義します。<br>
 */
public class MessageId {

	public static final String M0001E = "M0001E";
	public static final String M0002E = "M0002E";
	public static final String M0003E = "M0003E";
}
