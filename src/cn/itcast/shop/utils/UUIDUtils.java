package cn.itcast.shop.utils;



import java.util.UUID;

/**
 * ��������ַ����Ĺ�����
 * @author LC
 *
 */
public class UUIDUtils {
	/**
	 * ���������ַ���
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
