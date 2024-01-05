package entities;

public class Rights {
	
	//manage fireman
	public static int CAN_READ = 0b00000001;
	public static int CAN_UPDATE = 1 << 1;
	public static int CAN_CREATE = 1 << 2;
	public static int CAN_DELETE = 1 << 3;
	
	//Manage web app
	public static int CAN_CREATE_USER = 1 << 8;
	public static int CAN_DELETE_USER = 1 << 9;
	public static int CAN_BLOCK_USER = 1 << 10;
	public static int CAN_CHANGE_USER_RIGHTS = 1 << 11;
	
	//export and import
	public static int CAN_EXPORT = 1 << 16;
	public static int CAN_IMPORT = 1 << 17;

}
