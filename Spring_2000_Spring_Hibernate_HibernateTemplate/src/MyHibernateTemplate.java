import org.hibernate.Session;


public class MyHibernateTemplate {
	
	public void executeWithNativeSession(MyHibernateCallback callback) {
		
		Session s = null;
		try {
			s = getSession();
			s.beginTransaction();
			
			callback.doInHibernate(s);
			
			s.getTransaction().commit();
		} catch (Exception e) {
			s.getTransaction().rollback();
		} finally {
			// ...
		}
	}
	
	private Session getSession() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
//		new MyHibernateTemplate().executeWithNativeSession(new MyHibernateCallback() {
//					@Override
//					public void doInHibernate(Session s) {
//						s.save(null);
//					}
//				});
		
		class MyHibernateCallbackImpl implements MyHibernateCallback{
			@Override
			public void doInHibernate(Session s) {
				s.save(null);
			}
		}
		
		MyHibernateCallback callback = new MyHibernateCallbackImpl();
		new MyHibernateTemplate().executeWithNativeSession(callback);
		
	}
	
	
	public void save(final Object o) {
		new MyHibernateTemplate()
				.executeWithNativeSession(new MyHibernateCallback() {
					@Override
					public void doInHibernate(Session s) {
						s.save(o);
					}
				});
	}
	
}
