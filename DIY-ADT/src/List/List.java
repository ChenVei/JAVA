package List;

import Exception.OutOfBoundaryException;

public interface List {
	// �������Ա��Ĵ�С��������Ԫ�صĸ�����
	public int getSize();

	// ������Ա�Ϊ�շ��� true�����򷵻� false��
	public boolean isEmpty();

	// �ж����Ա��Ƿ��������Ԫ�� e
	public boolean contains(Object e);

	// ��������Ԫ�� e �����Ա��е����
	public int indexOf(Object e);

	// ������Ԫ�� e ���뵽���Ա��� i ��λ��
	public void insert(int i, Object e) throws OutOfBoundaryException;

	// ������Ԫ�� e ���뵽Ԫ�� obj ֮ǰ
	public boolean insertBefore(Object obj, Object e);

	// ������Ԫ�� e ���뵽Ԫ�� obj ֮��
	public boolean insertAfter(Object obj, Object e);

	// ɾ�����Ա������Ϊ i ��Ԫ��,������֮
	public Object remove(int i) throws OutOfBoundaryException;

	// ɾ�����Ա��е�һ���� e ��ͬ��Ԫ��
	public boolean remove(Object e);

	// �滻���Ա������Ϊ i ������Ԫ��Ϊ e������ԭ����Ԫ��
	public Object replace(int i, Object e) throws OutOfBoundaryException;

	// �������Ա������Ϊ i ������Ԫ��
	public Object get(int i) throws OutOfBoundaryException;
}