package com.itmck.api.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XStreamUtil {

	/**
	 * XMLת����
	 * 
	 * @param clazz ������
	 * @param str   xml�ַ���
	 * @param       <T> T
	 * @return
	 */
	public static <T> T parseFromXml(Class<T> clazz, String xml) {
		// ��������XML����
		XStream xStream = new XStream(new DomDriver());
		// ����ע��
		xStream.processAnnotations(clazz);
		@SuppressWarnings("unchecked")
		// ��XML�ַ���תΪbean����
		T t = (T) xStream.fromXML(xml);
		return t;
	}

	/**
	 * 		����תxml
	 * 
	 * @param obj ����
	 * @return
	 */
	public static String toXml(Object obj) {
		XStream xStream = new XStream(new DomDriver());
		xStream.processAnnotations(obj.getClass());
		return xStream.toXML(obj);
	}
}

