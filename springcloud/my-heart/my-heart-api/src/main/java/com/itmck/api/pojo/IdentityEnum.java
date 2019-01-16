package com.itmck.api.pojo;

/**
 * 	�Զ���ö������
 * 
 * @author 34745
 *
 */
public enum IdentityEnum {

	STUDENT("ѧ��", 1), TEACHER("��ʦ", 2);
	private String name;
	private int ordinal;

	private IdentityEnum(String name, int ordinal) {
		this.name = name;
		this.ordinal = ordinal;
	}

	public static String getName(int ordinal) {

		for (IdentityEnum it : IdentityEnum.values()) {

			if (it.getOrdinal() == ordinal) {
				return it.name;
			}
		}
		return null;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(int ordinal) {
		this.ordinal = ordinal;
	}

}
